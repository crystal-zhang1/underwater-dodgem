import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays panel for number of lives on the world
 * 
 * @author (Crystal Zhang) 
 * @version 1.0.0
 */
public class LivesCount extends Actor
{
    /**
     * Constructor for LivesCount
     * @param lives int Number of lives
     */
    public LivesCount(int lives) {
        showLives(lives);
    }
    
    /**
     * Sets the image for number of lives
     */
    public void showLives(int lives) 
    {
        setImage(new GreenfootImage("Lives: " + lives, 24, Color.WHITE, Color.BLUE));
    }    
}
