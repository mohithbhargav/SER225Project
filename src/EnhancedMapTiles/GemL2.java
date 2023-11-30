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
import Maps.OnlyGitMap;
import Utils.Point;

import java.io.IOException;
import java.util.HashMap;

public class GemL2 extends EnhancedMapTile {

    private Map mapReference;
    private boolean isGemPickedUp = false;

    public GemL2(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("BG.png"), 16, 16), TileType.PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (!isGemPickedUp && intersects(player)) {
            // Use the addItemToInventory method from the Player class
            boolean wasAdded = player.addItemToInventory("BG");
            if (wasAdded) {
                System.out.println("Gem added to the inventory");
                isGemPickedUp = true;
                replaceWallWithPassableTile();
                this.mapEntityStatus = MapEntityStatus.REMOVED;
            } else {
                System.out.println("Inventory is full, cannot pick up the Gem!");
            }
        }
    }

    private void replaceWallWithPassableTile() {
        try {
            Level2.replaceAllWallTilesInFile();

            if (this.getMapReference() instanceof Level2) {
                Level2 currentMap = (Level2) this.getMapReference();
                currentMap.reloadMapFromFile();
            } else {
                System.err.println("Error: Expected map of type Level2 but encountered another type.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

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
