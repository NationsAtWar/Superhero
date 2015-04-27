package org.nationsatwar.superhero.events;

import java.util.UUID;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import org.nationsatwar.superhero.player.PlayerManager;
import org.nationsatwar.superhero.player.PlayerPerks;

public class UpdateEvents {
	
	public static final UUID movementSpeedID = UUID.randomUUID();
	
	private static float movementSpeed = 0;
	
	@SubscribeEvent
	public void tickEvent(PlayerTickEvent event) {
		
		if (!event.player.isSprinting())
			updateMovementSpeed(event.player);
	}
	
	@SubscribeEvent
	public void fovUpdate(FOVUpdateEvent event) {
		
		// Regulates Field of Vision changes
		event.newfov = event.fov - ((movementSpeed * 0.7425f) + 0.2425f);
	}
	
	private void updateMovementSpeed(EntityPlayer player) {
		
		PlayerPerks playerPerks = PlayerManager.getPlayerPerks(player.getUniqueID());
		IAttributeInstance attrInstance = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed);

		double perkSpeed = playerPerks.getMovementSpeed();
		movementSpeed = (float) perkSpeed;
		AttributeModifier speedModifier = attrInstance.getModifier(movementSpeedID);	
		
		if (speedModifier != null && speedModifier.getAmount() == perkSpeed)
			return;
		
		speedModifier = new AttributeModifier(movementSpeedID, "Speed Boost", perkSpeed, 2);
		
		if (attrInstance.getAttribute() != null)
			attrInstance.removeModifier(speedModifier);
		attrInstance.applyModifier(speedModifier);
	}
}