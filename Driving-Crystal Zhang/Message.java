import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class to display message in MyWorld.
 * 
 * @author (Crystal Zhang) 
 * @version (1.0.0)
 */
public class Message extends Actor
{
    String message;
    int fontSize;
    Color fontColor;
    Color backgroundColor;

    public Message() {
        this("");
    }
    
    // message constructor
    public Message(String messageIn) {
        this(messageIn,12,Color.BLACK, Color.WHITE);
    }
 
    public Message(String messageIn, int fontSizeIn, Color fontColorIn, Color backgroundColorIn) {       
        message = messageIn;
        fontSize = fontSizeIn;
        fontColor = fontColorIn;
        backgroundColor = backgroundColorIn;
        showMessage(messageIn);
    }
    
    public void showMessage(String messageIn) {
        message = messageIn;
        GreenfootImage messageImage = new GreenfootImage(message, fontSize, fontColor, backgroundColor);
        setImage(messageImage);
        
    }
    
    /**
     * Act - do whatever the WinMessage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
