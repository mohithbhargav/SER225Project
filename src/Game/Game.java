package Game;

import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Engine.GameWindow;
import Engine.ScreenManager;


/*
 * The game starts here
 * This class just starts up a GameWindow and attaches the ScreenCoordinator to the ScreenManager instance in the GameWindow
 * From this point on the ScreenCoordinator class will dictate what the game does
 */
public class Game {

    public static void main(String[] args) {
        String playerName = getPlayerName();
        if (playerName != null && !playerName.trim().isEmpty()) {
            savePlayerNameToFile(playerName);
        }
        new Game();
    }

    public Game() {
        GameWindow gameWindow = new GameWindow();
        ScreenManager screenManager = gameWindow.getScreenManager();
        screenManager.setCurrentScreen(new ScreenCoordinator());
        gameWindow.startGame();
    }

     private static String getPlayerName() {
        return JOptionPane.showInputDialog("Enter Your Name:");
    }
    private static void savePlayerNameToFile(String playerName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("playerNames.txt", true))) {
            writer.write(playerName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 