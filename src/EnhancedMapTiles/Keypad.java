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
import Engine.ScreenManager;
import GameObject.Rectangle;
import SpriteFont.SpriteFont;
import Utils.Colors;
import javax.swing.*;
import java.awt.*;


import java.util.HashMap;

public class Keypad extends EnhancedMapTile{
    
    private Map mapReference;
    protected boolean isInteractable = false;
    protected boolean isinteractedWith = false;
    protected int talkedToTime; // how long after talking to NPC will textbox stay open -- use negative number to have it be infinite time
    protected int timer;
   
    


    public Keypad(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Keypad.png"), 16, 16), TileType.PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player);
        checkTalkedTo(player);
        
    }


    
    public void checkTalkedTo(Player player) {
        if ( intersects(player) && Keyboard.isKeyDown(Key.SPACE)) {
            System.out.println("Player interacted with keypad");    
            isinteractedWith = true;
        }
        
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



