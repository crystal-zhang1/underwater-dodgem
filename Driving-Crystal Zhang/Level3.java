import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level3 extends Levels {
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3() {
        // Create Level Three World with countdownTimer, totalStrawberries, totalRocks.
        super(3600, 3, 0);
        
        GreenfootImage img = new GreenfootImage("images/ocean_background3.png");
        img.scale(860, 404);
        setBackground(img);
        
        placeShark();
    }

    public void act() {
        
        
        if (Greenfoot.isKeyDown("escape"))
            Greenfoot.setWorld(new TitleScreen()); // return to title screen
        if (Greenfoot.isKeyDown("r"))
            Greenfoot.setWorld(new Level3()); // restart level
        if (Greenfoot.isKeyDown("x"))
            Greenfoot.stop(); // stops program
    }
}
