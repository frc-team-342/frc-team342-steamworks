package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class SpinUpShooter extends Command {

	private ShooterSubsystem shooterSystem;
	private boolean shooterAtSpeed;
	
	public SpinUpShooter(){
		shooterSystem = shooterSystem.Getinstance();
		shooterAtSpeed = false;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		shooterSystem.SpinUpShooters();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
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
