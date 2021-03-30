import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shark is an obstacle that will move around randomly.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shark extends Animals
{
    public Shark() {
        super();
        //setImage(new GreenfootImage("Shark_Image.png"));
        //GreenfootImage img = getImage();  
        GreenfootImage img = new GreenfootImage("images/Shark_Image.png");
        img.scale(50, 50);
        setImage(img);
    }

    public Shark(String animalType, int speed, int maxSpeed) {
        super(animalType, speed, maxSpeed);
    }

    public void randomTurn() {

        int turnAmount= Greenfoot.getRandomNumber(24) - 12; // car will turn random amount
        int chanceOfTurn = Greenfoot.getRandomNumber(100); 
        //int turnChancePerFrame = Greenfoot.getRandomNumber(10);

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

        // ensures car doesn't keep trying to turn while not moving 
        if (getSpeed() != 0) {
            move(getSpeed());
            randomTurn();
            randomAccelerate();

        } else {
            move(getSpeed());
            randomAccelerate();
        }

        wrap();

    }    
}
