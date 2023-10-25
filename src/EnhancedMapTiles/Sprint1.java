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

public class Sprint1 extends EnhancedMapTile {
    private Map mapReference;
    private boolean isKeyPickedUp = false;

    public Sprint1(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Sprinting.png"), 16, 16), TileType.PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (!isKeyPickedUp && intersects(player)) {
            System.out.println("Player picked up the sprint key!");
            isKeyPickedUp = true;
            activateSprintForPlayer(player);
        }
    }

    private void activateSprintForPlayer(Player player) {
        // Assuming you have a method in the Player class to activate sprinting
        player.activateSprint(15000); // 15000ms or 15 seconds
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
