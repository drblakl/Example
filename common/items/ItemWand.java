package items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWand extends Item {

	@SideOnly(Side.CLIENT)
	private Icon chargedIcon;
	
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
    		
    		if(isCharged(itemstack.getItemDamage())){
    			target.motionX = (target.posX - player.posX) * 2;
    			target.motionZ = (target.posZ - player.posZ) * 2;
    			
    			itemstack.setItemDamage(0);
    		}
    		else{
    			// Set item damage to track how many times the item has been used
    			itemstack.setItemDamage(itemstack.getItemDamage() + 1);
    		}
    	}
    	return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register){
    	itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.WAND_ICON);
    	chargedIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.WAND_CHARGED_ICON);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation){
    	info.add("This fun thing has been used " + itemstack.getItemDamage() + " times");
    	
    	if(isCharged(itemstack.getItemDamage())){
    		info.add("This item is charged!");
    	}
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg){
    	if(isCharged(dmg)){
    		return chargedIcon;
    	}
    	else{
    		return itemIcon;
    	}    	
    }
    
    private boolean isCharged(int dmg){
    	return dmg >= 10;
    }
}
