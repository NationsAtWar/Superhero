package org.nationsatwar.superhero.perks;

public class GenericPerk {
	
	protected int duration;
	
	public void tickDownDuration() {
		
		if (duration > 0)
			duration--;
		
		else if (duration == 0) {
			
			durationFinished();
			duration = -1;
		}
	}
	
	public void setDuration(int duration) {
		
		if (duration <= 0)
			duration = -1;
		
		this.duration = duration;
	}
	
	protected void durationFinished() {}
}