package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Map;
import Level.Player;
import Level.TileType;
import Utils.Point;

import java.util.HashMap;

public class DoubleJump1 extends EnhancedMapTile {
    private Map mapReference;
    private boolean isKeyPickedUp = false;

<<<<<<< HEAD:src/EnhancedMapTiles/DoubleJump1.java
    public DoubleJump1(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("JumpingIcon.png"), 16, 16), TileType.PASSABLE);
=======
    public DoubleJump(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Sprinting.png"), 16, 16), TileType.PASSABLE);
>>>>>>> b93e7a3971ded200c9b8dd80c83091f2752ad1af:src/EnhancedMapTiles/DoubleJump.java
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (!isKeyPickedUp && intersects(player)) {
            System.out.println("Player picked up the Double Jump key!");
            isKeyPickedUp = true;
            activateDoubleJumpForPlayer(player);
        }
    }

    private void activateDoubleJumpForPlayer(Player player) {
        // Assuming you have a method in the Player class to activate double jumping
        player.updateDoubleJump();
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

    public Map getMapReference() {
        return mapReference;
    }

    public void setMapReference(Map mapReference) {
        this.mapReference = mapReference;
    }
}
