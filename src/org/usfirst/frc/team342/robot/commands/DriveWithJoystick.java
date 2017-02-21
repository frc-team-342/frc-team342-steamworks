package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.OI;
import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command {

	private DriveSubsystem driveSystem;
	private Joystick joy;
	private double angle;
	private double magnitude;

	public DriveWithJoystick(){
		driveSystem = DriveSubsystem.getInstance();
		joy = OI.Xbox_Controller;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		angle = (Math.abs(joy.getDirectionDegrees() + 360) % 360) / 360;
		magnitude = joy.getMagnitude();
		if(magnitude > 0.15){
		driveSystem.DWJmanup(angle, joy.getMagnitude(), joy.getRawAxis(4), false);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		driveSystem.stopAll();
	}

	@Override
	protected void interrupted() {
		driveSystem.stopAll();
	}

}
