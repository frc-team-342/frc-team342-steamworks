package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.OI;
import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team342.robot.subsystems.GearSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithJoystick extends Command {
	
	private GearSubsystem temp;
	
	private DriveSubsystem driveSystem;
	private Joystick joy;
	private double angle;
	private double magnitude;
	private double rightStick;

	public DriveWithJoystick(){
		driveSystem = DriveSubsystem.getInstance();
		joy = OI.Xbox_Controller;
		temp = GearSubsystem.getInstance();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		angle = (Math.abs(joy.getDirectionDegrees() + 360) % 360) / 360;
		magnitude = joy.getMagnitude();
		rightStick = joy.getRawAxis(4);
		if(magnitude > 0.15){
		driveSystem.DWJmanup(angle, magnitude, rightStick, false);
			SmartDashboard.putNumber("angle: ", angle);
			SmartDashboard.putNumber("magnitude: ", magnitude);
			SmartDashboard.putNumber("axis 4: ", rightStick);
			SmartDashboard.putBoolean("DIO: ", temp.getHallEffect());
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
