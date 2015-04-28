package org.nationsatwar.superhero.perks;

public class MovementPerk extends GenericPerk {
	
	private final double defaultSpeed = 0;
	
	private double movementSpeed = defaultSpeed;
	
	public MovementPerk() {}
	
	public double getMovementSpeed() {
		return movementSpeed;
	}
	
	public void setMovementSpeed(double movementSpeed) {
		this.movementSpeed = movementSpeed;
	}
	
	@Override
	protected void durationFinished() {
		
		movementSpeed = defaultSpeed;
		System.out.println(movementSpeed);
	}
}