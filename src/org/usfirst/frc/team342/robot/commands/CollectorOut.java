package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class CollectorOut extends Command {

private ShooterSubsystem shooterSystem;
	
	public CollectorOut(){
		shooterSystem = ShooterSubsystem.Getinstance();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		shooterSystem.ReverseIntake();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		shooterSystem.StopIntake();
	}

	@Override
	protected void interrupted() {
		shooterSystem.StopIntake();
	}

}
