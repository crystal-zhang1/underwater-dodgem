import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    protected ScoreCount scoreCount;
    protected GreenfootSound backgroundSound;
    
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int score, GreenfootSound backgroundSoundIn)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        GreenfootImage img = new GreenfootImage("images/game_over_background.png");
        img.scale(600, 400);
        setBackground(img);

        ScoreCount scoreCount = new ScoreCount(score);
        addObject(scoreCount, 300, 160);
        
        backgroundSound = backgroundSoundIn;
        
        //Message winMessage = new Message();
        //addObject(winMessage, (int) (600 / 2), (int) (400 / 2)); 
    }

    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            backgroundSound.stop();
            System.out.println("stop sound");
            Greenfoot.setWorld(new TitleScreen()); // return to title screen
        }
        
        if (Greenfoot.isKeyDown("x")) {
            Greenfoot.stop(); // stops program
        }
    }
}
