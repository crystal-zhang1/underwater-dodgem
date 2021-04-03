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
    
    protected boolean debug = false;
    /**
     * Constructor for class Animals.
     */
    public Animals() {
        this(0, 12);

    }
    
     /**
      * Constructor that accepts speed and max speed
      * @param speed Default speed that the animal will move at
      * @param maxSpeed Maxiumum speed that the animal will be able to move at
      */
    public Animals(int speed, int maxSpeed) {
        this("Animal", speed, maxSpeed);
    }

    /**
     * Constructor that accepts the animal type, speed, and maximum speed
     * @param animalType 
     * @param speed Default speed that the animal will move at
     * @param maxSpeed Maxiumum speed that the animal will be able to move at
      */
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

    /**
     * Increases or decreases speed of the car
     * 
     * @param speedChange Accelerate by the speed change value
     */
    public void accelerate(int speedChange) {
        speed = speed + speedChange;
        if (speed < 0) {
            speed = 0;
        } else if (speed > maxSpeed) {
            speed = maxSpeed;
        }
    }

    /**
     * Checks to see if car is touching edge of world
     * 
     * @return String Returns "top", "bottom", "left", "right", or null depending on the world edge that is animal is touching.
     */
    public String isTouchingEdge() {
        boolean isTouchingEdge;

        // Gets location of animal
        int x = getX();
        int y = getY();

        // Get world width and height
        World world = getWorld();
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

    /** 
     * Wraps actor when it reaches the edge of the world.
     * 
     */
    public void wrap() {
        String edge = isTouchingEdge();

        // Gets location of animal
        int x = getX();
        int y = getY();

        // Get world width and height
        World world = getWorld();
        int rightEdge = world.getWidth();
        int bottomEdge = world.getHeight();

        if (debug) System.out.println(edge + ". x is " + x + " and y is " + y);

        if (edge == "bottom") {
            if (debug) System.out.println("actor at bottom");
            // Sets actor location to top edge of world
            setLocation(x, 0); 
        } else if(edge == "top") {
            // Sets actor location to bottom edge of world
            setLocation (x, bottomEdge);
            if (debug) System.out.println("actor at top");
        } else if (edge == "left") {
            // Sets actor location to right edge of world
            setLocation(rightEdge, y); 
            if (debug) System.out.println("actor at left");
        } else if (edge == "right") {
            // Sets actor location to left edge of world
            setLocation(0, y); 
            if (debug) System.out.println("actor at right");
        } 
    }

    /**
     * Setter for animalType
     * @param animalType 
     */
    public void setAnimalType(String animalType) {
        this.animalType = animalType;

    }

    /**
     * Setter for speed
     * @param speed Animal speed
     */
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

    /**
     * Setter for maxSpeed
     * @param maxSpeed Maxiumum speed actor can move
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Getter for animalType
     * @return String
     */
    public String getAnimalType() {
        return this.animalType;
    }

    /**
     * Getter for speed
     * @return int Gets speed actor moves at
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Getter for maxSpeed
     * @return int Gets maximum speed actor can move 
     */
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    /**
     * Moves and wraps Animal. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // car moves at set speed 
        move(this.speed);
        wrap();
        
    }    
}
