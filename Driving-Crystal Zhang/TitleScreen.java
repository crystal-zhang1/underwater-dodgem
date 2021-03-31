import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Greenfoot.start();

        Message winMessage = new Message();
        addObject(winMessage, (int) (600 / 2), (int) (400 / 2));
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new MyWorld());
    }
}
