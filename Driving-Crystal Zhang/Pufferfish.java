import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * The Pufferfish class is an obstacle that will move (not randomly).
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pufferfish extends Animals
{
    public Pufferfish(String animalType, int speed, int maxSpeed) {
        super(animalType, speed, maxSpeed);
        GreenfootImage img = new GreenfootImage("images/pufferfish_image.png");
        img.scale(50, 50);
        setImage(img); 
    }
    

    /**
     * Act - do whatever the Pufferfish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        move(getSpeed() * -1);
        wrap();
    }    
    
}
