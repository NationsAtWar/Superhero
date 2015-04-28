package org.nationsatwar.superhero.events;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.nationsatwar.superhero.player.PlayerManager;
import org.nationsatwar.superhero.player.PlayerPerks;

public class BreathabilityEvents {
	
	public static final UUID movementSpeedID = UUID.randomUUID();

	@SubscribeEvent
	public void tickEvent(LivingUpdateEvent event) {
		
		if (!(event.entity instanceof EntityPlayer))
			return;
		
		EntityPlayer player = (EntityPlayer) event.entity;
		
		PlayerManager.updateTicks();
		
		if (!player.isInWater())
			return;
		
		PlayerPerks playerPerks = PlayerManager.getPlayerPerks(player.getUniqueID());
		float breathCounter = playerPerks.breathabilityPerk.getBreathCounter();
		
		// Allows the suffocation event to trigger
		if (player.getAir() < -20) {
			
			player.setAir(-19);
			return;
		}
		
		if (player.getAir() > 300)
			player.setAir(300);
		
		while (breathCounter > 1) {

			player.setAir(player.getAir() + 1);
			breathCounter -= 1f;
		}
		
		while (breathCounter < -1f) {
			
			player.setAir(player.getAir() - 1);
			breathCounter += 1;
		}

		playerPerks.breathabilityPerk.setBreathCounter(breathCounter);
	}
}