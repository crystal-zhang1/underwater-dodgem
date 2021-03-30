import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World class for "Constructors" assignment.
 * Includes Animals 
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


        Turtle turtle = new Turtle(); // create controlled turtle with initial speed = 0, max speed = 120
        addObject(turtle,100, 200); // add to world

        Shark shark = new Shark("rand",1, 5); // create random car with initial speed = 1, max speed = 5
        
        int randX = Greenfoot.getRandomNumber(580)-20;
        int randY = Greenfoot.getRandomNumber(390) - 10;
        int randRotation = Greenfoot.getRandomNumber(360);
        //addObject(shark, 550, 350); // add to world at random coordinates
        //shark.setRotation(randRotation);
        
        Fish fish = new Fish(); //create  fish
        addObject(fish, 100, 100);
    }

    // tests the Animals class
    private void animalTest() {
        Animals animals = new Animals(0, 120); // create car with initial speed = 0, max speed = 120

        int yCoord = 25;

        addObject(animals, 60, 360); // place car into world at random coordinates

        // output initial speed and max speed
        System.out.println("The car speed is: " + animals.getSpeed());
        System.out.println("The car's max speed is: " + animals.getMaxSpeed());

        yCoord += 20;

        yCoord += 20;

        yCoord += 20;

        // car speed is set to 10
        animals.setSpeed(10);
        System.out.println("The car speed is: " + animals.getSpeed()); //print in console

        yCoord += 20;

        // max speed is set to 20
        animals.setMaxSpeed(20);
        System.out.println("The car's max speed is now: " + animals.getMaxSpeed()); //print in console

        yCoord += 25;

        // car speed is set to number greater than max speed
        animals.setSpeed(30);
        System.out.println("The car speed cannot exceed max speed.");
        System.out.println("The car speed is now : " + animals.getSpeed());

    } 

}
