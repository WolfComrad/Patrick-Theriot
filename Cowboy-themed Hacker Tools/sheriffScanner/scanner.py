import argparse
import subprocess
import concurrent.futures
import ipaddress
from rich.console import Console
from rich.table import Table
from time import sleep
from saloon import fake_scan_results    # Keeping this for backup fake data
from utils import show_ascii_art, get_random_phrase

console = Console()

def parse_args():
    parser = argparse.ArgumentParser(description="Sheriff Scanner - A cowboy-themed WiFi scanner CLI tool")
    parser.add_argument(
        '--range',
        type=str,
        help="Specify the IP range to scan (e.g. 192.168.1.0/24)",
        default=None
    )
    parser.add_argument(
        '--save',
        type=str,
        help="Specify a file name to save the results (e.g. results.txt)",
        default=None
    )
    return parser.parse_args()

import random

def get_signal_strength(ms):
    """Simulates the signal strength based on ping response time."""
    if ms < 50:
        return "█████"  # Strong signal
    elif ms < 150:
        return "███░░"  # Medium signal
    else:
        return "█░░░░"  # Weak signal

def get_wanted_level(ip_address):
    """Assigns a fixed wanted level based on the IP address from a hacker's perspective."""
    
    # OUTLAW: Critical systems or valuable targets (e.g., admin servers)
    if ip_address == "192.168.1.1":
        return "OUTLAW"  # This is your first go-to target, typically an admin or server IP.
    
    # BANDIT: Secondary targets, normal user systems or systems of interest
    elif ip_address.startswith("192.168.1.") or ip_address.startswith("10.0.0."):
        return "BANDIT"  # Secondary IPs to target in a specific range, maybe regular machines.
    
    # UNKNOWN: Rogue, unauthorized systems or devices
    elif ip_address.startswith("192.168.0.") or ip_address.startswith("172.16."):
        return "UNKNOWN"  # These systems shouldn't be here, they might be non-compliant or rogue.

    # Default case: any other IPs fall into "UNKNOWN"
    return "UNKNOWN"  # Any other IP gets an "UNKNOWN" status, possibly unauthorized devices.


def ping_ip(ip_address):
    """Pings a given IP address and returns the result with signal strength and wanted level."""
    response = subprocess.run(
        ['ping', '-n', '1', '-w', '1000', str(ip_address)],  # Convert IPv4Address to string
        stdout=subprocess.PIPE, stderr=subprocess.PIPE
    )
    
    if response.returncode == 0:
        # Get the round-trip time (RTT) in milliseconds
        output = response.stdout.decode()
        if 'time=' in output:
            time_ms = int(output.split('time=')[1].split('ms')[0].strip())
            
            # Get the signal strength based on the ping time
            signal_strength = get_signal_strength(time_ms)
            
            # Get the wanted level based on the IP
            wanted_level = get_wanted_level(str(ip_address))
            
            return str(ip_address), signal_strength, wanted_level
        else:
            # If the time is not in the output, treat it as a failure
            return None
    else:
        # If the ping command failed (non-zero returncode), return None
        return None


def real_scan(range_str):
    """Scans a given IP range for active hosts, displaying signal strength and wanted level."""
    # Parse the input range to handle CIDR notation
    network = ipaddress.IPv4Network(range_str, strict=False)
    
    active_hosts = []
    
    # Handle /30 range (two usable IPs)
    if network.prefixlen == 30:
        # Get the usable hosts for a /30 network
        usable_ips = list(network.hosts())  # Get only usable IPs
        
        # Ping the usable IP addresses
        with concurrent.futures.ThreadPoolExecutor(max_workers=30) as executor:
            results = executor.map(ping_ip, usable_ips)
            
            for result in results:
                if result is not None:
                    ip, signal_strength, wanted_level = result
                    active_hosts.append((ip, signal_strength, wanted_level))
    else:
        # Handle other CIDR subnets (e.g., /24, /16, etc.)
        base_ip = range_str.rsplit('.', 1)[0]  # Get the first 3 octets of the IP range
        ip_addresses = [f"{base_ip}.{ip_num}" for ip_num in range(1, 255)]
        
        # Use ThreadPoolExecutor to ping multiple IPs concurrently
        with concurrent.futures.ThreadPoolExecutor(max_workers=30) as executor:
            results = executor.map(ping_ip, ip_addresses)
            
            for result in results:
                if result is not None:
                    ip, signal_strength, wanted_level = result
                    active_hosts.append((ip, signal_strength, wanted_level))
    
    return active_hosts

def get_default_range():
    """Get the default local network range."""
    import socket
    # Get the local IP address of the machine
    ip = socket.gethostbyname(socket.gethostname())

    # Extract the first 3 octets of the local network
    base_ip = '.'.join(ip.split('.')[:3]) + '.0/24'
    
    return base_ip

def display_results(active_hosts):
    """Displays the results in a table."""
    table = Table(title="🏜️  Saloon Signals Found")
    
    table.add_column("IP Address", style="cyan")
    table.add_column("Signal Strength", style="magenta")
    table.add_column("Wanted Level", style="red")
    
    for host in active_hosts:
        ip, signal_strength, wanted_level = host
        table.add_row(ip, signal_strength, wanted_level)
    
    console.print(table)

def main():
    args = parse_args()

    console.print(f"[bold green]Howdy, partner! Bootin' up the scanner...[/bold green]")
    show_ascii_art()    
    console.print(f"[bold green]{get_random_phrase()}[/bold green]\n")
    sleep(1)
    
    # Check if a custom range is provided
    if args.range:
        console.print(f"[yellow]Scanning the range: {args.range}...[/yellow]")
        active_hosts = real_scan(args.range)
        if active_hosts:
            console.print(f"[yellow]Found the following active hosts in the range {args.range}:[/yellow]")
        else:
            console.print(f"[red]No active hosts found in the range {args.range}.[/red]")
    else:
        # If no range is provided, use the default range
        default_range = get_default_range()
        console.print(f"[yellow]No range provided. Using default range: {default_range}[/yellow]")
        sleep(2)
        active_hosts = real_scan(default_range)
    
    # Call display_results to show the results in the table format
    display_results(active_hosts)
    
    # Save the results to a file if specified
    if args.save:
        with open(args.save, 'w', encoding='utf-8') as f:  # Added encoding='utf-8'
            f.write("Saloon Scanner Report\n\n")
            for host in active_hosts:
                f.write(f"{host[0]} | {host[1]} | {host[2]}\n")
        console.print(f"[green]Report saved to {args.save}[/green]")
    else:
        console.print("\n[bold blue]Report delivered, Sheriff. Time to round 'em up![/bold blue]")

if __name__ == "__main__":
    main()
