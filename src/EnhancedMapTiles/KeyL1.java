package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Player;
import Level.TileType;
import Utils.Point;

import java.util.HashMap;

// This class is for the key 
// when the player touches it, it will log in terminal saying player interacted with the key and set isPickedUp = true
public class KeyL1 extends EnhancedMapTile {

    private boolean isKeyPickedUp = false;

    public KeyL1(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("key.png"), 16, 16), TileType.PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (!isKeyPickedUp && intersects(player)) {
            // Log the interaction
            System.out.println("Player picked up the key!");
            isKeyPickedUp = true; // Mark the key as picked up
        }
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("DEFAULT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0), 40)
                        .withScale(3)
                        .build(),

            });
        }};
    }
}
