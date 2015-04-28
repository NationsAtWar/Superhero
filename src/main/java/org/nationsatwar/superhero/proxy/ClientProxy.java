package org.nationsatwar.superhero.proxy;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.FMLCommonHandler;

import org.lwjgl.input.Keyboard;
import org.nationsatwar.palette.KeyBindings;
import org.nationsatwar.superhero.events.KeyEvents;

public class ClientProxy extends CommonProxy {

	public static KeyBinding debugKey;
	
	@Override
	public void registerKeybindings() {
		
		debugKey = KeyBindings.registerKey(Keyboard.KEY_R, "debugKey");
	}
	
	@Override
	public void registerClientEvents() {

		FMLCommonHandler.instance().bus().register(new KeyEvents());
	}
}