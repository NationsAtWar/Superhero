package org.nationsatwar.superhero;

import net.minecraft.entity.player.EntityPlayer;

import org.nationsatwar.superhero.player.PlayerManager;
import org.nationsatwar.superhero.player.PlayerPerks;

public class PerksAPI {
	
	/**
	 * Sets the player's new movement speed for a specified duration.
	 * 
	 * @param player
	 * @param newSpeed The speed you want to set. (0 = Stop, 0.1 = Normal Player Speed)
	 * @param duration How long the perk will last in ticks (0 is infinite) (20 ticks in a second)
	 */
	public static void setMovementPerk(EntityPlayer player, float newSpeed, int duration) {
		
		// Updates the Players Movement Perk
		PlayerPerks playerPerks = PlayerManager.getPlayerPerks(player.getUniqueID());
		playerPerks.movementPerk.setMovementSpeed(newSpeed);
		playerPerks.movementPerk.setDuration(duration);
	}
}