import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Counts the score and creates panel to display onto screen.
 * 
 * @author (Crystal Zhang) 
 * @version 1.0.0
 */
public class ScoreCount extends Actor
{    
    /**
     * Constructor for ScoreCount to count the score and display in world
     * @param score The score player has (number of strawberries eaten)
     */
    public ScoreCount(int score) {
        showScore(score);
    }
    
    /**
     * Sets panel for score
     * @param score int Set image for score to display
     */
    public void showScore(int score) 
    {
        setImage(new GreenfootImage("Score: " + score, 24, Color.WHITE, Color.BLUE));
    }    
}
