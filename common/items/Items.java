package items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static Item wand;
	public static Item card;
	
	public static void init(){
		// Create a new item wand
		// Only time the new item is created
		wand = new ItemWand(ItemInfo.WAND_ID);
		card = new ItemCard(ItemInfo.CARD_ID);
		
		/*
		 * DO NOT Create items associated with blocks here
		 */
	}
	
	public static void addNames(){
		LanguageRegistry.addName(wand, ItemInfo.WAND_NAME);
		
		// Loop through all subtypes
		for(int i = 0; i < ItemInfo.CARD_NAMES.length; i++){
			LanguageRegistry.addName(new ItemStack(card, 1, i), ItemInfo.CARD_NAMES[i]);	
		}
	}
	
	public static void registerRecipes(){
		/*
		 * Wand recipe
		 */
		GameRegistry.addRecipe(new ItemStack(wand, 1), 
				new Object[]{	"  X",
								" / ",
								"/  ",
								'X', Item.goldenCarrot,
								'/', Item.stick
		});
		
		/*
		 * Card Arrow example recipe
		 */
		GameRegistry.addRecipe(new ItemStack(card, 1, 0), 
				new Object[]{	"  x",
								"xxx",
								"  x",
								'x', Item.coal
		});		
		
	}
}
