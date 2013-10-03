package items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item wand;
	
	public static void init(){
		// Create a new item wand
		// Only time the new item is created
		wand = new ItemWand(ItemInfo.WAND_ID);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(wand, ItemInfo.WAND_NAME);
	}
	
	public static void registerRecipes(){
		GameRegistry.addRecipe(new ItemStack(wand, 1), 
				new Object[]{	"  X",
								" / ",
								"/  ",
								'X', Item.goldenCarrot,
								'/', Item.stick
		});
	}
}
