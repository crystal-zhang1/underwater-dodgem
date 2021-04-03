import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shark is an obstacle that will move around randomly.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shark extends Animals
{
    private int frameNum;

    public Shark(String animalType, int speed, int maxSpeed) {
        super(animalType, speed, maxSpeed);
        frameNum = 0;
        GreenfootImage img = new GreenfootImage("images/shark_image.png");
        img.scale(100, 50);
        setImage(img);
    }

    public void randomTurn() {

        int turnAmount= Greenfoot.getRandomNumber(24) - 12; // car will turn random amount
        int chanceOfTurn = Greenfoot.getRandomNumber(100); 

        if (chanceOfTurn < 10) { // car has 10 percent chance of turning every frame
            turn(turnAmount);
        }

    }

    public void randomAccelerate() {
        int accelerateAmount = Greenfoot.getRandomNumber(30)-15;
        int chance = Greenfoot.getRandomNumber(100);

        if (chance < 2) {
            accelerate(accelerateAmount);
        }

    }

    /**
     * Act - do whatever the RandomCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (frameNum == 3) { // after 120 act cycles (2 seconds), rate of pufferfish spawn will increase
            move(getSpeed());
            randomTurn();
            randomAccelerate();
            wrap();
            frameNum = 0;
        } else {
            frameNum++;
        }

    }    
}
