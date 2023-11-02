import pygame,sys

pygame.init()
clock = pygame.time.Clock()
screen = pygame.display.set_mode([800,800])
font = pygame.font.Font(None,32)
text = ''

#making rect for text
input_rect = pygame.Rect(200,200,140,32)
color_active = pygame.Color('lightskyblue3')
#making "button"
color_passive = pygame.Color('gray15')
color = color_passive
active = False

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
            
        #making "button"
        if event.type == pygame.MOUSEBUTTONDOWN:
            if input_rect.collidepoint(event.pos):
                active = True
            else:
                active = False
                
        #Getting input
        if event.type == pygame.KEYDOWN:
            if active == True:
                if event.key == pygame.K_BACKSPACE:
                    text = text[0:-1]
                else:
                    text += event.unicode
            
    screen.fill((0,0,0))
    
    if active:
        color = color_active
    else:
        color = color_passive
        
    pygame.draw.rect(screen,color,input_rect,2)
    #render the text
    text_surface = font.render(text,True,(255,255,255))
    screen.blit(text_surface,(input_rect.x + 5,input_rect.y + 5))
    
    input_rect.w = max(100,text_surface.get_width() + 10)
    
    pygame.display.flip()
    clock.tick(60)