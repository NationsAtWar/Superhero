package org.nationsatwar.superhero.events;

import java.util.UUID;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import org.nationsatwar.superhero.player.PlayerManager;
import org.nationsatwar.superhero.player.PlayerPerks;

public class MovementEvents {
	
	public static final UUID movementSpeedID = UUID.randomUUID();
	
	@SubscribeEvent
	public void tickEvent(PlayerTickEvent event) {
		
		updateMovementSpeed(event.player);

		PlayerManager.updateTicks();
	}
	
	@SubscribeEvent
	public void fovUpdate(FOVUpdateEvent event) {
		
		updateMovementSpeed(event.entity);
		event.newfov = updateFoV(event.entity);
	}
	
	private void updateMovementSpeed(EntityPlayer player) {
		
		PlayerPerks playerPerks = PlayerManager.getPlayerPerks(player.getUniqueID());
		IAttributeInstance attrInstance = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed);

		float newSpeed = 1.0f;
		
		if (player.capabilities.isFlying) {
			
			newSpeed = playerPerks.movementPerk.getFlySpeed();
			player.capabilities.setFlySpeed(newSpeed);
			return;
		}
		else if (player.isInWater()) {
			
			newSpeed = playerPerks.movementPerk.getSwimSpeed();
			player.moveFlying(player.moveStrafing * newSpeed, player.moveForward * newSpeed, 0.1f);
			return;
		}
		else
			newSpeed = playerPerks.movementPerk.getMovementSpeed();
		
		AttributeModifier speedModifier = attrInstance.getModifier(movementSpeedID);
		
		if (speedModifier != null && speedModifier.getAmount() == newSpeed)
			return;
		
		speedModifier = new AttributeModifier(movementSpeedID, "Speed Boost", newSpeed, 2);
		
		if (attrInstance.getAttribute() != null)
			attrInstance.removeModifier(speedModifier);
		attrInstance.applyModifier(speedModifier);
	}
	
	/**
	 * This method is a bit of an oddity. For some reason you can't grab a player's FoV without it 
	 * triggering Forge's FoV Update event, therefore creating a pointless recursive loop. So instead I
	 * simply copied the code for it here and changed the tiny bit that needed changing.
	 * 
	 * This method will do the trick, but once Forge fixes this issue, it'll be nice to clean this code up.
	 */
	private float updateFoV(EntityPlayer entity) {
		
		float f = 1.0f;
		
		PlayerPerks playerPerks = PlayerManager.getPlayerPerks(entity.getUniqueID());
		float movementSpeed = playerPerks.movementPerk.getMovementSpeed();
		
		IAttributeInstance iattributeinstance = entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
		float sprintOffset = (float) iattributeinstance.getAttributeValue();
		
		sprintOffset -= (movementSpeed / 11);
		
		
		f = (float) (f * ((sprintOffset / entity.capabilities.getWalkSpeed() + 1.0D) / 2.0D));
		
		if (entity.capabilities.getWalkSpeed() == 0.0F || Float.isNaN(f) || 
				entity.capabilities.isFlying || entity.isInWater() || Float.isInfinite(f))
			f = 1.0F;
		
		if (entity.isUsingItem() && entity.getItemInUse().getItem() == Items.bow) {
			
			int i = entity.getItemInUseDuration();
			float f1 = (float) i / 20.0F;
			
			if (f1 > 1.0F)
				f1 = 1.0F;
			else
				f1 *= f1;
			
			f *= 1.0F - f1 * 0.15F;
		}
		
		return f;
	}
}