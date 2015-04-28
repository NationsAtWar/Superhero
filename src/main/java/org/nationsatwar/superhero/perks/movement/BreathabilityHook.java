package org.nationsatwar.superhero.perks.movement;

import net.minecraft.entity.player.EntityPlayer;

import org.nationsatwar.superhero.perks.GenericHook;
import org.nationsatwar.superhero.player.PlayerManager;
import org.nationsatwar.superhero.player.PlayerPerks;

public class BreathabilityHook extends GenericHook {
	
	/**
	 * Sets the player's new breath length for a specified duration.
	 * 
	 * @param player The player to add the perk to
	 * @param breathLength Sets how long the player can breathe underwater in ticks (Normal = 300)
	 */
	public void setBreathabilityPerk(EntityPlayer player, float breathLength, int duration) {
		
		// Updates the Players Movement Perk
		PlayerPerks playerPerks = PlayerManager.getPlayerPerks(player.getUniqueID());
		playerPerks.breathabilityPerk.setBreathLength(breathLength);
		playerPerks.breathabilityPerk.setDuration(duration);
	}
}