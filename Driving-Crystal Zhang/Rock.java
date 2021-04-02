import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        img.scale(70, 70);
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
            x = Greenfoot.getRandomNumber(worldWidth);
            y = Greenfoot.getRandomNumber(worldHeight);
            if (debug) {
                System.out.println("retry to place the rock to new location " + x + " " + y);
            }
            setLocation(x, y);
        }
    }
    
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
