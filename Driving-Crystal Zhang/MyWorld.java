import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World class for "Constructors" assignment.
 * Includes Car test, Temperature test, and Roach Population test.
 * 
 * @author (Crystal Zhang) 
 * @version (1.0.0)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        //carTest();
        
        ControlledCar controlledCar = new ControlledCar(); // create controlled car with initial speed = 0, max speed = 120
        addObject(controlledCar,100, 200); // add to world
        
        RandomCar randomCar = new RandomCar("rand",3, 120); // create random car
        
        int randX = Greenfoot.getRandomNumber(580)-20;
        int randY = Greenfoot.getRandomNumber(390) - 10;
        int randRotation = Greenfoot.getRandomNumber(360);
        addObject(randomCar, randX, randY); // add to world at random coordinates
        randomCar.setRotation(randRotation);
    }
    
    // tests the Car class
    private void carTest() {
       Car car = new Car(0, 120); // create car with initial speed = 0, max speed = 120
      
       int yCoord = 25;
       
       addObject(car, 60, 360); // place car into world at random coordinates
    
       // output initial speed and max speed
       System.out.println("The car speed is: " + car.getSpeed());
       System.out.println("The car's max speed is: " + car.getMaxSpeed());
       
       yCoord += 20;
       
       yCoord += 20;
       
       yCoord += 20;
       
       
       // car speed is set to 10
       car.setSpeed(10);
       System.out.println("The car speed is: " + car.getSpeed()); //print in console
       
       yCoord += 20;
       
       // max speed is set to 20
       car.setMaxSpeed(20);
       System.out.println("The car's max speed is now: " + car.getMaxSpeed()); //print in console
       
       yCoord += 25;
       
       // car speed is set to number greater than max speed
       car.setSpeed(30);
       System.out.println("The car speed cannot exceed max speed.");
       System.out.println("The car speed is now : " + car.getSpeed());
       
    } 
    
}
