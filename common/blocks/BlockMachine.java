package blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMachine extends Block {

	public BlockMachine(int id) {
		super(id, Material.iron);
		
		setCreativeTab(CreativeTabs.tabRedstone);
		setHardness(2F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.MACHINE_UNLOCALIZED_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	
	@SideOnly(Side.CLIENT)
	private Icon botIcon;
	
	@SideOnly(Side.CLIENT)
	private Icon[] sideIcons;
	
	@SideOnly(Side.CLIENT)
	private Icon disableIcon;	
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register){
		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MACHINE_TOP);
		botIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MACHINE_BOT);
		
		sideIcons = new Icon[BlockInfo.MACHINE_SIDES.length];
		
		for(int i = 0; i < sideIcons.length; i++){
			sideIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MACHINE_SIDES[i]);	
		}
		
		disableIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MACHINE_DISABLED);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta){
		if(side == 0){
			return botIcon;
		}
		else if(side == 1){
			return isDisabled(meta) ? disableIcon : topIcon;
		}
		else{
			// We could adjust based on the side if needed to have an image for all sides
			int type = meta / 2;
			return sideIcons[type];
		}
	}
	
	private boolean isDisabled(int meta){
		return meta % 2 == 1;
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity){
		if(!world.isRemote && !isDisabled(world.getBlockMetadata(x,  y,  z))){
			spawnAnvil(world, x, y + 20, z);
		}
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int id){
		if(!world.isRemote && !isDisabled(world.getBlockMetadata(x,  y,  z)) && world.isBlockIndirectlyGettingPowered(x,  y,  z)){
			// In order to make it properly, we would want to store the old state
			for(int i = -2; i <= 2; i++){
				for(int j = -2; j <= 2; j++){
					spawnAnvil(world, x + i, y + 20, z + j);
				}
			}
		}
	}
	
	
	private void spawnAnvil(World world, int x, int y, int z){
		if(world.isAirBlock(x,  y,  z)){
			world.setBlock(x,  y,  z,  Block.anvil.blockID);
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			int meta = world.getBlockMetadata(x,  y,  z);
			int type = meta / 2;
			int disabled = meta % 2 == 0 ? 1 : 0;
			int newMeta = type * 2 + disabled;
			
			// Usually use 3, for more advanced check that flag later
			world.setBlockMetadataWithNotify(x,  y,  z,  newMeta, 3);
		}
		
		return true;
	}
}
