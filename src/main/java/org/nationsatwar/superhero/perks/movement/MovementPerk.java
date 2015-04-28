package org.nationsatwar.superhero.perks.movement;

import org.nationsatwar.superhero.perks.GenericPerk;

public class MovementPerk extends GenericPerk {
	
	private final float defaultMoveSpeed = 0;
	private final float defaultFlySpeed = 0.1f;
	private final float defaultSwimSpeed = 0;
	
	private float movementSpeed = defaultMoveSpeed;
	private float sneakSpeed = defaultMoveSpeed;
	private float runSpeed = defaultMoveSpeed;
	private float swimSpeed = defaultSwimSpeed;
	private float flySpeed = defaultFlySpeed;
	
	public MovementPerk() {}
	
	public float getMovementSpeed() {
		return movementSpeed;
	}
	
	public void setMovementSpeed(float movementSpeed) {
		this.movementSpeed = movementSpeed;
	}
	
	public float getSneakSpeed() {
		return sneakSpeed;
	}

	public void setSneakSpeed(float sneakSpeed) {
		this.sneakSpeed = sneakSpeed;
	}

	public float getRunSpeed() {
		return runSpeed;
	}

	public void setRunSpeed(float runSpeed) {
		this.runSpeed = runSpeed;
	}

	public float getSwimSpeed() {
		return swimSpeed;
	}

	public void setSwimSpeed(float swimSpeed) {
		this.swimSpeed = swimSpeed;
	}

	public float getFlySpeed() {
		return flySpeed;
	}

	public void setFlySpeed(float flySpeed) {
		this.flySpeed = flySpeed;
	}

	@Override
	protected void durationFinished() {
		
		movementSpeed = defaultMoveSpeed;
		flySpeed = defaultFlySpeed;
		swimSpeed = defaultSwimSpeed;
	}
}