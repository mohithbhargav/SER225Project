package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Screens.PlayLevelScreen;
import Utils.Point;

import java.util.HashMap;

// This class is for the walrus NPC
public class Switch extends NPC {

        public PlayLevelScreen playLevelScreen;


     public Switch(Point location, PlayLevelScreen playLevelScreen) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Switch.png"), 16, 16), "DEFAULT");
        this.playLevelScreen = playLevelScreen;
        forWalrus = true;
        isInteractable = false;
        talkedToTime = 200;
        textbox.setText("GO BACK TO LEVEL 3! FIND THE SECRET ENTRACE");
        textboxOffsetX = -4;
        textboxOffsetY = -34;
    }
    
    @Override
    public void update(Player player) {
        if (talkedTo) {
            // Change the overlay alpha value in PlayLevelScreen
            //playLevelScreen.setOverlayAlpha(0);

            playLevelScreen.lightsOff = false;
            textbox.setText("GO BACK TO LEVEL 3! FIND THE SECRET ENTRANCE");
        }
        super.update(player);
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
