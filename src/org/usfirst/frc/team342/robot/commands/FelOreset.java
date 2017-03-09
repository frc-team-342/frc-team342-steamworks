package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class FelOreset extends Command {

	private DriveSubsystem Drive;
	
	public FelOreset() {
		Drive = DriveSubsystem.getInstance();
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		Drive.resetGyro();
		return true;
	}
	
	
	
}
