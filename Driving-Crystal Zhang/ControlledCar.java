import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlledCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlledCar extends Car
{
    //constructor that calls constructor from parent class
    public ControlledCar() {
        super();
    }

    public ControlledCar(String licensePlate, int speed, int maxSpeed) {
        super(licensePlate, speed, maxSpeed);
    }

    /**
     * Act - do whatever the ControlledCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("w")) {
            accelerate(1);
        }

        if (Greenfoot.isKeyDown("right")) {
            turn(5);
        }
        if (Greenfoot.isKeyDown("left")) {
            turn(-5);
        }

        move(getSpeed());
        wrap();


    }    
}
