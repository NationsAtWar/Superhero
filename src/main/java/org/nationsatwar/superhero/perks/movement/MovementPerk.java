package org.nationsatwar.superhero.perks.movement;

import org.nationsatwar.superhero.perks.GenericPerk;

public class MovementPerk extends GenericPerk {
	
	private final float defaultSpeed = 0;
	private final float defaultFlySpeed = 0.1f;
	
	private float walkSpeed = defaultSpeed;
	private float sneakSpeed = defaultSpeed;
	private float sprintSpeed = defaultSpeed;
	private float swimSpeed = defaultSpeed;
	private float flySpeed = defaultFlySpeed;
	
	public MovementPerk() {}
	
	public float getWalkSpeed() {
		return walkSpeed;
	}
	
	public void setWalkSpeed(float walkSpeed) {
		this.walkSpeed = walkSpeed;
	}
	
	public float getSneakSpeed() {
		return sneakSpeed;
	}

	public void setSneakSpeed(float sneakSpeed) {
		this.sneakSpeed = sneakSpeed;
	}

	public float getSprintSpeed() {
		return sprintSpeed;
	}

	public void setSprintSpeed(float sprintSpeed) {
		this.sprintSpeed = sprintSpeed;
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
		
		walkSpeed = defaultSpeed;
		sneakSpeed = defaultSpeed;
		sprintSpeed = defaultSpeed;
		swimSpeed = defaultSpeed;
		flySpeed = defaultFlySpeed;
	}
}