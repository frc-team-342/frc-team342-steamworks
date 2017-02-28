package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.CamraSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class SeeWithCamera extends Command {

private CamraSubsystem camraSystem;
	
	public SeeWithCamera(){
		camraSystem = CamraSubsystem.getInstance();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		camraSystem.seeWithCamera(camraSystem.getCurrentCamera());
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
