package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Point;

import java.util.HashMap;

// This class is for the walrus NPC
public class Lock extends NPC {

    public Lock(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Lock.png"), 16, 16), "DEFAULT");
        forWalrus = true;
        isInteractable = false;
        talkedToTime = 200;
        textbox.setText("LASER DISABLED");
        textboxOffsetX = -4;
        textboxOffsetY = -34;
    }
    
    @Override
    public void update(Player player) {
        // Check if KeyL1 is in the player's inventory
        if (player.hasItemInInventory("KeyL1")) {
            isInteractable = true;
        } else {
            isInteractable = false;
        }
        super.update(player);

        if (talkedTo) {

            player.removeItemFromInventory("KeyL1");
        }
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

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
