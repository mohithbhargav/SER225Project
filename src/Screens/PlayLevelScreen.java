package Screens;

import Engine.GamePanel;
import Engine.GraphicsHandler;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Level.Player;
import Level.PlayerListener;
import Maps.Level2;
import Maps.OnlyGitMap;
import Maps.TestMap;
import Players.Cat;
import Utils.Point;
import javax.swing.JLabel;  
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;


// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen implements PlayerListener {
    protected ScreenCoordinator screenCoordinator;
    protected GamePanel pause; 
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected JLabel tLabel;
    protected int screenTimer;
    protected Timer timer;
    protected boolean isRunning;
    protected int minutes, seconds;
    static int sec1Log, min1Log;
   // protected Font font = new Font("Black Letter", Font.PLAIN, 50);
    protected String minute, second;
    protected int currentMap = 1;
    protected DecimalFormat dec = new DecimalFormat("00");
    protected LevelClearedScreen levelClearedScreen;
    protected LevelLoseScreen levelLoseScreen;
    protected boolean levelCompletedStateChangeStart;
    
    Font customFont;
   
    
    

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {

        playLevelScreenState = PlayLevelScreenState.RUNNING;
        // define/setup map

        if (currentMap == 1){
         this.map = new OnlyGitMap();  //change this to set first map (should be OnlyGitMap() )

        } else if (currentMap == 2){
            this.map = new Level2();

        } else 
        map.reset();

      
       

        // setup player
        if (currentMap == 1){
            this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y, currentMap);
   
           } else if (currentMap == 2){
            this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y, currentMap);
   
           }
        
        this.player.setMap(map);
        this.player.addListener(this);
        Point playerStartPosition = map.getPlayerStartPosition();
        this.player.setLocation(playerStartPosition.x, playerStartPosition.y);

        levelClearedScreen = new LevelClearedScreen();
        levelLoseScreen = new LevelLoseScreen(this);

        this.playLevelScreenState = PlayLevelScreenState.RUNNING;

        
        try {
            String fontFilePath = "Resources/DePixelBreit.otf";
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath)).deriveFont(55f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            customFont = new Font("Times New Roman", Font.PLAIN, 30); // fallback to Times New Roman if custom font loading fails
        }

        this.tLabel = new JLabel("");
        this.tLabel.setHorizontalAlignment(JLabel.CENTER);
        this.tLabel.setFont(customFont);

        
        tLabel.setText("0:00");
        seconds = 0;
        minutes = 1;
        second = dec.format(seconds);
        isRunning = true;

    // Adjust the timer based on the logged time for currentMap == 2
    if (currentMap == 2) { 
    minutes += min1Log;
    seconds += sec1Log;
    if (seconds >= 60) {
        minutes++;
        seconds -= 60;
    }
}


        Timer();
        timer.start();

        
    }

   

    

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the
            // platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
            if (levelCompletedStateChangeStart) {
                screenTimer = 130;
                levelCompletedStateChangeStart = false;
                currentMap += 1;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                            
                initialize();
            } else {
                levelClearedScreen.update();
                screenTimer--;
                if (screenTimer == 0 && currentMap == 2) {
                    goBackToMenu();
                }
            }
            break;
        
            // wait on level lose screen to make a decision (either resets level or sends
            // player back to main menu)
            case LEVEL_LOSE:
                levelLoseScreen.update();
                

                break;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(graphicsHandler);
                player.draw(graphicsHandler);
                graphicsHandler.drawString(minutes + ":" + dec.format(seconds), 350, 50, customFont, Color.LIGHT_GRAY);
                break;
            case LEVEL_COMPLETED:
                levelClearedScreen.draw(graphicsHandler);
                break;
            case LEVEL_LOSE:
                levelLoseScreen.draw(graphicsHandler);
                break;
        }
    }
    

    public void Timer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds--;
                if (seconds < 0) {
                    minutes--;
                    seconds = 59;
                }
                tLabel.setText(minutes + ":" + dec.format(seconds));
                if (minutes == 0 && seconds == 0) {
                    timer.stop();
                    playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE;
                }
            }
        });
    }
    

   public int getCurrentMap(){
    return currentMap;
   }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }

    @Override
    public void onLevelCompleted() {
        if (playLevelScreenState != PlayLevelScreenState.LEVEL_COMPLETED) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
            timer.stop();  // Stop the timer when the level is completed
            
            if (currentMap == 1) {
                min1Log = minutes;
                sec1Log = seconds;
                System.out.println("Time Left: " + min1Log + ":" + sec1Log);  // Log the time left
                currentMap++;
                initialize();
            } else if (currentMap == 2) {
                goBackToMenu();  // Go back to the menu after completing the second level
            }
        }
    }
    
    

    @Override
    public void onDeath() {
        if (playLevelScreenState != PlayLevelScreenState.LEVEL_LOSE) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE;
        }
    }

    public void resetLevel() {
        initialize();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED, LEVEL_LOSE
    }
}
