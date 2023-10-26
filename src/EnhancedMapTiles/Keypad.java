package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Map;
import Level.Player;
import Level.TileType;
import Maps.Level2;
import Utils.Point;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.ScreenManager;
import GameObject.Rectangle;
import SpriteFont.SpriteFont;
import Utils.Colors;

//import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.HashMap;

public class Keypad extends EnhancedMapTile {
    private ScreenManager screenManager;
    private GraphicsHandler graphicsHandler;
    private SpriteFont kpad;
    //private Thread gameLoopProcess;
    private KeyLocker keyLocker = new KeyLocker();
	private final Key keyPadKey = Key.SPACE;

	private final Key oneKey = Key.ONE;
    private final Key twoKey = Key.TWO;
    private final Key threeKey = Key.THREE;
    private final Key fourKey = Key.FOUR;
    private final Key fiveKey = Key.FIVE;
    private final Key sixKey = Key.SIX;
    private final Key sevenKey = Key.SEVEN;
    private final Key eightKey = Key.EIGHT;
    private final Key nineKey = Key.NINE;
    
    
    
    
    
    
    
    


    public JPanel keypadContainer;
    
    private Map mapReference;
    protected boolean isInteractable = false;
    public boolean isInteractedWith = false;
    private boolean isKeypadVisible = false;
    private boolean correctPassKey = false;

    
    


    public Keypad(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Keypad.png"), 16, 16), TileType.PASSABLE);


        graphicsHandler = new GraphicsHandler();

		screenManager = new ScreenManager();
      

        keypadContainer = new JPanel();
        keypadContainer.setVisible(false);
        keypadContainer.setLayout(new GridLayout(3,3));
        
        graphicsHandler = new GraphicsHandler();

		screenManager = new ScreenManager();

        
    }

    @Override
    public void update(Player player) {
        super.update(player);
        checkInteractedWith(player);
        passKey();
        oneKey();

        draw();

    }
    
    public void checkInteractedWith(Player player) {
        if (intersects(player) && Keyboard.isKeyDown(Key.SPACE)) {
            isInteractedWith = true;
            System.out.println("Player interacted with keypad");    
            showKeypad();
            
        } else {
            isInteractedWith = false;
        }
        
    }


public void passKey(){
    if (isInteractedWith) {
        while (!correctPassKey) {
            String passCodeString = JOptionPane.showInputDialog(null, "Enter a 4-digit Passkey:", "Passkey Input", JOptionPane.QUESTION_MESSAGE);

            // handle if the user cancels the dialog
            if (passCodeString == null) {
                return; // or handle differently if you wish
            }

            try {
                int passCode = Integer.parseInt(passCodeString);

                if (passCode == 4269) {
                    replaceWallWithPassableTile();
                    JOptionPane.showMessageDialog(null, "Correct passcode entered. Access granted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    correctPassKey = true; // Set the flag to exit the loop
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect passcode. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 4-digit passcode.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


    public void showKeypad() {
        keypadContainer.setVisible(true);

       
        keypadContainer.setBounds(100, 100, 50, 100);
    }

    public void closeKeypad() {
        isKeypadVisible = false;
        keypadContainer.setVisible(false);
    }
    
        
      



    

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("DEFAULT", new Frame[]{
                new FrameBuilder(spriteSheet.getSprite(0, 0), 40)
                        .withScale(3)
                        .build(),
            });
        }};
    }
 
    public Map getMapReference() {
        return mapReference;
    }

    public void setMapReference(Map mapReference) {
        this.mapReference = mapReference;
    }


    private void replaceWallWithPassableTile() {
        try {
            Level2.replaceAllWallTilesInFile();
            
            if (this.getMapReference() instanceof Level2) {
                Level2 currentMap = (Level2) this.getMapReference();
                currentMap.reloadMapFromFile();
            } else {
                System.err.println("Error: Expected map of type Levele2 but encountered another type.");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }



public void draw() {
    screenManager.draw(graphicsHandler);

    // if game is paused, draw pause gfx over Screen gfx
    if (isInteractedWith) { 
       // graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 100));
    }
}

public int oneKey(){
    //keyLocker.unlockKey(Key.ONE);
    
    int numberToPrint = 1;
    if (Keyboard.isKeyDown(Key.ONE)) {
        System.out.println("Number to Print: " + numberToPrint);
    }
    return numberToPrint;
}

}


