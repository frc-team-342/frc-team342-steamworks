package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.GearSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class GearDoorDown extends Command {

	private GearSubsystem gearSystem;
	
	public GearDoorDown(){
		gearSystem = GearSubsystem.getInstance();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		gearSystem.backward();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		gearSystem.stop();
	}

	@Override
	protected void interrupted() {
		gearSystem.stop();
	}

}
