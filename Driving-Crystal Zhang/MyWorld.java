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
        
        carTest();
        
        ControlledCar controlledCar = new ControlledCar(); // create car with initial speed = 0, max speed = 120
      
        int yCoord = 25;
       
        addObject(controlledCar,100, 200);
    }
    
    // display message for car
    private void showCarMessage(int yCoord, String msg) {
        Message message = new Message();
        
        //addObject(message, 120, yCoord);
        //message.showMessage(msg);
        
    }
    
    // tests the Car class
    private void carTest() {
       Car car = new Car(0, 120); // create car with initial speed = 0, max speed = 120
      
       int yCoord = 25;
       
       addObject(car, 60, 360); // place car into world at random coordinates
    
       // output initial speed and max speed
       System.out.println("The car speed is: " + car.getSpeed());
       System.out.println("The car's max speed is: " + car.getMaxSpeed());
       
       showCarMessage(yCoord,"The license plate is: " + car.getLicensePlate());
       yCoord += 20;
       showCarMessage(yCoord,"The initial car speed is: " + car.getSpeed()); 
       yCoord += 20;
       showCarMessage(yCoord,"The initial max speed is: " + car.getMaxSpeed()); 
       yCoord += 20;
       
       
       // car speed is set to 10
       car.setSpeed(10);
       System.out.println("The car speed is: " + car.getSpeed()); //print in console
       showCarMessage(yCoord,"The car speed is now: " + car.getSpeed()); //display on screen
       yCoord += 20;
       
       // max speed is set to 20
       car.setMaxSpeed(20);
       System.out.println("The car's max speed is now: " + car.getMaxSpeed()); //print in console
       showCarMessage(yCoord,"The max speed is now: " + car.getMaxSpeed()); //display on screen
       yCoord += 25;
       
       // car speed is set to number greater than max speed
       car.setSpeed(30);
       System.out.println("The car speed cannot exceed max speed.");
       System.out.println("The car speed is now : " + car.getSpeed());
       showCarMessage(yCoord,"Speed cannot exceed max speed! \n Car speed is now : " + car.getSpeed()); //display on screen
       
    }
    
}
