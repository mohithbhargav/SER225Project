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

public class LaserL2 extends EnhancedMapTile {
    private Map mapReference;
    private KeyL1 keyTile; // Reference to KeyL1 object
    private boolean isControlledByKeypad = false;
    private boolean listenToKey = false;
    


    public LaserL2(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("laser.png"), 16, 16), TileType.NOT_PASSABLE);
        this.keyTile = null; // Initialize with null for scenarios without a linked key
    }

    public LaserL2(Point location, KeyL1 keyTile) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("laser.png"), 16, 16), TileType.NOT_PASSABLE);
        this.keyTile = keyTile; // Initialize with KeyL1 object for scenarios with a linked key
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (listenToKey && keyTile != null && keyTile.isKeyPickedUp()) {
            deactivate(); 
        }
    }

    public void setControlledByKeypad(boolean controlled) {
        this.isControlledByKeypad = controlled;
    }

    public void deactivate() {
        System.out.println("Laser Deactivated");
        this.mapEntityStatus = MapEntityStatus.REMOVED;
    }

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

    public void setMapReference(Map map) {
        this.mapReference = map;
    }

    public void setListenToKey(boolean listen) {
        this.listenToKey = listen;
    }
}
