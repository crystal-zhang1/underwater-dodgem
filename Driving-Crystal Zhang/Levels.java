import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levels here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Levels extends World {
    private static int WORLD_WIDTH = 600;
    private static int WORLD_HEIGHT = 400;

    protected int countdownTimer;
    protected ScoreCount scoreCount;
    protected LivesCount livesCount;
    protected TimeLeft timeLeft;

    protected int totalStrawberries;
    protected int totalRocks;

    // For Pufferfishes
    protected int spawnTimer;
    protected int frequency; // higher number, less frequent
    protected int frameNum;

    protected Turtle turtle;

    protected GreenfootSound backgroundSound;

    protected boolean debug = false;

    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Levels() {
        this(3600, 6, 0, 2600, WORLD_WIDTH, WORLD_HEIGHT);
    }

    public Levels(int countdownTimerIn, int totalStrawberriesIn, int totalRocksIn) {
        this(countdownTimerIn, totalStrawberriesIn, totalRocksIn, 2600);
    }

    public Levels(int countdownTimerIn, int totalStrawberriesIn, int totalRocksIn, int frequencyIn) {
        this(WORLD_WIDTH, WORLD_HEIGHT, countdownTimerIn, totalStrawberriesIn, totalRocksIn, frequencyIn);
    }

    public Levels(int worldWidthIn, int worldHeightIn, int countdownTimerIn, int totalStrawberriesIn, int totalRocksIn, int frequencyIn) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(worldWidthIn, worldHeightIn, 1, false);

        spawnTimer = 0;
        countdownTimer = countdownTimerIn; // countdown timer for 3600 act cycles = 60 seconds

        scoreCount = new ScoreCount(0);
        livesCount = new LivesCount(3);
        timeLeft = new TimeLeft();
        totalStrawberries = totalStrawberriesIn;
        totalRocks = totalRocksIn;
        frequency = frequencyIn;
        frameNum = 0;

        prepare(); // spawn everything
        backgroundSound = new GreenfootSound("underwater_background_ambience.wav");
        backgroundSound.playLoop();
    }

    public GreenfootSound getBackgroundSound() {
        return backgroundSound;
    }

    public void prepare() {
        // create controlled turtle with initial speed = 0, max speed = 120
        turtle = new Turtle("rand", 0, 7);
        addObject(turtle, 100, 200); // add to world

        if (totalStrawberries > 0) {
            int count = 0;
            while (count < totalStrawberries) {
                if (placeStrawberry()) {
                    count = count + 1;
                } else {
                    if (debug)
                        System.out.println("No luck to place strawberry: " + count);
                }
            }
        }

        if (totalRocks > 0) {
            int countRock = 0;
            while (countRock < totalRocks) {
                if (placeRock()) {
                    countRock = countRock + 1;
                } else {
                    if (debug)
                        System.out.println("No luck to place rock: " + countRock);
                }
            }

        }

        // adds score, lives, and time countdown to display in world
        addObject(scoreCount, 50, 20);
        addObject(livesCount, 150, 20);
        addObject(timeLeft, 520, 20);
    }

    public void generatePufferfishes() {
        int worldWidth = getWidth();
        int worldHeight = getHeight();

        int y = Greenfoot.getRandomNumber(worldHeight);
        Pufferfish pufferfish = new Pufferfish("rand", 1, 3); // create Pufferfish
        addObject(pufferfish, worldWidth, y);
    }

    // increases number of pufferfish spawning
    public void increasePufferfish() {
        if (frequency >= 200) {
            frequency = frequency - 40;
        }
    }

    /**
     * Place a strawberry on a random location on the board
     * 
     * @return Returns true if successful, false if not successful
     */
    private boolean placeStrawberry() {
        // Get a random value for x and y to place the strawberry at
        int randX = Greenfoot.getRandomNumber(WORLD_WIDTH);
        int randY = Greenfoot.getRandomNumber(WORLD_HEIGHT);
        Strawberry strawberry = new Strawberry();

        // Place the strawberry into the world
        if (getObjectsAt(randX, randY, Strawberry.class).isEmpty()) {

            addObject(strawberry, randX, randY);
            return true;
        }

        return false;

    }

    private boolean placeRock() {
        // Get a random value for x and y to place the Rock at.

        int xRange = (this.getClass() == Level1.class) ? WORLD_WIDTH : WORLD_WIDTH/2;
        int randX = Greenfoot.getRandomNumber(xRange);
        int randY = Greenfoot.getRandomNumber(WORLD_HEIGHT);
        Rock rock = new Rock();

        // Place the strawberry into the world
        if (getObjectsAt(randX, randY, Rock.class).isEmpty()
        && getObjectsAt(randX, randY, Strawberry.class).isEmpty()) {

            addObject(rock, randX, randY);
            return true;
        }

        return false;
    }

    public void placeShark() {
        // create random car with initial speed = 1, max speed = 5
        Shark shark = new Shark("rand", 1, 25);

        // random number from 300 to 600 (so shark spawns on other half of world where
        // turtle is not))
        int randX = Greenfoot.getRandomNumber(WORLD_WIDTH/2) + WORLD_WIDTH/2;
        int randY = Greenfoot.getRandomNumber(WORLD_HEIGHT);

        // selects random spawn direction from 180 degrees to 360 (so shark will go in
        // general direction of turtle)
        int randRotation = Greenfoot.getRandomNumber(180) + 180;

        // add to world at random coordinates
        addObject(shark, randX, randY);

        shark.setRotation(randRotation);
    }

    // getter for ScoreCount
    public ScoreCount getScoreCount() {
        return scoreCount;
    }

    // getter for LivesCount
    public LivesCount getLivesCount() {
        return livesCount;
    }

    public void act() {
        /*
         * spawnTimer = (spawnTimer + 1) % (90*frequency/1000); if (spawnTimer == 1) //
         * at each timer reset { generatePufferfishes(); }
         */
        // countdwon timer that goes to win screen once countdown reaches 0
        if (countdownTimer > 0) {
            countdownTimer--;
            timeLeft.updateTime();
            if (countdownTimer == 0)
                Greenfoot.setWorld(new WinScreen(turtle.getScore()));
        }


    }
}
