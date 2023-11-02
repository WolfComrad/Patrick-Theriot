import pygame, sys, random

# Class/sprite
class Crosshair(pygame.sprite.Sprite):
    def __init__(self, pic_path):
        super().__init__()
        self.image = pygame.image.load(pic_path)
        self.rect = self.image.get_rect()
        self.gunshot = pygame.mixer.Sound("gunShot.wav")
    def shoot(self):
        self.gunshot.play()
        pygame.sprite.spritecollide(crosshair,target_group,True)
    def update(self):
        self.rect.center = pygame.mouse.get_pos()

class Target(pygame.sprite.Sprite):
    def __init__(self,pic_path,pos_x,pos_y):
        super().__init__()
        self.image = pygame.image.load(pic_path)
        self.rect = self.image.get_rect()
        self.rect.center = [pos_x,pos_y]
        
# Making multiple stages
class GameState():
    def __init__(self):
        self.state = 'intro'
        
    def intro(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.MOUSEBUTTONDOWN:
                self.state = 'main_game'
            
        screen.blit(background,(0,0))
        screen.blit(ready_text,textRect)
        crosshair_group.draw(screen)
        crosshair_group.update()
        pygame.display.flip()
        
    def main_game(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.MOUSEBUTTONDOWN:
                crosshair.shoot()
            
        pygame.display.flip()
        screen.blit(background,(0,0))
        target_group.draw(screen)
        crosshair_group.draw(screen)
        crosshair_group.update()
        
    def state_manager(self):
        if self.state == 'intro':
            self.intro()
        if self.state == 'main_game':
            self.main_game()
        
pygame.init()
clock = pygame.time.Clock()
game_state = GameState()

width = 1920
height = 1080
screen = pygame.display.set_mode((width,height))
background = pygame.image.load("desert_BG.png")
font = pygame.font.Font('freesansbold.ttf', 32)
ready_text = font.render("ARE YOU READY!!", True, (255,255,255))
textRect = ready_text.get_rect()
textRect.center = (width//2,height//2)
# Setting mouse visibility
pygame.mouse.set_visible(False)

# Making an object/sprite
crosshair = Crosshair("crosshair.png")
# Making a group for the sprite
crosshair_group = pygame.sprite.Group()
crosshair_group.add(crosshair)

# Making targets
target_group = pygame.sprite.Group()
for target in range(20):
    new_target = Target("target.png",random.randrange(0,width),random.randrange(0,height))
    target_group.add(new_target)

while True:
    game_state.state_manager()
    clock.tick(60)