package org.nationsatwar.superhero.proxy;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;
import org.nationsatwar.palette.KeyBindings;

public class ClientProxy extends CommonProxy {

	public static KeyBinding debugKey;
	
	@Override
	public void registerKeybindings() {
		
		debugKey = KeyBindings.registerKey(Keyboard.KEY_R, "debugKey");
	}
}