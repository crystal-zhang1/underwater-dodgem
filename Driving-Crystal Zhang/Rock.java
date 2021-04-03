import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Rock class that sets image for rock, adds to world, and checks to see if rock is touching anything.
 * 
 * @author (Crystal Zhang) 
 * @version 1.0.0
 */
public class Rock extends Actor
{
    private boolean debug = false;

    /**
     * Constructor for Rock class that sets and scales image for rock
     */
    public Rock() {
        GreenfootImage img = new GreenfootImage("images/rock.png");
        img.scale(60, 60);
        setImage(img);
    }

     /**
      * Method to check if rock is touching another rock or strawberry and moves to
     * another location if it is
      * @param world World The world rock is in
      */
    public void addedToWorld(World world) {
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int x = getX();
        int y = getY();

        if (debug) {
            System.out.println("Placed the rock to location: " + x + " " + y);
        }

        // If not touching anything, put into world
        while (isTouching(null)) {
            int xRange = (world.getClass() == Level1.class) ? worldWidth : worldWidth/2;
            x = Greenfoot.getRandomNumber(xRange);
            y = Greenfoot.getRandomNumber(worldHeight);
            if (debug) {
                System.out.println("retry to place the rock to new location " + x + " " + y);
            }
            setLocation(x, y);
        }
    }

    /**
     * Method to check if rock is touching pufferfish
     */
    void touchingPufferfish() {
        List<Pufferfish> pufferfishTouching = getIntersectingObjects(Pufferfish.class);
        
        // If touching pufferfish, remove the pufferfish
        if (pufferfishTouching != null) {
            int numTouching = pufferfishTouching.size();
            if (numTouching > 0) {
                Levels levels = (Levels) getWorld();
                levels.removeObjects(pufferfishTouching);
            }
        }
    }

    /**
     * Calls method touchingPufferfish
     */
    public void act() 
    {
        touchingPufferfish();
    }    
}
