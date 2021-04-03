import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levels here.
 * 
 * @author (Crystal Zhang)
 * @version 1.0.0
 */
public class Levels extends World {
    // Initialize static variables
    private static int WORLD_WIDTH = 600;
    private static int WORLD_HEIGHT = 400;

    // Initialize variables
    protected int countdownTimer;
    protected ScoreCount scoreCount;
    protected LivesCount livesCount;
    protected TimeLeft timeLeft;

    protected int totalStrawberries;
    protected int totalRocks;

    protected int spawnTimer;
    protected int frequency; // frequency of pufferfish spawn (higher number means less frequent)
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

    /**
     * Constructor for objects of class Levels.
     * 
     * @param countdownTimerIn    Timer for length of level (how long player needs
     *                            to survive for)
     * @param totalStrawberriesIn Total number of strawberries that spawn into world
     * @param totalRocksIn        Total number of rocks that spawn into world
     */
    public Levels(int countdownTimerIn, int totalStrawberriesIn, int totalRocksIn) {
        this(countdownTimerIn, totalStrawberriesIn, totalRocksIn, 2600);
    }

    /**
     * Constructor for objects of class Levels.
     * 
     * @param countdownTimerIn    Timer for length of level (how long player needs
     *                            to survive for)
     * @param totalStrawberriesIn Total number of strawberries that spawn into world
     * @param totalRocksIn        Total number of rocks that spawn into world
     * @param frequencyIn         Frequency of pufferfish spawning into world
     */
    public Levels(int countdownTimerIn, int totalStrawberriesIn, int totalRocksIn, int frequencyIn) {
        this(WORLD_WIDTH, WORLD_HEIGHT, countdownTimerIn, totalStrawberriesIn, totalRocksIn, frequencyIn);
    }

    /**
     * Constructor for objects of class Levels.
     * 
     * @param worldWidthIn          Width of the world
     * @param worldHeightIn         Height of world
     * @param countdownTimerInTimer for length of level (how long player needs to
     *                              survive for)
     * @param totalStrawberriesIn   Total number of strawberries that spawn into
     *                              world
     * @param totalRocksIn          Total number of rocks that spawn into world
     * @param frequencyIn           Frequency of pufferfish spawning into world
     */
    public Levels(int worldWidthIn, int worldHeightIn, int countdownTimerIn, int totalStrawberriesIn, int totalRocksIn,
            int frequencyIn) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(worldWidthIn, worldHeightIn, 1, false);

        spawnTimer = 0;
        countdownTimer = countdownTimerIn; // Countdown timer for 3600 act cycles (60 seconds)

        scoreCount = new ScoreCount(0);
        livesCount = new LivesCount(3);
        timeLeft = new TimeLeft();
        totalStrawberries = totalStrawberriesIn;
        totalRocks = totalRocksIn;
        frequency = frequencyIn;
        frameNum = 0;

        // Spawn everything into world
        prepare();

        // Play background sound
        backgroundSound = new GreenfootSound("underwater_background_ambience.wav");
        backgroundSound.playLoop();
    }

    /**
     * Getter for background sound for world
     * 
     * @return GreenfootSound Return backgroundSound for world
     */
    public GreenfootSound getBackgroundSound() {
        return backgroundSound;
    }

    /**
     * Prepares all objects to spawn into world
     */
    public void prepare() {
        // Create controlled turtle with initial speed = 0, max speed = 7
        turtle = new Turtle("turtle", 0, 7);
        addObject(turtle, 100, 200); // Add to world at x = 100, y = 200

        // Ensure all strawberries are placed into world
        if (totalStrawberries > 0) {
            int count = 0;
            while (count < totalStrawberries) {
                if (placeStrawberry()) {
                    count = count + 1;
                } else {
                    if (debug) {
                        System.out.println("No luck to place strawberry: " + count);
                    }

                }
            }
        }

        // Ensure all rocks are placed into world
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

        // Adds score, lives, and time countdown to display in world
        addObject(scoreCount, 50, 20);
        addObject(livesCount, 150, 20);
        addObject(timeLeft, 520, 20);
    }

    /**
     * Generates pufferfish into the world at random location
     */
    public void generatePufferfishes() {
        int worldWidth = getWidth();
        int worldHeight = getHeight();

        int y = Greenfoot.getRandomNumber(worldHeight);
        Pufferfish pufferfish = new Pufferfish("rand", 1, 3); // create Pufferfish
        addObject(pufferfish, worldWidth, y);
    }

    /**
     * Increases the number of pufferfish spawning into world
     */
    public void increasePufferfish() {
        if (frequency >= 200) {
            frequency = frequency - 40;
        }
    }

    /**
     * Place a strawberry on a random location on the board
     * 
     * @return boolean Returns true if successful, false if not successful
     */
    private boolean placeStrawberry() {
        // Get random value for x and y to place the strawberry at
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

    /**
     * Method to place rock into world
     * 
     * @return boolean Returns true if successful, false if not successful
     */
    private boolean placeRock() {
        // Get a random value for x and y to place the Rock at. If not in level one,
        // range of rocks are limited to left half of world
        int xRange = (this.getClass() == Level1.class) ? WORLD_WIDTH : WORLD_WIDTH / 2;
        int randX = Greenfoot.getRandomNumber(xRange);
        int randY = Greenfoot.getRandomNumber(WORLD_HEIGHT);
        Rock rock = new Rock();

        // Place the rock into the world
        if (getObjectsAt(randX, randY, Rock.class).isEmpty()
                && getObjectsAt(randX, randY, Strawberry.class).isEmpty()) {

            addObject(rock, randX, randY);
            return true;
        }

        return false;
    }

    /**
     * Method to place shark into the world
     */
    public void placeShark() {
        // Create shark with initial speed = 1, max speed = 25
        Shark shark = new Shark("rand", 1, 25);

        // Get random number from 300 to 600 (so shark spawns on the right hand side of
        // world (opposite of turtle) at random height)
        int randX = Greenfoot.getRandomNumber(WORLD_WIDTH / 2) + WORLD_WIDTH / 2;
        int randY = Greenfoot.getRandomNumber(WORLD_HEIGHT);

        // Selects random spawn direction from 180 degrees to 360
        int randRotation = Greenfoot.getRandomNumber(180) + 180;

        // Add to world at random coordinates with random orientation
        addObject(shark, randX, randY);
        shark.setRotation(randRotation);
    }

    /**
     * Getter for ScoreCount
     * 
     * @return ScoreCount Returns the score (number of strawberries eaten by turtle)
     */
    public ScoreCount getScoreCount() {
        return scoreCount;
    }

    /**
     * Getter for LivesCount
     * 
     * @return LivesCount Return the lives the player has
     */
    public LivesCount getLivesCount() {
        return livesCount;
    }

    /**
     * Countdwon timer that goes to win screen once countdown reaches 0
     */
    public void act() {
        if (countdownTimer > 0) {
            countdownTimer--;
            timeLeft.updateTime();
            if (countdownTimer == 0) {
                if (debug)
                    System.out.println("countdown is 0");
                Greenfoot.setWorld(new WinScreen(turtle.getScore()));
            }
        }

    }
}
