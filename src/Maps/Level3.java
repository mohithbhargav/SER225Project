package Maps;

import Enemies.BugEnemy;
import Enemies.Death;
import Engine.ImageLoader;
import EnhancedMapTiles.DoubleJump1;

import EnhancedMapTiles.EndLevelBoxL3;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import NPCs.EndElevator;
import NPCs.StartElevator;
import NPCs.Walrus;
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
public class Level3 extends Map {

    public Level3() {
        super("Level3.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(2, 11).getLocation();
    }

    public void reloadMapFromFile() {
        loadMapFile();
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        Death death1 = new Death(getMapTile(5, 19).getLocation(), Direction.LEFT);
        enemies.add(death1);

        Death death2 = new Death(getMapTile(8, 19).getLocation(), Direction.LEFT);
        enemies.add(death2);

        Death death3 = new Death(getMapTile(15, 19).getLocation(), Direction.LEFT);
        enemies.add(death3);

        Death death4 = new Death(getMapTile(19, 19).getLocation(), Direction.LEFT);
        enemies.add(death4);

        Death death5 = new Death(getMapTile(20, 19).getLocation(), Direction.LEFT);
        enemies.add(death5);

        Death death6 = new Death(getMapTile(21, 19).getLocation(), Direction.LEFT);
        enemies.add(death6);

        Death death7 = new Death(getMapTile(22, 19).getLocation(), Direction.LEFT);
        enemies.add(death7);

        Death death8 = new Death(getMapTile(27, 19).getLocation(), Direction.LEFT);
        enemies.add(death8);

        Death death9 = new Death(getMapTile(28, 19).getLocation(), Direction.LEFT);
        enemies.add(death9);

        Death death10 = new Death(getMapTile(29, 19).getLocation(), Direction.LEFT);
        enemies.add(death10);

      

        /*
         * DinosaurEnemy dinosaurEnemy = new DinosaurEnemy(getMapTile(19,
         * 1).getLocation().addY(2), getMapTile(22, 1).getLocation().addY(2),
         * Direction.RIGHT);
         * enemies.add(dinosaurEnemy);
         */

        return enemies;
    }

    public static void replaceAllWallTilesInFile() throws IOException {
        // path
        String path = "MapFiles/Level3.txt";

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
        String backupPath = "MapFiles/Level3backup.txt";
        String targetPath = "MapFiles/Level3.txt";

        // Read the backup map
        List<String> backupLines = Files.readAllLines(Paths.get(backupPath));

        // Overwrite the target map with the backup map's content
        Files.write(Paths.get(targetPath), backupLines);
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        HorizontalMovingPlatform hmp1 = new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(19, 5).getLocation(),
                getMapTile(23,5).getLocation(),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6, 16, 4),
                Direction.LEFT);

        enhancedMapTiles.add(hmp1);


        HorizontalMovingPlatform hmp2 = new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(26, 5).getLocation(),
                getMapTile(30,5).getLocation(),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6, 16, 4),
                Direction.LEFT);

        enhancedMapTiles.add(hmp2);

        HorizontalMovingPlatform hmp3 = new HorizontalMovingPlatform(
            ImageLoader.load("GreenPlatform.png"),
            getMapTile(33, 5).getLocation(),
            getMapTile(35,5).getLocation(),
            TileType.JUMP_THROUGH_PLATFORM,
            3,
            new Rectangle(0, 6, 16, 4),
            Direction.LEFT);

    enhancedMapTiles.add(hmp3);



        VerticalMovingPlatform vmp = new VerticalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(5, 8).getLocation(),
                getMapTile(5, 19).getLocation(),
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

        EndElevator endElevator = new EndElevator(getMapTile(40, 4).getLocation());
        npcs.add(endElevator);

        StartElevator startElevator = new StartElevator(getMapTile(1, 16).getLocation());
        npcs.add(startElevator);

        return npcs;
    }
}
