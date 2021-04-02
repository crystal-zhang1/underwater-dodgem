import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LivesCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LivesCount extends Actor
{
    public LivesCount(int lives) {
        showLives(lives);
    }
    
    /**
     * Act - do whatever the LivesCount wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void showLives(int lives) 
    {
        setImage(new GreenfootImage("Lives: " + lives, 24, Color.WHITE, Color.BLUE));
    }    
}
