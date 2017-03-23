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
		drive.DWJmanup(0.0, 0.2, 0.0, true);
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
