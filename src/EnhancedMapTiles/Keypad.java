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
import Engine.Keyboard;
import Engine.ScreenManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Keypad extends EnhancedMapTile {
    private final Key keyPadKey = Key.SPACE;
    private boolean isInteractedWith = false;
    private boolean correctPassKey = false;
    private Map mapReference;

    public Keypad(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Keypad.png"), 16, 16), TileType.PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player);
        checkInteractedWith(player);
        passKey();
    }

    public void checkInteractedWith(Player player) {
        if (intersects(player) && Keyboard.isKeyDown(keyPadKey)) {
            isInteractedWith = true;
            System.out.println("Player interacted with keypad");
        } else {
            isInteractedWith = false;
        }
    }

    public void passKey() {
        if (isInteractedWith) {
            while (!correctPassKey) {
                String passCodeString = JOptionPane.showInputDialog(null, "Enter a 4-digit Passkey:", "Passkey Input", JOptionPane.QUESTION_MESSAGE);

                if (passCodeString == null) return;

                try {
                    int passCode = Integer.parseInt(passCodeString);
                    if (passCode == 4269) {
                        replaceWallWithPassableTile();
                        JOptionPane.showMessageDialog(null, "Correct passcode entered. Access granted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        correctPassKey = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect passcode. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid 4-digit passcode.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
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

    private void replaceWallWithPassableTile() {
        try {
            Level2.replaceAllWallTilesInFile();
            if (this.getMapReference() instanceof Level2) {
                Level2 currentMap = (Level2) this.getMapReference();
                currentMap.reloadMapFromFile();
            } else {
                System.err.println("Error: Expected map of type Level2 but encountered another type.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
