package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class StopShooter extends Command {

	private ShooterSubsystem shooterSystem;
	
	public StopShooter(){
		shooterSystem = shooterSystem.Getinstance();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		shooterSystem.StopAll();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void end() {
		shooterSystem.StopAll();
	}

	@Override
	protected void interrupted() {
		shooterSystem.StopAll();
	}

}
