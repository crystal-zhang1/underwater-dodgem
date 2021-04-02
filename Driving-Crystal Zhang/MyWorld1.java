import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World class for "Constructors" assignment.
 * Includes Animals 
 * 
 * @author (Crystal Zhang) 
 * @version (1.0.0)
 */
public class MyWorld1 extends World
{

    private int spawnTimer;
    private int frequency = 2000; //higher number, less frequent
    private int countdownTimer = 3600; // countdown timer for 3600 act cycles = 60 seconds
    private int totalStrawberries = 6;
    private int totalRocks = 6;
    ScoreCount scoreCount = new ScoreCount();
    LivesCount livesCount = new LivesCount();
    TimeLeft timeLeft = new TimeLeft();

    private boolean debug = false;

    /**
     * Constructor for objects of class MyWorld1.
     * 
     */
    public MyWorld1() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        spawnTimer = 0;

        prepare(); //spawn everything

    }

    public void prepare() {
        //initial spawns

        Turtle turtle = new Turtle("rand",0, 7); // create controlled turtle with initial speed = 0, max speed = 120
        addObject(turtle,100, 200); // add to world

        int count = 0;
        while (count < totalStrawberries) {
            if (placeStrawberry()) {
                count = count + 1;
            } else {
                if (debug)
                    System.out.println("No luck to place strawberry: " + count);
            }
        }
        
        int countRock = 0;
        while (countRock < totalRocks) {
            if (placeRock()) {
                countRock = countRock + 1;
            } else {
                if (debug)
                    System.out.println("No luck to place rock: " + count);
            }
        }

        //adds score, lives, and time countdown to display in world
        addObject(scoreCount, 50, 20);
        addObject(livesCount, 150, 20);
        addObject(timeLeft, 520, 20);
    }

    public void generatePufferfishes() {
        int worldWidth = getWidth();
        int worldHeight = getHeight();

        int y = Greenfoot.getRandomNumber(worldHeight);
        Pufferfish pufferfish = new Pufferfish("rand",1, 3); //create  Pufferfish
        addObject(pufferfish, worldWidth, y);
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

        // Place the strawberry into the world
        if (getObjectsAt(randX, randY, Strawberry.class).isEmpty()) {

            addObject(strawberry, randX, randY);
            return true;
        }

        return false;

    }

    private boolean placeRock() {
        // Get a random value for x and y to place the katamari at.
        int randX = Greenfoot.getRandomNumber(600);
        int randY = Greenfoot.getRandomNumber(400);
        Rock rock = new Rock();

        // Place the strawberry into the world
        if (getObjectsAt(randX, randY, Rock.class).isEmpty() && getObjectsAt(randX, randY, Strawberry.class).isEmpty()) {

            addObject(rock, randX, randY);
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
        /*spawnTimer = (spawnTimer + 1) % (90*frequency/1000);
        if (spawnTimer == 1) // at each timer reset
        {
        generatePufferfishes();
        } */

        // countdwon timer that goes to win screen once countdown reaches 0
        if (countdownTimer>0)
        {
            countdownTimer--;
            timeLeft.updateTime();
            if(countdownTimer == 0) Greenfoot.setWorld(new TitleScreen());
        }

        if (Greenfoot.isKeyDown("escape")) Greenfoot.setWorld(new TitleScreen()); //return to title screen

    }
}
