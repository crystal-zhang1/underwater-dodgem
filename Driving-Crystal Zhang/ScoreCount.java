import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCount extends Actor
{    
    public ScoreCount(int score) {
        showScore(score);
    }
    
    public void showScore(int score) 
    {
        setImage(new GreenfootImage("Score: " + score, 24, Color.WHITE, Color.BLUE));
    }    
}
