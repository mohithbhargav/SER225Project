package Maps;

import Enemies.BugEnemy;
import Enemies.Death;
import Enemies.DinosaurEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.DoubleJump1;

import EnhancedMapTiles.EndLevelBoxL2;
import EnhancedMapTiles.GemL1;
import EnhancedMapTiles.GemL2;
import EnhancedMapTiles.GemL4;
import EnhancedMapTiles.KeyL1;
import EnhancedMapTiles.Keypad;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import NPCs.EndElevator;
import NPCs.StartElevator;
import Tilesets.CommonTileset;
import Utils.Direction;
import EnhancedMapTiles.Sprint1;
import EnhancedMapTiles.StartLevelBox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Represents a test map to be used in a level
public class EasterEggLevel extends Map {

    public EasterEggLevel() {
        super("EasterEggLevel.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(2, 11).getLocation();
    }

    public void reloadMapFromFile() {
        loadMapFile();
    }

    // @Override
    // public ArrayList<Enemy> loadEnemies() {
    // ArrayList<Enemy> enemies = new ArrayList<>();

    // BugEnemy bugEnemy = new BugEnemy(getMapTile(16,
    // 10).getLocation().subtractY(25), Direction.LEFT);
    // enemies.add(bugEnemy);

    // Death death = new Death(getMapTile(15, 19).getLocation(), Direction.LEFT);
    // enemies.add(death);

    // return enemies;
    // }

    public static void replaceAllWallTilesInFile() throws IOException {
        // path
        String path = "MapFiles/EasterEggLevel.txt";

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
        String backupPath = "MapFiles/EasterEggLevelbackup.txt";
        String targetPath = "MapFiles/EasterEggLevel.txt";

        // Read the backup map
        List<String> backupLines = Files.readAllLines(Paths.get(backupPath));

        // Overwrite the target map with the backup map's content
        Files.write(Paths.get(targetPath), backupLines);
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        HorizontalMovingPlatform hmp = new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(23, 10).getLocation(),
                getMapTile(26, 10).getLocation(),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6, 16, 4),
                Direction.RIGHT);
        enhancedMapTiles.add(hmp);

        HorizontalMovingPlatform hmp1 = new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(25, 4).getLocation(),
                getMapTile(27, 4).getLocation(),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6, 16, 4),
                Direction.RIGHT);
        enhancedMapTiles.add(hmp1);

        // StartLevelBox startLevelBox = new StartLevelBox(getMapTile(0,
        // 14).getLocation());
        // enhancedMapTiles.add(startLevelBox);

        // EndLevelBoxL2 endLevelBoxL2 = new EndLevelBoxL2(getMapTile(42,
        // 12).getLocation());
        // enhancedMapTiles.add(endLevelBoxL2);

        GemL4 geml4 = new GemL4(getMapTile(39, 7).getLocation());
        geml4.setMapReference(this);
        enhancedMapTiles.add(geml4);

        // Sprint1 key2L1 = new Sprint1(getMapTile(1, 35).getLocation());
        // key2L1.setMapReference(this); // Set the reference to this map
        // enhancedMapTiles.add(key2L1);

        // DoubleJump key3L1 = new DoubleJump(getMapTile(12, 17).getLocation());
        // key3L1.setMapReference(this); // Set the reference to this map
        // enhancedMapTiles.add(key3L1);

        return enhancedMapTiles;

    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        EndElevator endElevator = new EndElevator(getMapTile(42, 16).getLocation());
        npcs.add(endElevator);

        // StartElevator startElevator = new StartElevator(getMapTile(1,
        // 16).getLocation());
        // npcs.add(startElevator);

        return npcs;
    }

}
