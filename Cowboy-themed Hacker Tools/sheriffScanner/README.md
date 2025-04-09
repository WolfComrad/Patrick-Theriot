
# Sheriff Scanner 🤠

**Sheriff Scanner** is a network scanning tool that helps you detect and analyze devices within a given IP range. Inspired by cowboy and hacker themes, this script scans for active devices, checks their signal strength, and assesses their "wanted level" (based on a custom classification). It can also save the results in a human-readable format for later use.

---

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Arguments](#arguments)
- [Examples](#examples)
- [Output Format](#output-format)
- [License](#license)

---

## Installation

Before using the **Sheriff Scanner**, make sure you have **Python 3.x** installed.

1. Clone or download this repository to your local machine:
    ```bash
    git clone https://github.com/yourusername/sheriff-scanner.git
    ```

2. Navigate to the project directory:
    ```bash
    cd sheriff-scanner
    ```

3. Install any necessary dependencies (if applicable, though this script may run independently):
    ```bash
    pip install -r requirements.txt
    ```

---

## Usage

Once you have the tool installed, you can start using it via the command line.

### Basic Command:
```bash
python scanner.py --range <IP_RANGE>
```

This will scan the provided IP range and print out the results, showing which devices are active, their signal strength, and their wanted level.

---

## Arguments

- `--range <IP_RANGE>`: The IP range to scan (e.g., `192.168.1.0/24`). This is a required argument.
  
- `--save <FILE_NAME>`: Optionally save the results to a text file. If this argument is specified, the results will be written to the provided file name (e.g., `results.txt`). The file will be saved in UTF-8 encoding to handle special characters.

---

## Examples

### 1. Basic Scan
Scan the IP range `192.168.1.0/24` and display the results:
```bash
python scanner.py --range 192.168.1.0/24
```

### 2. Scan with Results Saved to a File
Scan the IP range `192.168.1.0/24` and save the results to `results.txt`:
```bash
python scanner.py --range 192.168.1.0/24 --save results.txt
```

---

## Output Format

The scan results will be presented in a table format with the following columns:

| IP Address   | Signal Strength | Wanted Level |
|--------------|-----------------|--------------|
| 192.168.1.1  | █████           | OUTLAW       |
| 192.168.1.26 | █░░░░           | BANDIT       |
| 192.168.1.38 | █████           | BANDIT       |
| 192.168.1.62 | ███░░           | BANDIT       |
| 192.168.1.126| █░░░░           | BANDIT       |
| 192.168.1.139| █████           | BANDIT       |
| 192.168.1.155| █████           | BANDIT       |
| 192.168.1.156| █████           | BANDIT       |
| 192.168.1.197| █████           | BANDIT       |
| 192.168.1.214| █████           | BANDIT       |

The **"Wanted Level"** is assigned based on the IP's classification (Outlaw, Bandit, etc.).

### Wanted Levels Explained

The **Wanted Level** categorizes the detected hosts into different levels based on their perceived risk or level of suspicion in the network environment. The levels are metaphorically named after outlaws to match the cowboy theme, each reflecting the threat posed by the device in the network.

#### **OUTLAW**
- **Description:** The highest level of suspicion. "OUTLAW" hosts are the most dangerous or suspicious on the network.
- **Explanation:** These hosts may be actively involved in malicious activities or compromised. They represent a high level of risk and should be considered a priority for investigation or exploitation. They may be running unauthorized software, acting as control points for attacks, or participating in other malicious behavior.
- **Typical Action:** In a penetration testing scenario, **OUTLAW** IPs are the first ones to target. From a defensive perspective, these hosts should be isolated immediately to prevent further damage.

#### **BANDIT**
- **Description:** A moderately suspicious level. **BANDIT** hosts are considered to pose a significant but lesser risk than **OUTLAW** hosts.
- **Explanation:** These systems may be misconfigured, running outdated software, or have vulnerabilities that make them easier to compromise. While not actively malicious, they represent an opportunity for exploitation if left unchecked.
- **Typical Action:** These hosts should be further examined to identify weaknesses or points of entry. If performing penetration testing, **BANDIT** systems are a secondary priority, while network defenders should patch, monitor, or isolate these systems as needed.

#### **UNKNOWN**
- **Description:** Represents hosts with an uncertain or unclear risk status.
- **Explanation:** These systems may be new, disguised, or not easily identifiable. They could be legitimate systems with abnormal behavior or could be completely untrusted devices trying to sneak past network defenses.
- **Typical Action:** **UNKNOWN** hosts require further reconnaissance to determine their legitimacy and security risk. In a penetration testing scenario, you may need to probe these systems to gather more data, whereas defenders should place them under surveillance until they can be verified.

---

### How It Affects Your Hacking Strategy

- **First Priority (OUTLAW):** If you're scanning for vulnerabilities and exploiting weaknesses, start with **OUTLAW** hosts. These systems are considered the highest-risk and may provide valuable opportunities for gaining access to sensitive or compromised systems.
  
- **Second Priority (BANDIT):** While not as dangerous as **OUTLAW**, **BANDIT** hosts are still worth investigating. They may have exploitable vulnerabilities, misconfigurations, or weaknesses you can exploit to gain further access or move laterally within the network.

- **Last Priority (UNKNOWN):** These hosts are the most uncertain. It’s best to gather more information before attempting to interact with or target these systems. Further reconnaissance is necessary to determine whether they pose a threat or not.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
