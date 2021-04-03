import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; // import the List type

/**
 * Turtle is the controlled character that the player will use.
 * 
 * @author Crystal Zhang
 * @version 1.0.0
 */
public class Turtle extends Animals {

    // The lives Turtle left
    private int lives;
    // score the Turtle got while playing the game
    private int score;
    // counter for control call the accelerate rate
    private int counter;

    /**
     * Constructor for Turtle
     * 
     * @param animalType
     * @param speed
     * @param maxSpeed
     */
    public Turtle(String animalType, int speed, int maxSpeed) {
        super(animalType, speed, maxSpeed);

        lives = 3; // Default lives value
        score = 0; // Default score value
        counter = 0; // Set counter initial value to 0

        // Use turtle image from the images folder
        GreenfootImage img = new GreenfootImage("images/turtle_image.png");

        // Resize image to fit the game design
        img.scale(35, 25);

        // Set turtle image
        setImage(img);
    }

    /**
     * Getter for score
     * 
     * @return int Score the Turtle got while playing the game
     */
    public int getScore() {
        return score;
    }

    /**
     * Check if the Turtle is touching the Rock
     * 
     * @return boolean true if is touching the Rock, false if not
     */
    public boolean isTouchingRock() {
        List<Rock> touchingObstacle = getIntersectingObjects(Rock.class);

        // Check if touching list is empty or not
        if (touchingObstacle.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check if the Turtle is touching the Pufferfish
     * 
     * @return boolean true if is touching the Pufferfish, false if not
     */
    public boolean isTouchingPufferfish() {
        // Get the touching Pufferfish list
        List<Pufferfish> touchingObstacle = getIntersectingObjects(Pufferfish.class);

        // Check if touching list is empty or not
        if (touchingObstacle.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check if the Turtle is touching the Shark
     * 
     * @return boolean true if is touching the Shark, false if not
     */
    public boolean isTouchingShark() {
        // Get the touching Shark list
        List<Shark> touchingObstacle = getIntersectingObjects(Shark.class);

        // Check if touching list is empty or not
        if (touchingObstacle.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check if the Turtle is touching the Strawberry
     * 
     * @return boolean true if is touching the Strawberry, false if not
     */
    public boolean isTouchingStrawberry() {
        // Get the touching Strawberry list
        List<Strawberry> touchingFood = getIntersectingObjects(Strawberry.class);

        // Check if touching list is empty or not
        if (touchingFood.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check if the Turtle is touching the Rock, Pufferfish, or Shark Update the
     * lives of the Turtle
     * 
     * @return int return the lives currently the Turtle has
     */
    public int livesCount() {
        // Check if the Turtle is touching the Rock
        boolean rock = this.isTouchingRock();
        if (rock == true) {
            Greenfoot.playSound("sounds/bonk.wav");

            removeTouching(Rock.class);

            World myWorld = getWorld();
            int worldWidth = myWorld.getWidth();
            int worldHeight = myWorld.getHeight();

            removeTouching(Rock.class);

            Rock newRock = new Rock();
            int xRange = (myWorld.getClass() == Level1.class) ? worldWidth : worldWidth / 2;
            int x = Greenfoot.getRandomNumber(xRange);
            int y = Greenfoot.getRandomNumber(worldHeight);
            getWorld().addObject(newRock, x, y);

            lives -= 1;
            if (debug) {
                System.out.println("lives: " + lives);
            }

            // Lives count for world
            Levels levels = (Levels) myWorld;
            LivesCount livesCount1 = levels.getLivesCount();
            livesCount1.showLives(lives);

            return lives;
        }

        // Check if the Turtle is touching the Pufferfish
        boolean pufferfish = this.isTouchingPufferfish();
        if (pufferfish == true) {
            Greenfoot.playSound("sounds/ouch.wav");
            removeTouching(Pufferfish.class);
            lives -= 1;
            if(debug) System.out.println("lives: " + lives);

            World myWorld = getWorld();
            Levels levels = (Levels) myWorld;
            LivesCount livesCount = levels.getLivesCount();
            livesCount.showLives(lives);

            return lives;
        }

        // Check if the Turtle is touching the Shark
        boolean shark = this.isTouchingShark();
        if (shark == true) {
            Greenfoot.playSound("sounds/scream.wav");
            lives = 0;
            if(debug) System.out.println("Eaten by shark");

        }

        return lives;
    }

    /**
     * Act - Check and action based on the object the Turtle is touching. Also call
     * move and wrap This method is called whenever the 'Act' or 'Run' button gets
     * pressed in the environment.
     */
    public void act() {
        if (counter == 5) {
            if (Greenfoot.isKeyDown("up")) {
                accelerate(1);
            }
            if (Greenfoot.isKeyDown("down")) {
                accelerate(-1);
            }
            counter = 0;
        }
        counter++;

        if (Greenfoot.isKeyDown("right")) {
            turn(4);
        }
        if (Greenfoot.isKeyDown("left")) {
            turn(-4);
        }

        if (livesCount() == 0) {
            World myWorld = getWorld();

            // Lives count for world
            Levels levels = (Levels) myWorld;

            Greenfoot.setWorld(new GameOver(score, levels.getBackgroundSound()));
            Greenfoot.playSound("sounds/fading_scream.wav");
            // Greenfoot.stop();

        }

        // Increase the score if turtle touches food (strawberry)
        boolean food = this.isTouchingStrawberry();
        if (food == true) {
            // Increase the score
            score += 1;

            // Play sound
            Greenfoot.playSound("sounds/bite.mp3");

            World myWorld = getWorld();

            // Remove Strawberry from the world
            removeTouching(Strawberry.class);

            // Create a new Strawberry
            Strawberry strawberry = new Strawberry();

            // Generate the random x, y location for puting the new strawberry
            int x = Greenfoot.getRandomNumber(myWorld.getWidth());
            int y = Greenfoot.getRandomNumber(myWorld.getHeight());

            // Put the new generated Strawberry to the world
            getWorld().addObject(strawberry, x, y);

            if (debug) {
                System.out.println("strawberry: " + 200 + "\n");
            }

            if (debug) {
                System.out.println("score: " + score + "\n");
            }

            // Update the soreCount panle with the new score
            Levels levels = (Levels) myWorld;
            ScoreCount scoreCount = levels.getScoreCount();
            scoreCount.showScore(score);
        }

        // Move Turtle based on the speed
        move(getSpeed());

        // Check and wrap Turtle if it's reaching the edge of the world
        wrap();

    }
}
