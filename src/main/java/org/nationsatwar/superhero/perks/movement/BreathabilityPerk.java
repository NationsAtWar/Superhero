package org.nationsatwar.superhero.perks.movement;

import org.nationsatwar.superhero.perks.GenericPerk;

public class BreathabilityPerk extends GenericPerk {
	
	private final float defaultBreathLength = 300;
	
	private  float breathModifier = 0;
	private  float breathCounter = 0;
	
	private float breathLength = defaultBreathLength;
	
	public BreathabilityPerk() {}

	public float getBreathLength() {
		return breathLength;
	}
	
	public void setBreathLength(float breathLength) {
		
		this.breathLength = breathLength;
		
		if (breathLength == 0) {
			
			breathModifier = 1;
			return;
		}
		
		if (breathLength >= defaultBreathLength)
			breathModifier = 1 - (defaultBreathLength / breathLength / 2);
		else
			breathModifier = 0 - (defaultBreathLength / breathLength / 2);
	}
	
	public float getBreathCounter() {
		return breathCounter;
	}
	
	public void setBreathCounter(float breathCounter) {
		this.breathCounter = breathCounter;
	}

	@Override
	protected void onTick() {
		
		breathCounter += breathModifier;
	}

	@Override
	protected void durationFinished() {
		
		breathLength = defaultBreathLength;
	}
}