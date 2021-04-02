import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld2 extends World
{

    private int spawnTimer;
    private int frequency = 2600; //higher number, less frequent
    private int countdownTimer = 3600;
    private int totalStrawberries = 3;
    private int frameNum = 0;
    
    ScoreCount scoreCount = new ScoreCount();
    LivesCount livesCount = new LivesCount();
    TimeLeft timeLeft = new TimeLeft();
    

    private boolean debug = false;

    /**
     * Constructor for objects of class MyWorld2.
     * 
     */
    public MyWorld2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        GreenfootImage img = new GreenfootImage("images/ocean_background2.jpg");
        img.scale(600, 400);
        setBackground(img);

        prepare();
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

    public void generatePufferfishes() {
        int worldWidth = getWidth();
        int worldHeight = getHeight();

        int y = Greenfoot.getRandomNumber(worldHeight);
        Pufferfish pufferfish = new Pufferfish("rand",1, 3); //create  Pufferfish
        addObject(pufferfish, worldWidth, y);
    }

    //increases number of pufferfish spawning
    public void increasePufferfish() {
        if (frequency >= 200) {
            frequency = frequency - 40;
        }
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
        spawnTimer = (spawnTimer + 1) % (90*frequency/1000);
        if (spawnTimer == 1) // at each timer reset
        {
            generatePufferfishes();
        }  

        
        
        if (frameNum == 120) { //after 120 act cycles (2 seconds), rate of pufferfish spawn will increase
            increasePufferfish();
            frameNum = 0;
        } else {
            frameNum++;
        }
        System.out.println("frameNum: " + frameNum);
        
        
        
        if (countdownTimer > 0)
        {
            System.out.println("\nfrequency: " + frequency);
            countdownTimer--;
            timeLeft.updateTime();
            if(countdownTimer == 0) Greenfoot.setWorld(new TitleScreen());
        }

        if (Greenfoot.isKeyDown("escape")) Greenfoot.setWorld(new TitleScreen()); //return to title screen
        if (Greenfoot.isKeyDown("r")) Greenfoot.setWorld(new MyWorld2()); //restart level
        if (Greenfoot.isKeyDown("x")) Greenfoot.stop(); //stops program

    }

}
