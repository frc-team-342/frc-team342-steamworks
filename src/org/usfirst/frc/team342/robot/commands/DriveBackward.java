package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBackward extends Command {
	
	private DriveSubsystem Drive;
	private long Endtime;
	private double Seconds;
	
	public DriveBackward(double seconds) {
		Seconds = seconds;
		Drive = DriveSubsystem.getInstance();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		
		return (System.currentTimeMillis() > Endtime);
		
	}
	
	protected void execute(){
		Drive.DWJmanup(0.5, 0.5, 0.0, true);
		//SmartDashboard.putString("AutoStatus","StartTime " + System.currentTimeMillis() + "Endtime " + Endtime);
		
	}
	
	protected void end(){
		Drive.DWJmanup(0, 0, 0, true);
	}
	
	protected void interupted() {
		end();
	}
	
	protected void initialize(){
		int MillisTime = (int) (Seconds * 1000.0);
		Endtime = (System.currentTimeMillis() + MillisTime);
		SmartDashboard.putString("AutoStatus","StartTime " + System.currentTimeMillis() + "Endtime " + Endtime);
		
	}
	
}
