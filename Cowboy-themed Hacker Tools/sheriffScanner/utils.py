# utils.py

from rich import print

ASCII_COWBOY = r"""
    🤠 Sheriff Scanner 🤠
         _       _
        | |     | |
        | | ___ | |__   __ _ _ __ ___
        | |/ _ \| '_ \ / _` | '__/ _ \
        | | (_) | | | | (_| | | |  __/
        |_|\___/|_| |_|\__, |_|  \___|
                        __/ |
                       |___/
"""
    
COWBOY_PHRASES = [
    "Tumbleweed’s rollin’, better keep an eye out...",
    "Them signals are sneakier than a rattlesnake in a boot.",
    "Tumbleweed’s blowin’ through the digital plains...",
    "Outlaws better watch out, Sheriff’s on the prowl!",
    "Keep your boots clean, partner, we’re huntin’ outlaws today!",
    "This range ain't big enough for all them signals!",
    "It’s high noon, let’s rustle up some signals!"
]

def show_ascii_art():
    print(f"[bold yellow]{ASCII_COWBOY}[/bold yellow]")
    
def get_random_phrase():
    import random
    return random.choice(COWBOY_PHRASES)