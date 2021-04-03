import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Turtle is the controlled character that the player will use.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Turtle extends Animals {

    private int lives = 3;
    private int score = 0;
    private int counter = 0;
    private boolean debug = false;

    public Turtle(String animalType, int speed, int maxSpeed) {
        super(animalType, speed, maxSpeed);
        GreenfootImage img = new GreenfootImage("images/turtle_image.png");
        img.scale(35, 25);
        setImage(img);
    }

    public int getScore() {
        return score;
    }
    
    public boolean isTouchingRock() {
        List<Rock> touchingObstacle = getIntersectingObjects(Rock.class);

        if (touchingObstacle.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isTouchingPufferfish() {
        List<Pufferfish> touchingObstacle = getIntersectingObjects(Pufferfish.class);

        if (touchingObstacle.isEmpty()) {
            return false;
        } else {

            return true;
        }
    }

    public boolean isTouchingShark() {
        List<Shark> touchingObstacle = getIntersectingObjects(Shark.class);

        if (touchingObstacle.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isTouchingStrawberry() {
        List<Strawberry> touchingFood = getIntersectingObjects(Strawberry.class);

        if (touchingFood.isEmpty()) {
            return false;
        } else {

            return true;
        }
    }

    public int livesCount() {
        boolean rock = this.isTouchingRock();
        if (rock == true) {
            Greenfoot.playSound("sounds/bonk.wav");
            
            removeTouching(Rock.class);
            
            World myWorld = getWorld();
            int worldWidth = myWorld.getWidth();
            int worldHeight = myWorld.getHeight();
            
            removeTouching(Rock.class);
            
            Rock newRock = new Rock();
            int xRange = (myWorld.getClass() == Level1.class) ? worldWidth : worldWidth/2;
            int x = Greenfoot.getRandomNumber(xRange);
            int y = Greenfoot.getRandomNumber(worldHeight);
            getWorld().addObject(newRock, x, y);

            lives -= 1;
            if (debug)
                System.out.println("lives: " + lives);

            

            // Lives count for world
            Levels levels = (Levels) myWorld;
            LivesCount livesCount1 = levels.getLivesCount();
            livesCount1.showLives(lives);

            return lives;
        }

        boolean pufferfish = this.isTouchingPufferfish();
        if (pufferfish == true) {
            Greenfoot.playSound("sounds/ouch.wav");
            removeTouching(Pufferfish.class);
            lives -= 1;
            System.out.println("lives: " + lives);

            World myWorld = getWorld();
            Levels levels = (Levels) myWorld;
            LivesCount livesCount = levels.getLivesCount();
            livesCount.showLives(lives);

            return lives;
        }

        boolean shark = this.isTouchingShark();
        if (shark == true) {
            Greenfoot.playSound("sounds/scream.wav");
            lives = 0;
            System.out.println("Eaten by shark");

        }

        return lives;
    }

    /*
     * public int scoreCount() {
     * 
     * //score if turtle touches food (strawberry) boolean food =
     * this.isTouchingStrawberry(); if (food == true) {
     * removeTouching(Strawberry.class); Strawberry strawberry = new Strawberry();
     * getWorld().addObject(strawberry, 200, 200); score += 1; if (debug)
     * System.out.println("score: " + score + "\n"); } return score; }
     */

    /**
     * Act - do whatever the Turtle wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
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

        // score if turtle touches food (strawberry)
        boolean food = this.isTouchingStrawberry();
        if (food == true) {
            Greenfoot.playSound("sounds/bite.mp3");
            
            
            World myWorld = getWorld();
            removeTouching(Strawberry.class);
            Strawberry strawberry = new Strawberry();
            int x = Greenfoot.getRandomNumber(myWorld.getWidth());
            int y = Greenfoot.getRandomNumber(myWorld.getHeight());
            getWorld().addObject(strawberry, x, y);
            // System.out.println("strawberry: " + 200 + "\n");
            score += 1;
            // System.out.println("score: " + score + "\n");
            // score count for world 1

            Levels levels = (Levels) myWorld;
            ScoreCount scoreCount = levels.getScoreCount();
            scoreCount.showScore(score);

            // if (this.getWorld().getClass() == Level1.class) {
            // // score count for world 1
            // Level1 myWorld1 = (Level1) myWorld;
            // ScoreCount scoreCount1 = myWorld1.getScoreCount();
            // scoreCount1.updateScore();
            // } else if (this.getWorld().getClass() == Level2.class) {
            // // score count for world 2
            // Level2 myWorld2 = (Level2) myWorld;
            // ScoreCount scoreCount2 = myWorld2.getScoreCount();
            // scoreCount2.updateScore();
            // } else if (this.getWorld().getClass() == Level3.class) {
            // // score count for world 3
            // Level3 myWorld3 = (Level3) myWorld;
            // ScoreCount scoreCount3 = myWorld3.getScoreCount();
            // scoreCount3.updateScore();
            // }

        }

        move(getSpeed());
        wrap();

    }
}
