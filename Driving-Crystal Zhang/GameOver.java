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

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        GreenfootImage img = new GreenfootImage("images/game_over_background.png");
        img.scale(600, 400);
        setBackground(img);

        ScoreCount scoreCount = new ScoreCount(score);
        addObject(scoreCount, 300, 160);
        
        //Message winMessage = new Message();
        //addObject(winMessage, (int) (600 / 2), (int) (400 / 2)); 
    }

    public void act() {
        if (Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new TitleScreen()); //TitleScreen

        if (Greenfoot.isKeyDown("x")) Greenfoot.stop(); // stops running

    }
}
