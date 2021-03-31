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

    public Turtle(String animalType, int speed, int maxSpeed) {
        super(animalType, speed, maxSpeed);
        GreenfootImage img = new GreenfootImage("images/turtle_image.png");
        img.scale(35, 25);
        setImage(img);
    }

    public boolean isTouchingPufferfish() {
        List<Pufferfish> touchingObstacle = getIntersectingObjects(Pufferfish.class);
        if (touchingObstacle.isEmpty()) {
            return false;
        } else {

            return true;
        }
    }
    
    

    public boolean isTouchingFood() {
        List<Strawberry> touchingFood = getIntersectingObjects(Strawberry.class);

        if (touchingFood.isEmpty()) {
            return false;
        } else {

            return true;
        }
    }

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

        move(getSpeed());
        wrap();

        //if turtle is touching another animal
        boolean obstacle = this.isTouchingPufferfish();
        if (obstacle == true) { //checks to see if turtle is touching any animals
            if (lives > 0) { //checks to see if all lives have been lost
                lives -=1;

                System.out.println("lives count is now: " + lives);
            } else {
                //System.out.println("No lives left");
            }

        } 

        //if turtle touches food (strawberry)
        boolean food = this.isTouchingFood();
        if (food == true) {
            score += 1;
            System.out.println("score: " + score + "\n");
        }
    }    
}
