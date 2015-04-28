package org.nationsatwar.superhero.perks.movement;

import net.minecraft.entity.player.EntityPlayer;

import org.nationsatwar.superhero.perks.GenericHook;
import org.nationsatwar.superhero.player.PlayerManager;
import org.nationsatwar.superhero.player.PlayerPerks;

public class MovementHook extends GenericHook {
	
	/**
	 * Sets the player's new movement speed for a specified duration.
	 * Affects walk/run/sneak
	 * 
	 * @param player The player to add the perk to
	 * @param newSpeed Changes the player's movement speed (-1 = Stop, 0 = Normal Player Speed, 1 = Double Player Speed, etc)
	 * @param swimSpeed Changes the player's swim speed (0 = Normal Swim Speed)
	 * @param flySpeed Changes the player's fly speed (0.1 = Normal Fly Speed)
	 * @param duration How long the perk will last in ticks (0 is infinite) (20 ticks in a second)
	 */
	public void setMovementPerk(EntityPlayer player, float moveSpeed, float swimSpeed, float flySpeed, int duration) {
		
		// Updates the Players Movement Perk
		PlayerPerks playerPerks = PlayerManager.getPlayerPerks(player.getUniqueID());
		playerPerks.movementPerk.setMovementSpeed(moveSpeed);
		playerPerks.movementPerk.setSwimSpeed(swimSpeed);
		playerPerks.movementPerk.setFlySpeed(flySpeed);
		playerPerks.movementPerk.setDuration(duration);
	}
	
	/**
	 * Sets the player's new movement speed
	 * 
	 * @param player The player to add the perk to
	 * @param newSpeed The speed you want to set. (-1 = Stop, 0 = Normal Player Speed, 1 = Double Player Speed, etc)
	 */
	public void setMoveSpeed(EntityPlayer player, float newSpeed) {
		
		// Updates the Players Movement Perk
		PlayerPerks playerPerks = PlayerManager.getPlayerPerks(player.getUniqueID());
		playerPerks.movementPerk.setMovementSpeed(newSpeed);
	}
}