package org.nationsatwar.superhero.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import org.nationsatwar.superhero.PerksAPI;
import org.nationsatwar.superhero.proxy.ClientProxy;

public class KeyEvents {
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		
		if (ClientProxy.debugKey.isPressed()) {
			
			PerksAPI.movementPerks.setMovementPerk(Minecraft.getMinecraft().thePlayer, 3f, 4f, 2f, 0.4f, 0.4f, 100);
		}
	}
}