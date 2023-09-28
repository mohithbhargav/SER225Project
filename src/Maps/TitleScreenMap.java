package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import Tilesets.CommonTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class TitleScreenMap extends Map {

    private Sprite Cat;

    public TitleScreenMap() {
        super("title_screen_map.txt", new CommonTileset());
        Point CatLocation = getMapTile(6, 8).getLocation().subtractX(24).subtractY(6);
        Cat = new Sprite(ImageLoader.loadSubImage("PROB.png", Colors.MAGENTA, 0, 0, 24, 24));
        Cat.setScale(3);
        Cat.setLocation(CatLocation.x, CatLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        Cat.draw(graphicsHandler);
    }

}
