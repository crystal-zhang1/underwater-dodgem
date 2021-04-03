import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The screen showing the user wins the game.
 * 
 * @author Crystal Zhang 
 * @version 1.0.0
 */
public class WinScreen extends World
{
    private static int WORLD_WIDTH = 600;
    private static int WORLD_HEIGHT = 400;

    /**
     * Constructor for objects of class WinScreen.
     * 
     * @param score The winning score passed to the WinScreen
     */
    public WinScreen(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 

        // Set image for win screen panel
        GreenfootImage img = new GreenfootImage("images/underwater_win_screen_background.png");

        // Set image size to cover the world
        img.scale(WORLD_WIDTH, WORLD_HEIGHT);
        setBackground(img);

        // Create a score count panel with the winning score
        ScoreCount scoreCount = new ScoreCount(score);

        // Add the score count panel to the world
        addObject(scoreCount, WORLD_WIDTH/2, 160);
    }

    /**
     * Act - Press "enter" to go back to the Title Screen
     * Press "x" to stop the running the game
     */
    public void act() {
        if (Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new TitleScreen()); //TitleScreen

        if (Greenfoot.isKeyDown("x")) Greenfoot.stop(); // stops running

    }
}
