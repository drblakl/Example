package example;

import network.PacketHandler;
import proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "StevesExample", name= "Steve's Example", version="Lecture 1")
@NetworkMod(channels={"example"}, clientSideRequired=true, serverSideRequired=false, packetHandler = PacketHandler.class)
public class StevesExample {
    
    @Instance("StevesExample")
    public static StevesExample instance;
    

    /*
     * Variable Declaration and Item Creation
     */    
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="proxies.ClientProxy", serverSide="proxies.CommonProxy")
    public static CommonProxy proxy;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event){
        /*
         * PreInit is before turning on
         */ 
        /*
         * Register Sounds / Blocks / Config 
         */
    }
    
    @Init
    public void init(FMLInitializationEvent event){
        proxy.initSounds();
        proxy.registerRenderers();
        /*
         * Init is when turning on
         */
        
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event){
        /*
         * PostInit is after all of the mods have been loaded
         * 
         * Good to interact with other mods
         */
    }    
    
}