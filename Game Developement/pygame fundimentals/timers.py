import pygame, sys

# pygame set up
pygame.init()
screen = pygame.display.set_mode((800,800))
clock = pygame.time.Clock()

# Timer
current_time = 0
button_pressed_time = 0

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        if event.type == pygame.KEYDOWN:
            button_pressed_time = pygame.time.get_ticks()
            screen.fill((255,255,255))
    # Getting current time        
    current_time = pygame.time.get_ticks()
    
    if current_time - button_pressed_time > 2000:
        screen.fill("black")
            
    # Printing times
    print(f"current time: {current_time} button pressed time: {button_pressed_time}")
    
    pygame.display.flip()
    clock.tick(60)