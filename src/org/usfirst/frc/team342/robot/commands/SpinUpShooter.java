package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team342.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;


public class SpinUpShooter extends Command {

	private ShooterSubsystem shooterSystem;
	private DriveSubsystem driveSystem;
	private Joystick joy;
	private double angle;
	private double triggerAxis;
	private double magnitude;
	private double rightstick;
	private boolean shooterAtSpeed;
	
	public SpinUpShooter(){
		shooterSystem = shooterSystem.getInstance();
		shooterAtSpeed = false;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		shooterSystem.SpinUpShooters(0.0);;
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
