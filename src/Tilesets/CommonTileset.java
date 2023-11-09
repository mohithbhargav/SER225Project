package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;
import Utils.SlopeTileLayoutUtils;

import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class CommonTileset extends Tileset {

    public CommonTileset() {
        super(ImageLoader.load("Tiles.png"), 16, 16, 3);
    }

    

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        //block0
        Frame Block0Frame = new FrameBuilder(getSubImage(0, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block0Tile = new MapTileBuilder(Block0Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block0Tile);

        //block 1
        Frame Block1Frame = new FrameBuilder(getSubImage(0, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block1Tile = new MapTileBuilder(Block1Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block1Tile);

        //block2
        Frame Block2Frame = new FrameBuilder(getSubImage(0, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block2Tile = new MapTileBuilder(Block2Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block2Tile);

        //block3
        Frame Block3Frame = new FrameBuilder(getSubImage(0, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block3Tile = new MapTileBuilder(Block3Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block3Tile);

        //block4
        Frame Block4Frame = new FrameBuilder(getSubImage(0, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block4Tile = new MapTileBuilder(Block4Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block4Tile);

        //block5
        Frame Block5Frame = new FrameBuilder(getSubImage(0, 5))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block5Tile = new MapTileBuilder(Block5Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block5Tile);
        

        //next line of sprite sheet

        //block6
        Frame Block6Frame = new FrameBuilder(getSubImage(1, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block6Tile = new MapTileBuilder(Block6Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block6Tile);

        //blockNew1
        Frame BlockNew1Frame = new FrameBuilder(getSubImage(1, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder BlockNew1Tile = new MapTileBuilder(BlockNew1Frame);
        //.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(BlockNew1Tile);  
        
        //block7
        Frame Block7Frame = new FrameBuilder(getSubImage(1, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block7Tile = new MapTileBuilder(Block7Frame);
        mapTiles.add(Block7Tile);       

        //block8
        Frame Block8Frame = new FrameBuilder(getSubImage(1, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block8Tile = new MapTileBuilder(Block8Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block8Tile);

        //block9
        Frame Block9Frame = new FrameBuilder(getSubImage(1,4))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block9Tile = new MapTileBuilder(Block9Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block9Tile);      
        
        //block10
        Frame Block10Frame = new FrameBuilder(getSubImage(1,5))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block10Tile = new MapTileBuilder(Block10Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block10Tile);      
        
        
        //next line from sprite sheet

        //block11
        Frame Block11Frame = new FrameBuilder(getSubImage(2,0))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block11Tile = new MapTileBuilder(Block11Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block11Tile);     


        //block12
        Frame Block12Frame = new FrameBuilder(getSubImage(2,1))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block12Tile = new MapTileBuilder(Block12Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block12Tile);     

        //block13
        Frame Block13Frame = new FrameBuilder(getSubImage(2,2))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block13Tile = new MapTileBuilder(Block13Frame)
        .withTileType(TileType.NOT_PASSABLE);


        mapTiles.add(Block13Tile);    

        //block14
        Frame Block14Frame = new FrameBuilder(getSubImage(2,3))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block14Tile = new MapTileBuilder(Block14Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block14Tile);    


        //block15
        Frame Block15Frame = new FrameBuilder(getSubImage(2,4))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block15Tile = new MapTileBuilder(Block15Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block15Tile);
        

        //block16
        Frame Block16Frame = new FrameBuilder(getSubImage(2,5))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block16Tile = new MapTileBuilder(Block16Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block16Tile);    


        //next line of sprite sheet

        //block17
        Frame Block17Frame = new FrameBuilder(getSubImage(3,0))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block17Tile = new MapTileBuilder(Block17Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block17Tile);    


        //block18
        Frame Block18Frame = new FrameBuilder(getSubImage(3,1))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block18Tile = new MapTileBuilder(Block18Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block18Tile);    

        //block19
        Frame Block19Frame = new FrameBuilder(getSubImage(3,2))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block19Tile = new MapTileBuilder(Block19Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block19Tile);    

        //block20
        Frame Block20Frame = new FrameBuilder(getSubImage(3,3))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block20Tile = new MapTileBuilder(Block20Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block20Tile);    


        //block21
        Frame Block21Frame = new FrameBuilder(getSubImage(3,4))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block21Tile = new MapTileBuilder(Block21Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block21Tile);   

        //block22
        Frame Block22Frame = new FrameBuilder(getSubImage(3,5))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block22Tile = new MapTileBuilder(Block22Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block22Tile);   


        //next line of sprite sheet

        //block23
        Frame Block23Frame = new FrameBuilder(getSubImage(4,0))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block23Tile = new MapTileBuilder(Block23Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block23Tile);  
        
        //block24
        Frame Block24Frame = new FrameBuilder(getSubImage(4,1))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block24Tile = new MapTileBuilder(Block24Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block24Tile);   

        //block25
        Frame Block25Frame = new FrameBuilder(getSubImage(4,2))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block25Tile = new MapTileBuilder(Block25Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block25Tile);   

        //block26
        Frame Block26Frame = new FrameBuilder(getSubImage(4,3))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block26Tile = new MapTileBuilder(Block26Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block26Tile);   

        //block27
        Frame Block27Frame = new FrameBuilder(getSubImage(4,4))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block27Tile = new MapTileBuilder(Block27Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block27Tile);   

        //block28
        Frame Block28Frame = new FrameBuilder(getSubImage(4,4))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block28Tile = new MapTileBuilder(Block28Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block28Tile);  
        
        //next line of sprite sheet

        //block29
        Frame Block29Frame = new FrameBuilder(getSubImage(5,0))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block29Tile = new MapTileBuilder(Block29Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block29Tile);  

        //block30
        Frame Block30Frame = new FrameBuilder(getSubImage(5,1))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block30Tile = new MapTileBuilder(Block30Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block30Tile);  

        //block31
        Frame Block31Frame = new FrameBuilder(getSubImage(5,2))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block31Tile = new MapTileBuilder(Block31Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block31Tile);  


        //block32
        Frame Block32Frame = new FrameBuilder(getSubImage(5,3))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block32Tile = new MapTileBuilder(Block32Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block32Tile);  

        //block33
        Frame Block33Frame = new FrameBuilder(getSubImage(5,4))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block33Tile = new MapTileBuilder(Block33Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block33Tile); 

        //block34
        Frame Block34Frame = new FrameBuilder(getSubImage(5,5))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block34Tile = new MapTileBuilder(Block34Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block34Tile); 


        //next line of sprite sheet

        //block35
        Frame Block35Frame = new FrameBuilder(getSubImage(6,0))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block35Tile = new MapTileBuilder(Block35Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block35Tile); 

        //block36
        Frame Block36Frame = new FrameBuilder(getSubImage(6,1))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block36Tile = new MapTileBuilder(Block36Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block36Tile); 

        //block37
        Frame Block37Frame = new FrameBuilder(getSubImage(6,2))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block37Tile = new MapTileBuilder(Block37Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block37Tile); 

        //block38
        Frame Block38Frame = new FrameBuilder(getSubImage(6,3))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block38Tile = new MapTileBuilder(Block38Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block38Tile); 

        //block39
        Frame Block39Frame = new FrameBuilder(getSubImage(6,4))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block39Tile = new MapTileBuilder(Block39Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block39Tile); 

        //block40
        Frame Block40Frame = new FrameBuilder(getSubImage(6,5))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block40Tile = new MapTileBuilder(Block40Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block40Tile); 


       //next line of sprite sheet

        //block41
        Frame Block41Frame = new FrameBuilder(getSubImage(7,0))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block41Tile = new MapTileBuilder(Block41Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block41Tile); 

        //block42
        Frame Block42Frame = new FrameBuilder(getSubImage(7,1))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block42Tile = new MapTileBuilder(Block42Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block42Tile); 

        //block43
        Frame Block43Frame = new FrameBuilder(getSubImage(7,2))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block43Tile = new MapTileBuilder(Block43Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block43Tile); 

        //block44
        Frame Block44Frame = new FrameBuilder(getSubImage(7,3))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block44Tile = new MapTileBuilder(Block44Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block44Tile); 

        //block45
        Frame Block45Frame = new FrameBuilder(getSubImage(7,4))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block45Tile = new MapTileBuilder(Block45Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block45Tile); 

        //block46
        Frame Block46Frame = new FrameBuilder(getSubImage(7,5))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block46Tile = new MapTileBuilder(Block46Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block46Tile); 

       //next line of sprite sheet

        //block47
        Frame Block47Frame = new FrameBuilder(getSubImage(8,0))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block47Tile = new MapTileBuilder(Block47Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block47Tile); 

        //block48
        Frame Block48Frame = new FrameBuilder(getSubImage(8,1))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block48Tile = new MapTileBuilder(Block48Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block48Tile); 

        //block49
        Frame Block49Frame = new FrameBuilder(getSubImage(8,2))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block49Tile = new MapTileBuilder(Block49Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block49Tile); 

        //block50
        Frame Block50Frame = new FrameBuilder(getSubImage(8,3))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block50Tile = new MapTileBuilder(Block44Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block50Tile); 

        //block51
        Frame Block51Frame = new FrameBuilder(getSubImage(8,4))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block51Tile = new MapTileBuilder(Block51Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block51Tile); 

        //block52
        Frame Block52Frame = new FrameBuilder(getSubImage(8,5))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block52Tile = new MapTileBuilder(Block52Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block52Tile); 

        //block54
        Frame Block54Frame = new FrameBuilder(getSubImage(9,0))
        .withScale(tileScale)
        .build();

        MapTileBuilder Block54Tile = new MapTileBuilder(Block54Frame)
        .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(Block54Tile); 

        //block55
        Frame Block55Frame = new FrameBuilder(getSubImage(9,1))
        .withScale(tileScale)
        .build();
        
        MapTileBuilder Block55Tile = new MapTileBuilder(Block55Frame)
        .withTileType(TileType.PASSABLE);
        
        mapTiles.add(Block55Tile); 

         //block56
        Frame Block56Frame = new FrameBuilder(getSubImage(9,2))
        .withScale(tileScale)
        .build();
        
        MapTileBuilder Block56Tile = new MapTileBuilder(Block56Frame)
        .withTileType(TileType.PASSABLE);
        
        mapTiles.add(Block56Tile); 

        //block57
        Frame Block57Frame = new FrameBuilder(getSubImage(9,3))
        .withScale(tileScale)
        .build();
        
        MapTileBuilder Block57Tile = new MapTileBuilder(Block57Frame)
        .withTileType(TileType.PASSABLE);
        
        mapTiles.add(Block57Tile); 


        //block58
        Frame Block58Frame = new FrameBuilder(getSubImage(9,4))
        .withScale(tileScale)
        .build();
        
        MapTileBuilder Block58Tile = new MapTileBuilder(Block58Frame)
        .withTileType(TileType.PASSABLE);
        
        mapTiles.add(Block58Tile); 


        //block59
        Frame Block59Frame = new FrameBuilder(getSubImage(9,5))
        .withScale(tileScale)
        .build();
        
        MapTileBuilder Block59Tile = new MapTileBuilder(Block59Frame)
        .withTileType(TileType.NOT_PASSABLE);
        
        mapTiles.add(Block59Tile); 






    /*    // grasss
        Frame grassFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassTile = new MapTileBuilder(grassFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassTile);

        // sky
        Frame skyFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder skyTile = new MapTileBuilder(skyFrame);

        mapTiles.add(skyTile);

        // dirt
        Frame dirtFrame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder dirtTile = new MapTileBuilder(dirtFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(dirtTile);

        // sun
        Frame[] sunFrames = new Frame[]{
                new FrameBuilder(getSubImage(2, 0), 50)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(2, 1), 50)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder sunTile = new MapTileBuilder(sunFrames);

        mapTiles.add(sunTile);

        // tree trunk with full hole
        Frame treeTrunkWithFullHoleFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkWithFullHoleTile = new MapTileBuilder(treeTrunkWithFullHoleFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkWithFullHoleTile);

        // left end branch
        Frame leftEndBranchFrame = new FrameBuilder(getSubImage(1, 5))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder leftEndBranchTile = new MapTileBuilder(leftEndBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

        mapTiles.add(leftEndBranchTile);

        // right end branch
        Frame rightEndBranchFrame = new FrameBuilder(getSubImage(1, 5))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightEndBranchTile = new MapTileBuilder(rightEndBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

        mapTiles.add(rightEndBranchTile);

        // tree trunk
        Frame treeTrunkFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkTile = new MapTileBuilder(treeTrunkFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkTile);

        // tree top leaves
        Frame treeTopLeavesFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTopLeavesTile = new MapTileBuilder(treeTopLeavesFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTopLeavesTile);

        // yellow flower
        Frame[] yellowFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(1, 2), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 3), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 2), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 4), 65)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder yellowFlowerTile = new MapTileBuilder(yellowFlowerFrames);

        mapTiles.add(yellowFlowerTile);

        // purple flower
        Frame[] purpleFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(0, 3), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 4), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 3), 65)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 5), 65)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder purpleFlowerTile = new MapTileBuilder(purpleFlowerFrames);

        mapTiles.add(purpleFlowerTile);

        // middle branch
        Frame middleBranchFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder middleBranchTile = new MapTileBuilder(middleBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

        mapTiles.add(middleBranchTile);

        // tree trunk hole top
        Frame treeTrunkHoleTopFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkHoleTopTile = new MapTileBuilder(treeTrunkHoleTopFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkHoleTopTile);

        // tree trunk hole bottom
        Frame treeTrunkHoleBottomFrame = new FrameBuilder(getSubImage(2, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkHoleBottomTile = new MapTileBuilder(treeTrunkHoleBottomFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkHoleBottomTile);

        // top water
        Frame topWaterFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder topWaterTile = new MapTileBuilder(topWaterFrame);

        mapTiles.add(topWaterTile);

        // water
        Frame waterFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder waterTile = new MapTileBuilder(waterFrame)
                .withTileType(TileType.WATER);

        mapTiles.add(waterTile);

        // grey rock
        Frame greyRockFrame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder greyRockTile = new MapTileBuilder(greyRockFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(greyRockTile);

        // left 45 degree slope
        Frame leftSlopeFrame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftSlopeTile = new MapTileBuilder(leftSlopeFrame)
                .withTileType(TileType.SLOPE)
                .withTileLayout(SlopeTileLayoutUtils.createLeft45SlopeLayout(spriteWidth, (int) tileScale));

        mapTiles.add(leftSlopeTile);

        // right 45 degree slope
        Frame rightSlopeFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder rightSlopeTile = new MapTileBuilder(rightSlopeFrame)
                .withTileType(TileType.SLOPE)
                .withTileLayout(SlopeTileLayoutUtils.createRight45SlopeLayout(spriteWidth, (int) tileScale));

        mapTiles.add(rightSlopeTile);

        // left 30 degree slope bottom
        Frame leftStairsBottomFrame = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftStairsBottomTile = new MapTileBuilder(leftStairsBottomFrame)
                .withTileType(TileType.SLOPE)
                .withTileLayout(SlopeTileLayoutUtils.createBottomLeft30SlopeLayout(spriteWidth, (int) tileScale));

        mapTiles.add(leftStairsBottomTile);

        // left 30 degree slope top
        Frame leftStairsTopFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder leftStairsTopTile = new MapTileBuilder(leftStairsTopFrame)
                .withTileType(TileType.SLOPE)
                .withTileLayout(SlopeTileLayoutUtils.createTopLeft30SlopeLayout(spriteWidth, (int) tileScale));

        mapTiles.add(leftStairsTopTile);

        */

        return mapTiles;
    }
}
