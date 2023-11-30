package Maps;


import Enemies.DinosaurEnemy;
import Enemies.GuardB;
import Enemies.GuardW;
import Engine.ImageLoader;
import EnhancedMapTiles.DoubleJump1;

import EnhancedMapTiles.EndLevelBoxL3;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import NPCs.EndElevator;
import NPCs.Lock;
import NPCs.StartElevator;
import NPCs.Switch;
import NPCs.Walrus;
import Screens.PlayLevelScreen;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;
import EnhancedMapTiles.Sprint1;
import EnhancedMapTiles.VerticalMovingPlatform;
import EnhancedMapTiles.StartLevelBox2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Represents a test map to be used in a level
public class Level4 extends Map {

    private PlayLevelScreen playLevelScreen;


    public Level4(PlayLevelScreen playLevelScreen) {
        super("Level4.txt", new CommonTileset());
        this.playLevelScreen = playLevelScreen;
        this.playerStartPosition = getMapTile(2, 11).getLocation();
    }

    public void reloadMapFromFile() {
        loadMapFile();
    }

      

    @Override
      public ArrayList<Enemy> loadEnemies() {
         ArrayList<Enemy> enemiesGuard = new ArrayList<>();

          // BugEnemy bugEnemy = new BugEnemy(getMapTile(16, 10).getLocation().subtractY(25), Direction.LEFT);
          // enemies.add(bugEnemy);




          GuardW guardw = new GuardW(getMapTile(5, 16).getLocation(), 
          getMapTile(20, 16).getLocation(),
          Direction.RIGHT);
          enemiesGuard.add(guardw);

            GuardB guardb = new GuardB(getMapTile(6, 6).getLocation(), 
            getMapTile(17, 6).getLocation(),
            Direction.LEFT);
            enemiesGuard.add(guardb);


            GuardW guardw2 = new GuardW(getMapTile(18, 16).getLocation(), 
            getMapTile(30, 16).getLocation(),
            Direction.RIGHT);
            enemiesGuard.add(guardw2);


            GuardW guardb2 = new GuardW(getMapTile(18, 16).getLocation(), 
            getMapTile(30, 16).getLocation(),
            Direction.RIGHT);
            enemiesGuard.add(guardb2);
         


            GuardB guardb3 = new GuardB(getMapTile(18, 6).getLocation(), 
            getMapTile(29, 6).getLocation(),
            Direction.LEFT);
            enemiesGuard.add(guardb3);




            GuardB guardb4 = new GuardB(getMapTile(27, 6).getLocation(), 
            getMapTile(34, 6).getLocation(),
            Direction.LEFT);
            enemiesGuard.add(guardb4);






         

         return enemiesGuard;
      }


    public static void replaceAllWallTilesInFile() throws IOException {
        // path
        String path = "MapFiles/Level4.txt";

        // Read the map file using the updated path
        List<String> lines = Files.readAllLines(Paths.get(path));

        // Modify the lines by replacing all 17 tiles with 7
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            line = line.replaceAll(" 54 ", " 7 "); // Replace all 54 tiles with 7
            lines.set(i, line);
        }

        // Write the modified map back to the file
        Files.write(Paths.get(path), lines);

    }

    public static void resetMapToFile() throws IOException {
        // Path to the backup map
        String backupPath = "MapFiles/Level4backup.txt";
        String targetPath = "MapFiles/Level4.txt";

        // Read the backup map
        List<String> backupLines = Files.readAllLines(Paths.get(backupPath));

        // Overwrite the target map with the backup map's content
        Files.write(Paths.get(targetPath), backupLines);
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();



        VerticalMovingPlatform vmp = new VerticalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(39, 8).getLocation(),
                getMapTile(39, 19).getLocation(),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6, 16, 4),
                Direction.DOWN);
        enhancedMapTiles.add(vmp);

        //EndLevelBoxL3 endLevelBoxL3 = new EndLevelBoxL3(getMapTile(42, 12).getLocation());
       // enhancedMapTiles.add(endLevelBoxL3);

        //StartLevelBox2 startLevelBox2 = StartLevelBox2(getMapTile(42, 12).getLocation());
        //enhancedMapTiles.add(startLevelBox2);

        return enhancedMapTiles;

    }

    //private StartLevelBox2 StartLevelBox2(Point location) {
       // return null;
   // }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        EndElevator endElevator = new EndElevator(getMapTile(1, 6).getLocation());
        npcs.add(endElevator);

        StartElevator startElevator = new StartElevator(getMapTile(1, 16).getLocation());
        npcs.add(startElevator); 

        Switch switchNPC = new Switch(getMapTile(12, 7).getLocation(), this.playLevelScreen);
        npcs.add(switchNPC);


        return npcs;
    }
}
