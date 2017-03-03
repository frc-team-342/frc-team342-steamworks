package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.GearSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GearDoorDown extends Command {

	private GearSubsystem gearSystem;
	private double delay = 1.2;
	private double EndTime;
	private boolean isclosed;
	
	public GearDoorDown(){
		gearSystem = GearSubsystem.getInstance();
	}
	
	@Override
	protected void initialize() {
		EndTime = System.currentTimeMillis() + (delay * 1000);
		isclosed = ! gearSystem.getHallEffect();
		SmartDashboard.putString("GC", "gear goes down");
	}

	@Override
	protected void execute() {
		gearSystem.forward();//<----- this one
		//SmartDashboard.putNumber("Current: ", gearSystem.getCurrent());
	}
	
	@Override
	protected boolean isFinished() {
		return (System.currentTimeMillis() > EndTime) || ! isclosed;
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
