package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Map;
import Level.MapEntityStatus;
import Level.Player;
import Level.TileType;
import Maps.Level2;
import Maps.Level3;
import Maps.OnlyGitMap;
import Utils.Point;

import java.io.IOException;
import java.util.HashMap;

public class GemL4 extends EnhancedMapTile {

    private Map mapReference;
    private boolean isGemPickedUp = false;

    public GemL4(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("YG.png"), 16, 16), TileType.PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (!isGemPickedUp && intersects(player)) {
            // Use the addItemToInventory method from the Player class
            boolean wasAdded = player.addItemToInventory("YG");
            if (wasAdded) {
                System.out.println("Gem added to the inventory");
                System.out.println("At one time, the biggest drug dealer was the British Empire!");
                isGemPickedUp = true;
                // replaceWallWithPassableTile();
                this.mapEntityStatus = MapEntityStatus.REMOVED;
            } else {
                System.out.println("Inventory is full, cannot pick up the Gem!");
            }
        }
    }

    // private void replaceWallWithPassableTile() {
    // try {
    // Level3.replaceAllWallTilesInFile();

    // if (this.getMapReference() instanceof Level3) {
    // Level3 currentMap = (Level3) this.getMapReference();
    // currentMap.reloadMapFromFile();
    // } else {
    // System.err.println("Error: Expected map of type Level3 but encountered
    // another type.");
    // }

    // } catch (IOException e) {
    // e.printStackTrace();
    // // Handle the exception
    // }
    // }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {
            {
                put("DEFAULT", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0), 40)
                                .withScale(3)
                                .build(),
                });
            }
        };
    }

    public Map getMapReference() {
        return mapReference;
    }

    public void setMapReference(Map mapReference) {
        this.mapReference = mapReference;
    }
}
