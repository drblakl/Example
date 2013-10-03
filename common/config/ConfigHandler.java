package config;

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
        
        // test variables
        /*
        int test = config.get("useless stuff", "example", 5).getInt();
        String test2 = config.get("useless stuff", "Some text", "Default Text").getString();
        */
        
        /*
         * Get Values
         */
        EXAMPLE_VALUE = config.get(CATEGORY_USELESS, EXAMPLE_NAME, EXAMPLE_DEFAULT).getInt();
        SOME_TEXT_VALUE = config.get(CATEGORY_USELESS, SOME_TEXT_NAME, SOME_TEXT_DEFAULT).getString();
        
        
        // save changes
        config.save();
        
        //System.out.println(test2 + ": " + test);
    }
}
