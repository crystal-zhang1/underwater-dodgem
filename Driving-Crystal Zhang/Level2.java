import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level2 extends Levels {

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2() {
        // Create Level Two World with countdownTimer, totalStrawberries, totalRocks.
        super(3600, 3, 0);
        
        GreenfootImage img = new GreenfootImage("images/ocean_background2.jpg");
        img.scale(600, 400);
        setBackground(img);

        
    }

    public void act() {
        spawnTimer = (spawnTimer + 1) % (90 * frequency / 1000);
        if (spawnTimer == 1) // at each timer reset
        {
            generatePufferfishes();
        }

        
        if (frameNum == 120) { // after 120 act cycles (2 seconds), rate of pufferfish spawn will increase
            increasePufferfish();
            frameNum = 0;
        } else {
            frameNum++;
        }
        System.out.println("frameNum: " + frameNum);

        if (countdownTimer > 0) {
            System.out.println("\nfrequency: " + frequency);
            countdownTimer--;
            timeLeft.updateTime();
            if (countdownTimer == 0)
                Greenfoot.setWorld(new TitleScreen());
        }

        if (Greenfoot.isKeyDown("escape"))
            Greenfoot.setWorld(new TitleScreen()); // return to title screen
        if (Greenfoot.isKeyDown("r"))
            Greenfoot.setWorld(new Level2()); // restart level
        if (Greenfoot.isKeyDown("x"))
            Greenfoot.stop(); // stops program

    }

}
