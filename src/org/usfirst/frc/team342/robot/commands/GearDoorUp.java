package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.GearSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GearDoorUp extends Command {
	
	private GearSubsystem gearSystem;
	private boolean finished;
	
	public GearDoorUp(){
		gearSystem = GearSubsystem.getInstance();
		finished = false;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		gearSystem.forward();
		if(!gearSystem.getHallEffect()){
			finished = true;
		}else{
			finished = false;
		}
	}
	
	@Override
	protected boolean isFinished() {
		return finished;
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
