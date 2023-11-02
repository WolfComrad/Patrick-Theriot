import pygame, sys

def rotate(surface,angle):
    rotated_surface = pygame.transform.rotozoom(surface,-angle,1) # +angle -> counterclockwise, -angle -> clockwise
    rotated_rect = rotated_surface.get_rect(center=(300,300))
    return rotated_surface,rotated_rect

pygame.init()
clock = pygame.time.Clock()
screen = pygame.display.set_mode([600,600])
pic = pygame.image.load("CaptainRex.jpg")
#pic = pygame.Surface((200,200),pygame.SRCALPHA)  ->  this draws a rotating surface with clear background. SRCALPHA = clear background
pic_rect = pic.get_rect(center=(300,300))
angle = 0

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
            
    angle += 1
    screen.fill((255,255,255))
    pic_rotated,pic_rotated_rect = rotate(pic,angle)
    
    screen.blit(pic_rotated,pic_rotated_rect)
    pygame.display.flip()
    clock.tick(30)