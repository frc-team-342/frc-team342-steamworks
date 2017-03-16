package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeft extends CommandGroup{
	
	private DriveSubsystem DriveL;
	private long EndTime;
	private double Seconds;
	
	public AutoLeft(double seconds) {
		Seconds = seconds;
		DriveL = DriveSubsystem.getInstance();
	}
	

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
 
	protected void execute(){
	}
	
	protected void end() {
		end();
	}
	
	protected void Interupted() {
		
	}
	
	protected void intialize() {
		
	}
	
}
