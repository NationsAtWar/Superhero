package org.nationsatwar.superhero.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import org.nationsatwar.superhero.Perks;
import org.nationsatwar.superhero.proxy.ClientProxy;

public class KeyEvents {
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		
		if (ClientProxy.debugKey.isPressed()) {
			
			Perks.setMovementSpeed(Minecraft.getMinecraft().thePlayer, 0.2f, 100);
		}
	}
}