import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World for level 1.
 * 
 * @author (Crystal Zhang)
 * @version (1.0.0)
 */
public class Level1 extends Levels {

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1() {
        // Create Level One World with countdownTimer, totalStrawberries, totalRocks.
        super(3600, 6, 7);

        // Set spawn timer to zero
        spawnTimer = 0;
    }

    /** 
     * Method to generate pufferfish in world
     */
    public void generatePufferfishes() {
        // Get width and height of world
        int worldWidth = getWidth();
        int worldHeight = getHeight();

        // Add pufferfish to random height at right edge of world
        int y = Greenfoot.getRandomNumber(worldHeight);
        Pufferfish pufferfish = new Pufferfish("pufferfish", 1, 3);
        addObject(pufferfish, worldWidth, y);
    }

}
