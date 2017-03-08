package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeft extends CommandGroup{
	
	private DriveSubsystem DriveL;
	private long EndTime;
	private double seconds;
	
	public AutoLeft(double seconds) {
		
		
		
	}
	

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
