import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * The Pufferfish class is an obstacle that will move horizontally across from right to left.
 * 
 * @author (Crystal Zhang) 
 * @version 1.0.0
 */
public class Pufferfish extends Animals
{
    /**
     * Constructor for Pufferfish
     * @param animalType 
     * @param speed Default speed that the animal will move at
     * @param maxSpeed Maxiumum speed that the animal will be able to move at
     */
    public Pufferfish(String animalType, int speed, int maxSpeed) {
        super(animalType, speed, maxSpeed);
        
        // Set image for pufferfish and scales image
        GreenfootImage img = new GreenfootImage("images/pufferfish_image.png");
        img.scale(50, 50);
        setImage(img); 
    }
    

    /**
     * Act method to move pufferfish and wrap pufferfish when reaches edge of world
     */
    public void act() {
        move(getSpeed() * -1);
        wrap();
    }    
    
}
