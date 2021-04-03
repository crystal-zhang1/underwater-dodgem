import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    protected GreenfootSound backgroundMusic;
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    { 
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Greenfoot.start();

        GreenfootImage img = new GreenfootImage("images/underwater_title_screen_background.png");
        img.scale(610, 420);
        setBackground(img);
        
        Message winMessage = new Message();
        //addObject(winMessage, (int) (600 / 2), (int) (400 / 2));
        
        backgroundMusic = new GreenfootSound("sounds/background_music2.mp3");
        backgroundMusic.playLoop();
    }

    public void act()
    {
        
        //to goes to level depending on key pressed
        if (Greenfoot.isKeyDown("1")) {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Level1()); //level 1
        }
        
        if (Greenfoot.isKeyDown("2")) {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Level2()); //level 2
        }
        
        
        if (Greenfoot.isKeyDown("3")) {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Level3()); //level 3
        }
    }
}
