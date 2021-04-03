import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class button here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Button extends Actor {
    int width;
    int height;
    boolean buttonState;
    String buttonText;
    Color backgroundColor;
    Color fontColor;
    int fontSize;

    private boolean debug = false;

    public Button() {
        this("Start Level 1 now!");
    }

    public Button(String textIn) {
        buttonState = false;
        width = 200;
        height = 30;
        backgroundColor = Color.BLUE;
        fontColor = Color.WHITE;
        fontSize = 20;
        buttonText = textIn;
        updateImage();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    void updateImage() {
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

    public void buttonOff() {
        buttonState = false; 
        switchColor();
    }

    public void buttonOn() {
        buttonState = true;
        switchColor();
    }

    public void switchColor() {
        if(buttonState) {
            fontColor = Color.BLUE;
            backgroundColor = Color.WHITE;
        }else {
            fontColor = Color.WHITE;
            backgroundColor = Color.BLUE;
        }

        updateImage();
    }

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
