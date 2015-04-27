package org.nationsatwar.superhero;

import net.minecraft.entity.player.EntityPlayer;

import org.nationsatwar.superhero.player.PlayerManager;
import org.nationsatwar.superhero.player.PlayerPerks;

public class Perks {
	
	/**
	 * Sets the player's new movement speed for a specified duration.
	 * 
	 * @param player
	 * @param newSpeed The speed you want to set. (0 = Stop, 0.1 = Normal Player Speed)
	 * @param duration
	 */
	public static void setMovementSpeed(EntityPlayer player, float newSpeed, float duration) {
		
		// Updates the Players Perks
		PlayerPerks playerPerks = PlayerManager.getPlayerPerks(player.getUniqueID());
		playerPerks.setMovementSpeed(newSpeed);
	}
}