package Screens;

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
        instructionLabel = new SpriteFont("Instructions", 15, 7, "Times New Roman", 30, Color.white);
        moveLeftLabel = new SpriteFont("Left arrow key to move left", 20, 50, "Times New Roman", 20, Color.white);
        moveRightLabel = new SpriteFont("Right arrow key to move right", 20, 80, "Times New Roman", 20, Color.white);
        jumpLabel = new SpriteFont("Up arrow key to jump", 20, 110, "Times New Roman", 20, Color.white);
        crouchLabel = new SpriteFont("Down arrow key to crouch", 20, 140, "Times New Roman", 20, Color.white);
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 170, "Times New Roman", 30, Color.white);
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
