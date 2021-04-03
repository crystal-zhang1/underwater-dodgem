import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (Crystal Zhang)
 * @version 1.0.0
 */
public class Level2 extends Levels {

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2() {
        // Create Level Two World with countdownTimer, totalStrawberries, totalRocks.
        super(3600, 3, 3);

        // Generates background image for this world
        GreenfootImage img = new GreenfootImage("images/ocean_background2.jpg");
        img.scale(600, 400);
        setBackground(img);

    }
    
    /**
     * Generates pufferfish into world and increases rate of spawn
     */
    public void act() {
        spawnTimer = (spawnTimer + 1) % (90 * frequency / 1000);
        if (spawnTimer == 1) // at each timer reset
        {
            generatePufferfishes();
        }

        if (frameNum == 120) { // after 120 act cycles (2 seconds), rate of pufferfish spawn will increase
            increasePufferfish();
            frameNum = 0;
        } else {
            frameNum++;
        }
        if (debug) System.out.println("frameNum: " + frameNum);



    }

}
