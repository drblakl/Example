package blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

public class Blocks {
	public static Block machine;
	
	public static void init(){
		machine = new BlockMachine(BlockInfo.MACHINE_ID);
		// Doesn't have to be the same
		GameRegistry.registerBlock(machine, BlockInfo.MACHINE_KEY);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(machine,  BlockInfo.MACHINE_NAME);
	}
}
