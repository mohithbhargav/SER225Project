package EnhancedMapTiles;

import Builders.FrameBuilder;
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
import Engine.Keyboard;
import EnhancedMapTiles.LaserL2;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

    public class Keypad extends EnhancedMapTile {
    private final Key keyPadKey = Key.SPACE;
    private boolean isInteractedWith = false;
    private boolean correctPassKey = false;
    private Map mapReference;
    private List<LaserL2> linkedLasers = new ArrayList<>(); // List of linked lasers



    public void addLinkedLaser(LaserL2 laser) {
        linkedLasers.add(laser);
    }

    public Keypad(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Keypad.png"), 16, 16), TileType.PASSABLE);
    }



    @Override
    public void update(Player player) {
        super.update(player);
        checkInteractedWith(player);
        if (isInteractedWith && !correctPassKey) {
            passKey();
        }
    }

    public void checkInteractedWith(Player player) {
        if (intersects(player) && Keyboard.isKeyDown(keyPadKey) && !isInteractedWith) {
            isInteractedWith = true;
            System.out.println("Player interacted with keypad");
        }
    }

    public void passKey() {
        String passCodeString = JOptionPane.showInputDialog(null, "Enter a 4-digit Passkey:", "Passkey Input", JOptionPane.QUESTION_MESSAGE);
        if (passCodeString == null) {
            isInteractedWith = false;
            return;
        }

        try {
            int passCode = Integer.parseInt(passCodeString);
            if (passCode == 4269) {
                for (LaserL2 laser : linkedLasers) {
                    laser.deactivate(); // Deactivate each linked laser
                }
                JOptionPane.showMessageDialog(null, "Correct passcode entered. Access granted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                correctPassKey = true;
                isInteractedWith = false;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect passcode. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid 4-digit passcode.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
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
