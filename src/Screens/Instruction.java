package Screens;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;
import java.awt.Color;
import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the instruction screen
public class Instruction extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont instructionLabel;
    protected SpriteFont moveLeftLabel;
    protected SpriteFont moveRightLabel;
    protected SpriteFont jumpLabel;
    protected SpriteFont crouchLabel;
    protected SpriteFont returnInstructionsLabel;

    public Instruction(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        
        Font customFont;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("/Users/carmineandranovich/Library/Fonts/DePixelBreit.otf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            customFont = new Font("Times New Roman", Font.PLAIN, 30); // fallback to Times New Roman if custom font loading fails
        }
    
        instructionLabel = new SpriteFont("Instructions", 15, 7, customFont.getFontName(), 30, new Color(165, 42, 42)); // Brown color
        moveLeftLabel = new SpriteFont("Left arrow key to move left", 20, 50, customFont.getFontName(), 20, new Color(165, 42, 42)); // Brown color
        moveRightLabel = new SpriteFont("Right arrow key to move right", 20, 80, customFont.getFontName(), 20, new Color(165, 42, 42)); // Brown color
        jumpLabel = new SpriteFont("Up arrow key to jump", 20, 110, customFont.getFontName(), 20, new Color(165, 42, 42)); // Brown color
        crouchLabel = new SpriteFont("Down arrow key to crouch", 20, 140, customFont.getFontName(), 20, new Color(165, 42, 42)); // Brown color
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 170, customFont.getFontName(), 30, new Color(165, 42, 42)); // Brown color
        
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
        instructionLabel.draw(graphicsHandler);
        moveLeftLabel.draw(graphicsHandler);
        moveRightLabel.draw(graphicsHandler);
        jumpLabel.draw(graphicsHandler);
        crouchLabel.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
