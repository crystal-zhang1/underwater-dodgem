import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld3 extends World
{
    private int countdownTimer = 3600; // countdown timer for 3600 act cycles = 60 seconds
    private int totalStrawberries = 2;
    private boolean debug = false;
    ScoreCount scoreCount = new ScoreCount();
    LivesCount livesCount = new LivesCount();
    TimeLeft timeLeft = new TimeLeft();

    /**
     * Constructor for objects of class MyWorld3.
     * 
     */
    public MyWorld3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 

        GreenfootImage img = new GreenfootImage("images/ocean_background3.png");
        img.scale(860, 404);
        setBackground(img);

        prepare();
    }

    public void prepare() {
        //initial spawns

        Turtle turtle = new Turtle("rand",0, 7); // create controlled turtle with initial speed = 0, max speed = 120
        addObject(turtle,100, 200); // add to world

        Shark shark = new Shark("rand",1, 5); // create random car with initial speed = 1, max speed = 5
        int randX = Greenfoot.getRandomNumber(300) + 300; // random number from 300 to 600 (so shark spawns on other half of world where turtle is not))
        int randY = Greenfoot.getRandomNumber(400); 
        int randRotation = Greenfoot.getRandomNumber(180) + 180; // selects random spawn direction from 180 degrees to 360 (so shark will go in general direction of turtle)
        addObject(shark, randX, randY); // add to world at random coordinates
        shark.setRotation(randRotation);

        int count = 0;
        while (count < totalStrawberries) {
            if (placeStrawberry()) {
                count = count + 1;
            } else {
                if (debug)
                    System.out.println("No luck to place strawberry: " + count);
            }
        }

        //adds score, lives, and time countdown to display in world
        addObject(scoreCount, 50, 20);
        addObject(livesCount, 150, 20);
        addObject(timeLeft, 520, 20);
    }

    /**
     * Place a strawberry on a random location on the board
     * 
     * @return Returns true if successful, false if not successful
     */
    private boolean placeStrawberry() {
        // Get a random value for x and y to place the katamari at.
        int randX = Greenfoot.getRandomNumber(600);
        int randY = Greenfoot.getRandomNumber(400);
        Strawberry strawberry = new Strawberry();

        // Place the ball into the world
        if (getObjectsAt(randX, randY, Strawberry.class).isEmpty()) {

            addObject(strawberry, randX, randY);
            return true;
        }

        return false;

    }

    //getter for ScoreCount
    public ScoreCount getScoreCount() {
        return scoreCount;
    }

    //getter for LivesCount
    public LivesCount getLivesCount() {
        return livesCount;
    }

    public void act() {
        if (Greenfoot.isKeyDown("escape")) Greenfoot.setWorld(new TitleScreen()); //return to title screen
        if (Greenfoot.isKeyDown("r")) Greenfoot.setWorld(new MyWorld3()); //restart level
        if (Greenfoot.isKeyDown("x")) Greenfoot.stop(); //stops program
    }
}
