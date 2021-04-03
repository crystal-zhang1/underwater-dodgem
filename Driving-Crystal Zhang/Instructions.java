import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Adds background image with instructions to game and plays background music.
 * 
 * @author Crystal 
 * @version 1.0.0
 */
public class Instructions extends World
{
    // Initialize variable
    protected GreenfootSound backgroundMusic;
    
    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        // Generates background image for this world
        GreenfootImage img = new GreenfootImage("images/instructions_background.png");
        img.scale(600, 400);
        setBackground(img);
        
        // Set and play background sound
        backgroundMusic = new GreenfootSound("sounds/background_music2.mp3");
        backgroundMusic.playLoop();
    }

    /**
     * Brings user to TitleScreen or stops the program if specified key is pressed.
     */
    public void act() {
        // Return user to title screen
        if (Greenfoot.isKeyDown("enter")) {
            backgroundMusic.stop();
            Greenfoot.setWorld(new TitleScreen()); // return to title screen
        }
        
        // Stop program
        if (Greenfoot.isKeyDown("x")) {
            backgroundMusic.stop();
            Greenfoot.stop();
        }
    }
}
