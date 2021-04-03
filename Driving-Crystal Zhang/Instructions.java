import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{

    protected GreenfootSound backgroundMusic;
    
    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        GreenfootImage img = new GreenfootImage("images/instructions_background.png");
        img.scale(600, 400);
        setBackground(img);
        
        backgroundMusic = new GreenfootSound("sounds/background_music2.mp3");
        backgroundMusic.playLoop();
    }

    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            backgroundMusic.stop();
            Greenfoot.setWorld(new TitleScreen()); // return to title screen
        }
        
        if (Greenfoot.isKeyDown("x")) {
            backgroundMusic.stop();
            Greenfoot.stop();
        }
    }
}
