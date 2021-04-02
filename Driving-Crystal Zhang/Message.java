import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
    String message;
    int fontSize;
    Color fontColor;
    Color backgroundColor;

    public Message() {
        this("GAME OVER");
    }
    
    public Message(String messageIn) {
        this(messageIn,50,Color.BLACK, Color.WHITE);
    }
 
    public Message(String messageIn, int fontSizeIn, Color fontColorIn, Color backgroundColorIn) {       
        message = messageIn;
        fontSize = fontSizeIn;
        fontColor = fontColorIn;
        backgroundColor = backgroundColorIn;
        showMessage();
    }
    
       
 
    
    
    public void showMessage() {
        GreenfootImage messageImage = new GreenfootImage(message, fontSize, fontColor, backgroundColor);
        setImage(messageImage);
        
    }
    
    /**
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
