package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.CameraSystem;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleCamera extends Command {
private CameraSystem cameraSystem;
	
	public ToggleCamera(){
		cameraSystem = CameraSystem.getInstance();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		cameraSystem.ToggleCamera();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
