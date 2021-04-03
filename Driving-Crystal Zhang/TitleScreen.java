import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * First world that player sees (starting screen) where player can go to different levels or see instructions. Has background music.
 * 
 * @author (Crystal Zhang) 
 * @version 1.0.0
 */
public class TitleScreen extends World
{

    // Initialize variable
    protected GreenfootSound backgroundMusic;

    /**
     * Constructor for objects of class TitleScreen. 
     * 
     */
    public TitleScreen()
    { 
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Greenfoot.start();

        // Sets background image for title screen and scales
        GreenfootImage img = new GreenfootImage("images/underwater_title_screen_background.png");
        img.scale(610, 420);
        setBackground(img);

        // Play background music
        backgroundMusic = new GreenfootSound("sounds/background_music2.mp3");
        backgroundMusic.playLoop();

        Button button = new Button();
        addObject(button, 300, 250);
    }

    /**
     * Act method for title screen. Brings player to specified world depending on key pressed.
     */
    public void act()
    {
        // Press 1 to go to level 1
        if (Greenfoot.isKeyDown("1")) {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Level1()); 
        }

        // Press 2 to go to level 2
        if (Greenfoot.isKeyDown("2")) {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Level2()); 
        }

        // Press 3 to go to level 3
        if (Greenfoot.isKeyDown("3")) {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Level3()); //level 3
        }

        // Press key i to go to instructions
        if (Greenfoot.isKeyDown("i")) {
            backgroundMusic.stop();
            Greenfoot.setWorld(new Instructions()); // instructions
        }

        // Press key x to stop program
        if (Greenfoot.isKeyDown("x")) {
            backgroundMusic.stop();
            Greenfoot.stop();
        }

        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (mouse != null) {
            Actor currentActor = mouse.getActor();

            if (currentActor != null) {
                if (currentActor.getClass() == Button.class) {
                    Button currentButton = (Button) currentActor;
                    int mouseButtonPressed = mouse.getButton();
                    int mouseClickCount = mouse.getClickCount();
                    System.out.println(mouseButtonPressed + "  " + mouseClickCount);
                    if (mouseClickCount == 1) {
                        currentButton.buttonToggle();
                        backgroundMusic.stop();
                        Greenfoot.setWorld(new Level1()); // resets game
                        // Greenfoot.stop(); //stops program
                    }
                }
            }
        }
    }
}
