package Game;

import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Engine.GameWindow;
import Engine.ScreenManager;

public class Game {
    private static long gameStartTime;
    private static String playerName;

    public static void main(String[] args) {
        playerName = getPlayerName();
        if (playerName != null && !playerName.trim().isEmpty()) {
            savePlayerNameToFile(playerName);
        }
        new Game();
    }

    public Game() {
        gameStartTime = System.currentTimeMillis();
        GameWindow gameWindow = new GameWindow();
        ScreenManager screenManager = gameWindow.getScreenManager();
        screenManager.setCurrentScreen(new ScreenCoordinator());
        gameWindow.startGame();
    }

    private static String getPlayerName() {
        return JOptionPane.showInputDialog("Enter Your Name:");
    }

    private static void savePlayerNameToFile(String name) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("playerNames.txt", true))) {
            writer.write(name + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void totalGameTimeTimerStop() {
        long totalGameTime = System.currentTimeMillis() - gameStartTime;
        saveGameTimeToFile(totalGameTime);
    }

    private static void saveGameTimeToFile(long gameTime) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("playerNames.txt", true))) {
            long totalSeconds = gameTime / 1000;
            long minutes = totalSeconds / 60;
            long seconds = totalSeconds % 60;
            String timeString = String.format("%s's game time: %d minutes and %d seconds\n", playerName, minutes, seconds);
            writer.write(timeString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
