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
import Utils.Point;

import java.util.HashMap;

public class Sprint1 extends EnhancedMapTile {
    private Map mapReference;
    private boolean isKeyPickedUp = false;

    public Sprint1(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Sprint.png"), 16, 16),
                TileType.PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (!isKeyPickedUp && intersects(player)) {
            System.out.println("Player picked up the Sprint power-up!");
            isKeyPickedUp = true;
            // Activate the temporary power-up through the Player class
            player.activateTemporaryPowerUp("Sprint");
            this.mapEntityStatus = MapEntityStatus.REMOVED;
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
