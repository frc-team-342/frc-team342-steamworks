package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.GearSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GearDoorUp extends Command {
	
	private GearSubsystem gearSystem;
	
	public GearDoorUp(){
		gearSystem = GearSubsystem.getInstance();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		gearSystem.forward();
		//SmartDashboard.putNumber("Current: ", gearSystem.getCurrent());
	}
	
	@Override
	protected boolean isFinished() {
		return false;
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
