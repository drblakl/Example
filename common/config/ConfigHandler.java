package config;

import items.ItemInfo;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {
    private static final String CATEGORY_USELESS = "useless stuff";
    public static int EXAMPLE_VALUE;
    private static final String EXAMPLE_NAME = "example";
    private static final int EXAMPLE_DEFAULT = 5;
    
    public static String SOME_TEXT_VALUE;
    private static final String SOME_TEXT_NAME = "Some text";
    private static final String SOME_TEXT_DEFAULT = "Default text";
    
    public static void init(File file){
        Configuration config = new Configuration(file);
        
        // Load everything from config file
        config.load();
        
        ItemInfo.WAND_ID = config.getItem(ItemInfo.WAND_KEY, ItemInfo.WAND_DEFAULT).getInt() - 256;
        ItemInfo.CARD_ID = config.getItem(ItemInfo.CARD_KEY, ItemInfo.CARD_DEFAULT).getInt() - 256;
        
        // save changes
        config.save();
        
        //System.out.println(test2 + ": " + test);
    }
}
