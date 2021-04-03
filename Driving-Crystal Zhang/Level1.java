import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World class for "Constructors" assignment. Includes Animals
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

        spawnTimer = 0;
    }

    public void generatePufferfishes() {
        int worldWidth = getWidth();
        int worldHeight = getHeight();

        int y = Greenfoot.getRandomNumber(worldHeight);
        Pufferfish pufferfish = new Pufferfish("rand", 1, 3); // create Pufferfish
        addObject(pufferfish, worldWidth, y);
    }

}
