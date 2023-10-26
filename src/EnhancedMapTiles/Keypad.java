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
import Utils.Point;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.KeypadPanel;
import Engine.ScreenManager;
import GameObject.Rectangle;
import SpriteFont.SpriteFont;
import Utils.Colors;
import javax.swing.*;
import java.awt.*;


import java.util.HashMap;

public class Keypad extends EnhancedMapTile {
    private ScreenManager screenManager;
    private GraphicsHandler graphicsHandler;
    private SpriteFont kpad;
    private Thread gameLoopProcess;
    private KeyLocker keyLocker = new KeyLocker();
	private final Key keyPadKey = Key.SPACE;

    private JPanel keypadContainer;
    private KeypadPanel keypadPanel;
    
    private Map mapReference;
    protected boolean isInteractable = false;
    public boolean isInteractedWith = false;
    private boolean isKeypadVisible = false;
    
    


    public Keypad(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Keypad.png"), 16, 16), TileType.PASSABLE);
        keypadPanel = new KeypadPanel();
      

        keypadContainer = new JPanel();
        keypadContainer.add(keypadPanel);
        keypadContainer.setVisible(false);

        graphicsHandler = new GraphicsHandler();

		screenManager = new ScreenManager();

       // setLayout(new GridLayout(3, 3));

       //  kpad = new SpriteFont("PAUSE", 365, 280, "Comic Sans", 24, Color.white);
		//kpad.setOutlineColor(Color.black);
		 // kpad.setOutlineThickness(2.0f);
        
    }

    @Override
    public void update(Player player) {
        super.update(player);
        checkInteractedWith(player);
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


    public void showKeypad() {
        keypadContainer.setVisible(true);

        // You can also position the keypad container as needed
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



}


