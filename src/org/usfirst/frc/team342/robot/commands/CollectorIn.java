package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class CollectorIn extends Command {

	private ShooterSubsystem shooterSystem;
	
	public CollectorIn(){
		shooterSystem = ShooterSubsystem.Getinstance();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		shooterSystem.IntakeOn();
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
