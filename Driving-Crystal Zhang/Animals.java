import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Actor class for animals with an explicit constructor.
 * 
 * @author (Crystal Zhang) 
 * @version (1.0.0)
 */
public class Animals extends Actor
{
    //initialize variables
    private String animalType;
    private int speed;
    private int maxSpeed;
    private boolean debug = false;
    /**
     * Constructor for class Animals.
     * 
     */
    public Animals() {
        this(0, 120);

    }

    // constructor that accepts speed and max speed
    public Animals(int speed, int maxSpeed) {
        this("ABCD123", speed, maxSpeed);

    }

    // constructor that accepts license plate, speed and max speed
    public Animals(String animalType, int speed, int maxSpeed) {
        this.animalType = animalType;

        // ensures speed is not less than 0
        if (speed >= 0) {
            this.speed = speed;
        }
        else {
            this.speed = 0;
        }

        // ensures speed is not greater than max speed
        if (speed > maxSpeed) {
            this.speed = maxSpeed;
        }

        // ensures max speed is not less than 0
        if (maxSpeed >= 0) {
            this.maxSpeed = maxSpeed;
        }
        else {
            this.maxSpeed = 0;
        }

    }
    //increases or decreases speed of the car
    public void accelerate(int speedChange) {
        speed = speed + speedChange;
        if (speed < 0) {
            speed = 0;
        } else if (speed > maxSpeed) {
            speed = maxSpeed;
        }
    }

    //checks to see if car is touching edge of world
    public String isTouchingEdge() {
        boolean isTouchingEdge;
        int x = getX();
        int y = getY();

        World world = getWorld();
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int rightEdge = world.getWidth();
        int bottomEdge = world.getHeight();

        if (y <= 0) {
            return "top";
        } else if (y >= bottomEdge) {
            return ("bottom");
        } else if (x <= 0) {
            return "left";
        } else if (x >= rightEdge) {
            return "right";
        } else {
            return null;
        }

    }

    public void wrap() {
        String edge = isTouchingEdge();

        int x = getX();
        int y = getY();

        World world = getWorld();
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        int rightEdge = world.getWidth();
        int bottomEdge = world.getHeight();

        if (debug) System.out.println(edge + ". x is " + x + " and y is " + y);
        if (edge == "bottom") {
            if (debug) System.out.println("car at bottom");
            setLocation(x, 0);
        } else if(edge == "top") {
            setLocation (x, bottomEdge);
            if (debug) System.out.println("car at top");
        } else if (edge == "left") {
            setLocation(rightEdge, y);
            if (debug) System.out.println("car at left");
        } else if (edge == "right") {
            setLocation(0, y);
            if (debug) System.out.println("car at right");
        } 
    }

    // license plate setter
    public void setLicensePlate(String animalType) {
        this.animalType = animalType;

    }

    // speed setter
    public void setSpeed(int speed) {
        // ensures speed is not less than 0
        if (speed >= 0) {
            this.speed = speed;
        }
        else {
            this.speed = 0;
        }

        // ensures speed is not greater than max speed
        if (speed > this.maxSpeed) {
            this.speed = this.maxSpeed;
        }

    }

    //maxSpeed setter
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;

    }

    // animalType getter
    public String getAnimalType() {
        return this.animalType;
    }

    // speed getter
    public int getSpeed() {
        return this.speed;
    }

    // maxSpeed getter
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    /**
     * Act - do whatever the Animals wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // car moves at set speed 
        move(this.speed);
        wrap();
        
    }    
}
