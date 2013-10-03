package items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemWand extends Item {

    public ItemWand(int id) {
        super(id);
        
        setCreativeTab(CreativeTabs.tabCombat);
        
        // Can only hold 1
        setMaxStackSize(1);
    }

}
