import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class GameOver is displayed when all lives are lost.
 * 
 * @author (Crystal) 
 * @version (1.0.0)
 */
public class GameOver extends World
{
    // Initialize variables
    protected ScoreCount scoreCount;
    protected GreenfootSound backgroundSound;

    private boolean debug = false;

    /**
     * Constructor for objects of class GameOver.
     * @param score The number of strawberries the turtle eats
     * @param backgroundSoundIn The background sound that is played when player dies
     */
    public GameOver(int score, GreenfootSound backgroundSoundIn)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        // Generates background image for GameOver world
        GreenfootImage img = new GreenfootImage("images/game_over_background.png");
        img.scale(600, 400);
        setBackground(img);

        // Create a new scoreCount panel
        ScoreCount scoreCount = new ScoreCount(score);
        addObject(scoreCount, 300, 160);
        
        // Set backgroundSound by using input parameter
        backgroundSound = backgroundSoundIn;
    }

    /**
     * Brings user to TitleScreen world or stops the program if specified key is pressed. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Return user to title screen
        if (Greenfoot.isKeyDown("enter")) {
            backgroundSound.stop();
            if(debug) System.out.println("stop sound");
            Greenfoot.setWorld(new TitleScreen()); // return to title screen
        }
        
        // Stops the program
        if (Greenfoot.isKeyDown("x")) {
            Greenfoot.stop();
        }
    }
}
