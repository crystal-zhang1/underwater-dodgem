import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Stationary actor, the turtle will eat strawberry to gain points.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Strawberry extends Actor
{
    private boolean debug = false;

    /**
     * Constructor for Strawberry
     */
    public Strawberry() {
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

        while (isTouching(null)) {
            x = Greenfoot.getRandomNumber(worldWidth);
            y = Greenfoot.getRandomNumber(worldHeight);
            if (debug) {
                System.out.println("retry to place the strawberry to new location " + x + " " + y);
            }
            setLocation(x, y);
        }
    }


    
    
    /**
     * Act - do whatever the Strawberry wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
