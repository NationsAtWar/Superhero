package org.nationsatwar.superhero;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.nationsatwar.superhero.events.BreathabilityEvents;
import org.nationsatwar.superhero.events.MovementEvents;
import org.nationsatwar.superhero.events.TickEvents;
import org.nationsatwar.superhero.proxy.CommonProxy;
 
@Mod(modid = Superhero.MODID, 
	name = Superhero.MODNAME, 
	version = Superhero.MODVER)
public class Superhero {

    @Instance(Superhero.MODID)
    public static Superhero instance;

	@SidedProxy(clientSide = Superhero.CLIENT_PROXY_CLASS, serverSide = Superhero.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final String MODID = "superhero";
	public static final String MODNAME = "Superhero";
	public static final String MODVER = "0.0.1";

	public static final String CLIENT_PROXY_CLASS = "org.nationsatwar.superhero.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "org.nationsatwar.superhero.proxy.CommonProxy";
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		// Register Client Classes
		proxy.registerKeybindings();
		proxy.registerClientEvents();
		
		// Register Event Handlers
		FMLCommonHandler.instance().bus().register(new MovementEvents());
		FMLCommonHandler.instance().bus().register(new TickEvents());
		MinecraftForge.EVENT_BUS.register(new MovementEvents());
		MinecraftForge.EVENT_BUS.register(new BreathabilityEvents());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		
	}
}