package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveFoward extends Command {
		
	private DriveSubsystem Drive;
	private long EndTime;
	private double Seconds;
	
	public DriveFoward(double seconds) {
		Seconds = seconds;
		Drive = DriveSubsystem.getInstance();
		//EndTime = (System.currentTimeMillis() + (seconds * 1000));
		//SmartDashboard.putString("AutoStatus","StartTime " + System.currentTimeMillis() + "EndTime " + EndTime);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (System.currentTimeMillis() > EndTime);
	}
	
	protected void execute() {
		
		Drive.DWJmanup(0, 0.5, 0.0, true);
		
	}
	protected void end(){
		Drive.DWJmanup(0.0, 0.0, 0.0, true );
	}
	protected void interupted() {
		end();
	}
	protected void initialize() {
		int MillisTime = (int) (Seconds * 1000.0);
		EndTime = (System.currentTimeMillis() + MillisTime);
		SmartDashboard.putString("AutoStatus","StartTime " + System.currentTimeMillis() + "EndTime " + EndTime);
	}
}
