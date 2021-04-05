import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shark is an obstacle that will move around randomly.
 * 
 * @author (Crystal Zhang) 
 * @version 1.0.0
 */
public class Shark extends Animals
{
    // Initialize variable
    private int frameNum;

    /**
     * Constructor for Shark with 3 parameters.
     * @param animalType
     * @param speed Default speed that the animal will move at
     * @param maxSpeed Maxiumum speed that the animal will be able to move at
     */
    public Shark(String animalType, int speed, int maxSpeed) {
        super(animalType, speed, maxSpeed);
        frameNum = 0;

        // Set image for shark and scales image
        GreenfootImage img = new GreenfootImage("images/shark.png");
        img.scale(100, 50);
        setImage(img);
    }

    /**
     * Method for shark to randomly turn
     */
    public void randomTurn() {
        // Turn shark random amount between -12 and 12 degrees
        int turnAmount= Greenfoot.getRandomNumber(24) - 12; 

        // Gets random number from 0 to 100
        int chanceOfTurn = Greenfoot.getRandomNumber(101); 

        // Shark has 10 percent chance of turning every frame
        if (chanceOfTurn < 10) { 
            turn(turnAmount);
        }
    }

    /**
     * Method for shark to accelerate at random amounts
     */
    public void randomAccelerate() {
        // Gets random number to accelerate from -15 to 15
        int accelerateAmount = Greenfoot.getRandomNumber(30)-15;
        int chance = Greenfoot.getRandomNumber(101);

        // Shark has 30 percent chance to acclerate
        if (chance < 30) {
            accelerate(accelerateAmount);
        }
    }

    /**
     * Move, turn, accelerate and wraps shark
     */
    public void act() 
    {

        move(getSpeed());
        randomTurn();
        randomAccelerate();

        wrap();
    }    
}
