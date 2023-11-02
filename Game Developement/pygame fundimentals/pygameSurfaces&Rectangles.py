import pygame, sys

# General setup
pygame.init()
clock = pygame.time.Clock()

# Create the display surface
screen = pygame.display.set_mode((800,800)) # ((width,height))
# 2nd surface
second_surface = pygame.Surface([100,200]) # ([width, height])
# putting color in the second_surface
second_surface.fill((0,0,255))

# importing a picture
pic = pygame.image.load('CaptainRex.jpg')
# puts a rect around pic
pic_rect = pic.get_rect(topleft = [100,200]) # (pointOfRect = [position_x,position_y])

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
            
    screen.fill((255,255,255)) # ((r,g,b)) a number from 0-255
    # displaying second_surface
    screen.blit(second_surface,(0,50)) # (surface,(location_x,location_y))
    
    # displaying pic
        #screen.blit(pic,(100,200))
    
    # Conecting the pic and rect
    screen.blit(pic,pic_rect)
    # Moving the rect/pic
    pic_rect.right += 5
    
    pygame.display.flip()
    clock.tick(60)