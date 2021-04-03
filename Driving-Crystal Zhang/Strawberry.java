import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Stationary actor, the turtle will eat strawberry to gain points (increase score).
 * 
 * @author (Crystal Zhang) 
 * @version 1.0.0
 */
public class Strawberry extends Actor
{
    private boolean debug = false;

    /**
     * Constructor for Strawberry
     */
    public Strawberry() {
        // Set image for strawberry and scales image
        GreenfootImage img = new GreenfootImage("images/strawberry.png");
        img.scale(20, 25);
        setImage(img);
    }
    
    /**
     * Checks to see if strawberry is touching another strawberry and moves to
     * another location if it is
     */
    public void addedToWorld(World world) {
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int x = getX();
        int y = getY();

        if (debug) {
            System.out.println("Placed the strawberry to location: " + x + " " + y);
        }

        // If not touching anything, put strawberry into world at random location
        while (isTouching(null)) {
            x = Greenfoot.getRandomNumber(worldWidth);
            y = Greenfoot.getRandomNumber(worldHeight);
            if (debug) {
                System.out.println("retry to place the strawberry to new location " + x + " " + y);
            }
            setLocation(x, y);
        }
    }   
}
