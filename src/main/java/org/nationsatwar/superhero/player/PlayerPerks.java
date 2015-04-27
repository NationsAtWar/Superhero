package org.nationsatwar.superhero.player;

import java.util.UUID;

import net.minecraft.entity.SharedMonsterAttributes;

public class PlayerPerks {
	
	private UUID playerUUID;
	
	private double movementSpeed = SharedMonsterAttributes.movementSpeed.getDefaultValue();
	
	public PlayerPerks(UUID playerUUID) {
		
		this.playerUUID = playerUUID;
	}
	
	public boolean equals(UUID playerUUID) {
		
		if (this.playerUUID == playerUUID)
			return true;
		else
			return false;
	}
	
	public double getMovementSpeed() {
		return movementSpeed;
	}
	
	public void setMovementSpeed(double movementSpeed) {
		this.movementSpeed = movementSpeed;
	}
}