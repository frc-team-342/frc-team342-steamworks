package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.OI;
import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithJoystick extends Command {

	private DriveSubsystem driveSystem;
	private OI oi;
	private Joystick joy;
	private final double DEADZONE = 0.15;
	private double angle;
	private double magnitude;
	private double rightStick;

	public DriveWithJoystick() {
		oi = OI.getInstance();
		driveSystem = DriveSubsystem.getInstance();
		
		if(!oi.Joystick) {
			joy = OI.Xbox_Controller;
		}else {
			joy = OI.Log_3d_Controller;
		}
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		angle = (Math.abs(joy.getDirectionDegrees() + 360) % 360) / 360;
		magnitude = joy.getMagnitude();
		
		
		if(magnitude >= 1){
			magnitude = 1;
		}
		
		if(!oi.Joystick) {
			rightStick = joy.getRawAxis(4);
		}else {
			rightStick = joy.getRawAxis(2);
		}
		
		SmartDashboard.putNumber("Gyro", driveSystem.getGyro());
		
		//\/ is this even still used?\/
		if(!oi.Joystick) {
			if(joy.getRawButton(3)){
				driveSystem.changeFront();
			}
		}else {
			if(joy.getRawButton(8)) {
				driveSystem.changeFront();
			}
		}
		
		
			//What does button 1 do in this situation? is it even known by the drivers or used at all?
		if(!oi.Joystick) {
			if (magnitude > DEADZONE) {
				if(joy.getRawButton(1)){
					if (joy.getRawButton(5) == true) {
						driveSystem.DWJmanupKeepHeading(0.0, magnitude / 4.0, rightStick, false);
					} else {
						driveSystem.DWJmanupKeepHeading(0.0, magnitude, rightStick, false);
					}
				}else{
					if (joy.getRawButton(5) == true) {
						driveSystem.DWJmanup(angle, magnitude / 4.0, rightStick, true);
					} else {
						driveSystem.DWJmanup(angle, magnitude, rightStick, true);
					}
				}
			}else if (magnitude < DEADZONE && Math.abs(rightStick) > DEADZONE) {
				if (joy.getRawButton(5) == true) {
					driveSystem.spinning(rightStick / 4.0);
				} else {
					driveSystem.spinning(rightStick);
				}
			}else {
				driveSystem.stopDrive();
			}
		}else{
			if (magnitude > DEADZONE) {
				if(joy.getRawButton(9)){
					if (joy.getRawButton(7) == true) {
						driveSystem.DWJmanupKeepHeading(0.0, magnitude / 4.0, rightStick, false);
					} else {
						driveSystem.DWJmanupKeepHeading(0.0, magnitude, rightStick, false);
					}
				}else{
					if (joy.getRawButton(7) == true) {
						driveSystem.DWJmanup(angle, magnitude / 4.0, rightStick, true);
					} else {
						driveSystem.DWJmanup(angle, magnitude, rightStick, true);
					}
				}
			}else if (magnitude < DEADZONE && Math.abs(rightStick) > DEADZONE) {
				if (joy.getRawButton(7) == true) {
					driveSystem.spinning(rightStick / 4.0);
				} else {
					driveSystem.spinning(rightStick);
				}
			}else {
				driveSystem.stopDrive();
			}
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