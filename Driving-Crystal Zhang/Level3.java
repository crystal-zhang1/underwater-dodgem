import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World for third level
 * 
 * @author (Crystal Zhang)
 * @version 1.0.0
 */
public class Level3 extends Levels {
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3() {
        // Create Level Three World with countdownTimer, totalStrawberries, totalRocks.
        super(3600, 3, 0);

        // Generates background image for this world
        GreenfootImage img = new GreenfootImage("images/ocean_background3.png");
        img.scale(860, 404);
        setBackground(img);

        // Adds shark to world
        placeShark();
    }

}
