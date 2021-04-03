import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates panel for time left and displays into world.
 * 
 * @author (Crystal Zhang) 
 * @version 1.0.0
 */
public class TimeLeft extends Actor
{
    // Initialize variable 
    int timeLeft = 3600; // Sets the total countdown time to 60 seconds
    
    /**
     * Method that updates the time
     */
    public void updateTime() {
        timeLeft--;
    }
    
    /**
     * Displays the time left in seconds (by convertng time left in act cycles to seconds)
     */
    public void act() 
    {
        int timeSeconds = timeLeft/60;
        setImage(new GreenfootImage("Time Left: " + timeSeconds + "s", 24, Color.WHITE, Color.CYAN));
    }    
}
