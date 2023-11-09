package NPCs;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;

import Level.NPC;
import Level.Player;
import Utils.Point;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Map;
import Level.Player;

import Maps.OnlyGitMap;
import Utils.Point;
import Engine.Key;
import Engine.Keyboard;
import Engine.ScreenManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class StartElevator extends NPC {
    private Map mapReference;

    public StartElevator(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("EndElevator.png"), 32, 32), "OPEN");

        isInteractable = true;
        talkedToTime = 200;
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (talkedTo) {
            currentAnimationName = "ClOSED";
            System.out.println("Player interacted with Elevator");
            
        } else {
            currentAnimationName = "OPEN";
        }

    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
           put("CLOSED", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(3)
                           .build()
           });
            put("OPEN", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(1, 0))
                            .withScale(3)
                            .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

    public Map getMapReference() {
        return mapReference;
    }

    public void setMapReference(Map mapReference) {
        this.mapReference = mapReference;
    }

    
}
