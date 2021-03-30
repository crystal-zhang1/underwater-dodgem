import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turtle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turtle extends Animals
{
    //constructor that calls constructor from parent class
    public Turtle() {
        super();
    }

    public Turtle(String licensePlate, int speed, int maxSpeed) {
        super(licensePlate, speed, maxSpeed);
    }

    /**
     * Act - do whatever the Turtle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("up")) {
            accelerate(1);
        }
        if (Greenfoot.isKeyDown("down")) {
            accelerate(-1);
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
