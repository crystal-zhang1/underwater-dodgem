import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    private boolean debug = false;

    public Rock() {
        GreenfootImage img = new GreenfootImage("images/rock.png");
        img.scale(60, 60);
        setImage(img);
    }

    /**
     * Checks to see if rock is touching another rock or strawberry and moves to
     * another location if it is
     */
    public void addedToWorld(World world) {
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int x = getX();
        int y = getY();

        if (debug) {
            System.out.println("Placed the rock to location: " + x + " " + y);
        }

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

    void touchingPufferfish() {
        List<Pufferfish> pufferfishTouching = getIntersectingObjects(Pufferfish.class);
        if (pufferfishTouching != null) {
            int numTouching = pufferfishTouching.size();
            if (numTouching > 0) {
                Levels levels = (Levels) getWorld();
                levels.removeObjects(pufferfishTouching);
            }
        }
    }

    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        touchingPufferfish();
    }    
}
