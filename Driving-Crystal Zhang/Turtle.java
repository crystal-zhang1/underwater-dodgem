import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Turtle is the controlled character that the player will use.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turtle extends Animals
{

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
            removeTouching(Rock.class);

            if (lives > 0) {
                World myWorld = getWorld();

                if (this.getWorld().getClass() == MyWorld1.class) {
                    // score count for world 1 
                    MyWorld1 myWorld1 = (MyWorld1)myWorld;
                    LivesCount livesCount1 = myWorld1.getLivesCount();
                    livesCount1.updateLives();
                } else if (this.getWorld().getClass() == MyWorld2.class) {
                    // score count for world 2
                    MyWorld2 myWorld2 = (MyWorld2)myWorld;
                    LivesCount livesCount2 = myWorld2.getLivesCount();
                    livesCount2.updateLives();
                } else if (this.getWorld().getClass() == MyWorld3.class) {
                    // score count for world 3
                    MyWorld3 myWorld3 = (MyWorld3)myWorld;
                    LivesCount livesCount3 = myWorld3.getLivesCount();
                    livesCount3.updateLives(); 
                }
            }
            lives -= 1;
            System.out.println("lives: " + lives);
            return lives;
        }

        boolean pufferfish = this.isTouchingPufferfish();
        if (pufferfish == true) {
            removeTouching(Pufferfish.class);
            if (lives > 0) {
                World myWorld = getWorld();

                if (this.getWorld().getClass() == MyWorld1.class) {
                    // score count for world 1 
                    MyWorld1 myWorld1 = (MyWorld1)myWorld;
                    LivesCount livesCount1 = myWorld1.getLivesCount();
                    livesCount1.updateLives();
                } else if (this.getWorld().getClass() == MyWorld2.class) {
                    // score count for world 2
                    MyWorld2 myWorld2 = (MyWorld2)myWorld;
                    LivesCount livesCount2 = myWorld2.getLivesCount();
                    livesCount2.updateLives();
                } else if (this.getWorld().getClass() == MyWorld3.class) {
                    // score count for world 3
                    MyWorld3 myWorld3 = (MyWorld3)myWorld;
                    LivesCount livesCount3 = myWorld3.getLivesCount();
                    livesCount3.updateLives(); 
                }
                lives -= 1;
                System.out.println("lives: " + lives);
                return lives;
            }
        }

        boolean shark = this.isTouchingShark();
        if (shark == true) {
            lives = 0;
            System.out.println("Eaten by shark");

        }

        return lives;
    }

    /*public int scoreCount() {

    //score if turtle touches food (strawberry)
    boolean food = this.isTouchingStrawberry();
    if (food == true) {
    removeTouching(Strawberry.class);
    Strawberry strawberry = new Strawberry();
    getWorld().addObject(strawberry, 200, 200);
    score += 1;
    if (debug) System.out.println("score: " + score + "\n");
    }   
    return score;
    }*/

    /**
     * Act - do whatever the Turtle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
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
            Greenfoot.setWorld(new GameOver());

            //Greenfoot.stop();

        } 

        //score if turtle touches food (strawberry)
        boolean food = this.isTouchingStrawberry();
        if (food == true) {
            World myWorld = getWorld();
            removeTouching(Strawberry.class);
            Strawberry strawberry = new Strawberry();
            getWorld().addObject(strawberry, 200, 200); 
            score += 1;
            System.out.println("score: " + score + "\n");

            if (this.getWorld().getClass() == MyWorld1.class) {
                // score count for world 1 
                MyWorld1 myWorld1 = (MyWorld1)myWorld;
                ScoreCount scoreCount1 = myWorld1.getScoreCount();
                scoreCount1.updateScore();
            } else if (this.getWorld().getClass() == MyWorld2.class) {
                // score count for world 2
                MyWorld2 myWorld2 = (MyWorld2)myWorld;
                ScoreCount scoreCount2 = myWorld2.getScoreCount();
                scoreCount2.updateScore();
            } else if (this.getWorld().getClass() == MyWorld3.class) {
                // score count for world 3
                MyWorld3 myWorld3 = (MyWorld3)myWorld;
                ScoreCount scoreCount3 = myWorld3.getScoreCount();
                scoreCount3.updateScore(); 
            }

        }

        move(getSpeed());
        wrap();

    }    
}
