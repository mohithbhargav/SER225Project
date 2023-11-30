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
public class CookCook extends NPC {

    public CookCook(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("PROF.png"), 34, 33), "TAIL_DOWN");
        boolean forCookCook = true;
        isInteractable = true;
        talkedToTime = 200;
        textbox.setText("HEEEEEEEEY Player, Can i talk to you...");
        textboxOffsetX = -4;
        textboxOffsetY = -34;
    }

    public void update(Player player) {
        // while npc is being talked to, it raises its tail up (in excitement?)
        if (talkedTo) {
            currentAnimationName = "TAIL_UP";
        } else {
            currentAnimationName = "TAIL_DOWN";
        }

        super.update(player);
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {
            {
                put("TAIL_DOWN", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(0, 0))
                                .withScale(3)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .build()
                });
                put("TAIL_UP", new Frame[] {
                        new FrameBuilder(spriteSheet.getSprite(1, 0))
                                .withScale(3)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .build()
                });
            }
        };
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
