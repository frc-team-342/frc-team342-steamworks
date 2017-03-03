package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.OI;
import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithJoystick extends Command {
	
	private DriveSubsystem driveSystem;
	private Joystick joy;
	private double angle;
	private double magnitude;
	private double rightStick;

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
		rightStick = joy.getRawAxis(4) * -1;
		
		SmartDashboard.putBoolean("button5: ", joy.getRawButton(5));
		
		if(magnitude > 0.15){
			if(joy.getRawButton(5) == true){
				driveSystem.DWJmanup(angle, magnitude / 4.0, rightStick, false);
			}else{
				driveSystem.DWJmanup(angle, magnitude, rightStick, false);
			}
		}else if(magnitude < 0.15 && Math.abs(rightStick) > 0.15){
			if(joy.getRawButton(5) == true){
				driveSystem.spinning(rightStick / 4.0);
			}else{
				driveSystem.spinning(rightStick);
			}
		}else{
			driveSystem.stopDrive();
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