package org.nationsatwar.superhero.player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.nationsatwar.superhero.perks.GenericPerk;
import org.nationsatwar.superhero.perks.movement.MovementPerk;

public class PlayerPerks {
	
	private UUID playerUUID;
	
	private List<GenericPerk> perkList = new ArrayList<GenericPerk>();
	
	public MovementPerk movementPerk = new MovementPerk();
	
	public PlayerPerks(UUID playerUUID) {
		
		this.playerUUID = playerUUID;
		
		perkList.add(movementPerk);
	}
	
	public boolean equals(UUID playerUUID) {
		
		if (this.playerUUID == playerUUID)
			return true;
		else
			return false;
	}
	
	public void updateDuration() {
		
		for (GenericPerk perk : perkList)
			perk.tickDownDuration();
	}
}