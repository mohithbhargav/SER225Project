package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

public class MainLevelTileset extends Tileset {

    private static final int tileWidth = 32;
    private static final int tileHeight = 32;

    public MainLevelTileset() {
        super(ImageLoader.load("Tileset_32x32.png"), tileWidth, tileHeight, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        for (int y = 0; y < spriteHeight; y += tileHeight) {
            for (int x = 0; x < spriteWidth; x += tileWidth) {
                Frame tileFrame = new FrameBuilder(getSubImage(x / tileWidth, y / tileHeight))
                        .withScale(tileScale)
                        .build();

                MapTileBuilder tile;
                if ((x == 175 && y == 40) || (x == 200 && y == 40)) {
                    tile = new MapTileBuilder(tileFrame)
                            .withTileType(TileType.PASSABLE);
                } else {
                    tile = new MapTileBuilder(tileFrame)
                            .withTileType(TileType.NOT_PASSABLE);
                }

                mapTiles.add(tile);
            }
        }

        return mapTiles;
    }
}
