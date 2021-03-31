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
     * Checks to see if strawberry is touching another strawberry or the edge of world and moves to
     * another location if it is
     */
    protected void addedToWorld(World world) {
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int x = getX();
        int y = getY();

        if (debug) {
            System.out.println("Placed the ball to location: " + x + " " + y);
        }

        while (isTouching(null)) {
            x = Greenfoot.getRandomNumber(worldWidth);
            y = Greenfoot.getRandomNumber(worldHeight);
            if (debug) {
                System.out.println("retry to place the ball to new location " + x + " " + y);
            }
            setLocation(x, y); // get new location if ball is touching edge
        }
    }

    public void spawnStrawberries() {
        World world = getWorld();
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();

        int randX = Greenfoot.getRandomNumber(worldWidth);
        int randY = Greenfoot.getRandomNumber(worldHeight);

        Strawberry strawberry = new Strawberry();
        while (isTouching(null)) {
            randX = Greenfoot.getRandomNumber(worldWidth);
            randY = Greenfoot.getRandomNumber(worldHeight);
            if (debug) {
                System.out.println("retry to place the ball to new location " + randX + " " + randY);
            }
            setLocation(randX, randY); // get new location if strawberry is touching edge
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
