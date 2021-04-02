import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TimeLeft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeLeft extends Actor
{
    int timeLeft = 3600;
    
    public void updateTime() {
        timeLeft--;
    }
    
    /**
     * Act - do whatever the TimeLeft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int timeSeconds = timeLeft/60;
        setImage(new GreenfootImage("Time Left: " + timeSeconds + "s", 24, Color.WHITE, Color.CYAN));
    }    
}
