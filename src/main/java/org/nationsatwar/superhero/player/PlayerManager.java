package org.nationsatwar.superhero.player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerManager {
	
	public static List<PlayerPerks> playerPerksList = new ArrayList<PlayerPerks>();
	
	/**
	 * Returns a pre-existing PlayerPerks object. If one doesn't exist, a new one is created and returned
	 */
	public static PlayerPerks getPlayerPerks(UUID playerUUID) {
		
		// If PlayerPerks already exists in list, then return it
		for (PlayerPerks playerPerks : playerPerksList)
			if (playerPerks.equals(playerUUID))
				return playerPerks;
		
		// Otherwise create a new PlayerPerks and return that
		PlayerPerks newPlayerPerks = new PlayerPerks(playerUUID);
		playerPerksList.add(newPlayerPerks);
		
		return newPlayerPerks;
	}
	
	public static void updateTicks() {
		
		for (PlayerPerks playerPerks : playerPerksList)
			playerPerks.updateDuration();
	}
}