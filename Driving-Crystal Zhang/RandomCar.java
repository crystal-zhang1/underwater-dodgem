import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomCar extends Car
{
    public RandomCar() {
        super();
    }

    public RandomCar(String licensePlate, int speed, int maxSpeed) {
        super(licensePlate, speed, maxSpeed);
    }
    
    public void randomTurn() {
        
        int turnAmount= Greenfoot.getRandomNumber(20) - 10; // car will turn random amount
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
