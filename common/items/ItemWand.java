package items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
    		// Set item damage to track how many times the item has been used
    		itemstack.setItemDamage(itemstack.getItemDamage() + 1);
    	}
    	return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register){
    	itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.WAND_ICON);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation){
    	info.add("This fun thing has been used " + itemstack.getItemDamage() + " times");
    }
}
