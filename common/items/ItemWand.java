package items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemWand extends Item {

    public ItemWand(int id) {
        super(id);
        
        setCreativeTab(CreativeTabs.tabCombat);
        // Can only hold 1
        setMaxStackSize(1);
        setUnlocalizedName(ItemInfo.WAND_UNLOCALIZEDNAME);
    }
    
    @Override
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase target){
    	if(!target.worldObj.isRemote){
    		target.motionY = 2;
    	}
    	return false;
    }

}
