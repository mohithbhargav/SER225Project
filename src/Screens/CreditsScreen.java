package Screens;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;

import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

// This class is for the credits screen
public class CreditsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont returnInstructionsLabel;

    public CreditsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

        @Override
        public void initialize() {
            // setup graphics on screen (background map, spritefont text)
            background = new TitleScreenMap();
            background.setAdjustCamera(false);
            
            Font customFont;
            try {
                String fontFilePath = "Resources/DePixelBreit.otf";
                customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath)).deriveFont(30f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(customFont);
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
                customFont = new Font("Times New Roman", Font.PLAIN, 30); // fallback to Times New Roman if custom font loading fails
            }
            
            creditsLabel = new SpriteFont("Credits", 15, 7, customFont.getFontName(), 30, new Color(165, 42, 42)); // Brown color
            createdByLabel = new SpriteFont("Created by OnlyGit", 130, 121, customFont.getFontName(), 20, new Color(165, 42, 42)); // Brown color
            returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 532, customFont.getFontName(), 30, new Color(165, 42, 42)); // Brown color
            
            keyLocker.lockKey(Key.SPACE);
        }
        

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        creditsLabel.draw(graphicsHandler);
        createdByLabel.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
