package example;

import network.PacketHandler;
import proxies.CommonProxy;
import config.ConfigHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/*
 * Pahimar does this slightly different
 */
@Mod(modid = ModInformation.ID, name= ModInformation.NAME, version=ModInformation.VERSION)
@NetworkMod(channels={ModInformation.CHANNEL}, clientSideRequired=true, serverSideRequired=false, packetHandler = PacketHandler.class)
public class StevesExample {
    
    @Instance(ModInformation.ID)
    public static StevesExample instance;

    /*
     * Variable Declaration and Item Creation
     */    
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="proxies.ClientProxy", serverSide="proxies.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        /*
         * PreInit is before turning on
         */ 
        /*
         * Register Sounds / Blocks / Config 
         */
        // Grab the suggested config file from the event
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        
        // Quick way to access variable
        System.out.println(ConfigHandler.SOME_TEXT_VALUE);
        
        proxy.initSounds();
        proxy.registerRenderers();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
        /*
         * Init is when turning on
         */
        
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        /*
         * PostInit is after all of the mods have been loaded
         * 
         * Good to interact with other mods
         */
    }    
    
}