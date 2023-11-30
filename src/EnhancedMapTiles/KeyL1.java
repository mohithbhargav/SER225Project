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
import Maps.OnlyGitMap;
import EnhancedMapTiles.Laser;
import Utils.Point;

import java.io.IOException;
import java.util.HashMap;

public class KeyL1 extends EnhancedMapTile {

    private Map mapReference;
    private boolean isKeyPickedUp = false;

    public KeyL1(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("keyl1.png"), 16, 16), TileType.PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (!isKeyPickedUp && intersects(player)) {
            // Use the addItemToInventory method from the Player class
            boolean wasAdded = player.addItemToInventory("KeyL1");
            if (wasAdded) {
                System.out.println("Key added to the inventory");
                isKeyPickedUp = true;
                this.mapEntityStatus = MapEntityStatus.REMOVED;

            } else {
                System.out.println("Inventory is full, cannot pick up the key!");
            }
        }
    }



    // private void replaceWallWithPassableTile() {
    //     try {
    //         OnlyGitMap.replaceAllWallTilesInFile();
            
    //         if (this.getMapReference() instanceof OnlyGitMap) {
    //             OnlyGitMap currentMap = (OnlyGitMap) this.getMapReference();
    //             currentMap.reloadMapFromFile();
    //         } else {
    //             System.err.println("Error: Expected map of type OnlyGitMap but encountered another type.");
    //         }
            
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //         // Handle the exception
    //     }
    // }

    

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("DEFAULT", new Frame[]{
                new FrameBuilder(spriteSheet.getSprite(0, 0), 40)
                        .withScale(3)
                        .build(),
            });
        }};
    }

    // In KeyL1 class
    public boolean isKeyPickedUp() {
    return this.isKeyPickedUp;
}

    public Map getMapReference() {
        return mapReference;
    }

    public void setMapReference(Map mapReference) {
        this.mapReference = mapReference;
    }
}
