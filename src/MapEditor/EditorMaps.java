package MapEditor;

import Level.Map;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.OnlyGitMap;
import Maps.Level2;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("OnlyGitMap");
            add("Level2");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "OnlyGitMap":
                return new OnlyGitMap();
            case "Level2":
                return new Level2();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
