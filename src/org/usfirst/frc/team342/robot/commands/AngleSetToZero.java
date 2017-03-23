package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class AngleSetToZero extends Command {

	private DriveSubsystem drive;
	
	public AngleSetToZero(){
		drive = DriveSubsystem.getInstance();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		drive.ResetAngle();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void end() {
		drive.stopAll();
	}

	@Override
	protected void interrupted() {
		
	}

}
