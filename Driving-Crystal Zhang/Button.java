import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button class to start first level
 * 
 * @author Crystal Zhang
 * @version 1.0.0
 */
public class Button extends Actor {
    
    // Initialize variable
    int width;
    int height;
    boolean buttonState;
    String buttonText;
    Color backgroundColor;
    Color fontColor;
    int fontSize;

    private boolean debug = false;

    /**
     * Button constructor
     */
    public Button() {
        this("Start Level 1 now!");
    }

    /**
     * Constructor for button details with text parameter
     * @param textIn Text that is displayed in button
     */
    public Button(String textIn) {
        buttonState = false;
        width = 200;
        height = 30;
        backgroundColor = Color.BLUE;
        fontColor = Color.WHITE;
        fontSize = 20;
        buttonText = textIn;
        displayMessage();
    }

    /**
     * Getter for button width
     * @return int Returns width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter for button height
     * @return int Returns height
     */
    public int getHeight() {
        return height;
    }

    /** 
     * Display button message 
     */
    void displayMessage() {
        // Create an image of the set size using built in greenfoot commands
        GreenfootImage displayImage = new GreenfootImage(width, height);

        displayImage.setColor(backgroundColor);
        displayImage.fill();

        // Display the button text
        Font displayFont = new Font(fontSize);
        displayImage.setColor(fontColor);
        displayImage.setFont(displayFont);
        displayImage.drawString(buttonText, 16, (int) (height / 2 + 6));

        // Add the image as the new image for this object
        setImage(displayImage);
        if (debug) System.out.println("===============: width " + width + " height " + height);
    }

    /**
     * Method to toggle button off
     */
    public void buttonOff() {
        buttonState = false; 
        switchColor();
    }

    /**
     * Method to toggle button on
     */
    public void buttonOn() {
        buttonState = true;
        switchColor();
    }

    /**
     * Method to switch color of button
     */
    public void switchColor() {
        if(buttonState) {
            fontColor = Color.BLUE;
            backgroundColor = Color.WHITE;
        }else {
            fontColor = Color.WHITE;
            backgroundColor = Color.BLUE;
        }

        displayMessage();
    }

    /**
     * Toggles button state
     */
    public void buttonToggle() {
        buttonState = !buttonState;
        switchColor();
    }

    /**
     * Tracks mouse movement and actions
     */
    public void act() {
        if(Greenfoot.mouseMoved(this)){
            if (debug) System.out.println("===============: mouseMoved in ");
            buttonOn();
            
        }else if(Greenfoot.mouseMoved(null)){
            if (debug) System.out.println("===============: mouseMoved out ");
            buttonOff();
        }
    }

}
