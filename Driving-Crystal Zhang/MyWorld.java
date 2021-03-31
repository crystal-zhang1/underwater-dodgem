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
        
        prepare(); //spawn everything

    }
    
    public void prepare() {
        //initial spawns
        
        Turtle turtle = new Turtle("rand",0, 5); // create controlled turtle with initial speed = 0, max speed = 120
        addObject(turtle,100, 200); // add to world
       

        Shark shark = new Shark("rand",1, 5); // create random car with initial speed = 1, max speed = 5
        
        int randX = Greenfoot.getRandomNumber(580)-20;
        int randY = Greenfoot.getRandomNumber(390) - 10;
        int randRotation = Greenfoot.getRandomNumber(180);
        addObject(shark, randX, randY); // add to world at random coordinates
        shark.setRotation(randRotation);
        
        Fish fish = new Fish(); //create  fish
        addObject(fish, 100, 100);
    }

    
}
