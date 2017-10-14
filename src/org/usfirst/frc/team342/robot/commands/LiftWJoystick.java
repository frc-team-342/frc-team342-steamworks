package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.OI;
import org.usfirst.frc.team342.robot.subsystems.ClimbSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftWJoystick extends Command {

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	private ClimbSubsystem climb;
	private double speed;
	private double direction;
	private final double DEADZONE = 0.15;
	private final double HIGH_DEADZONE = 0.90;
	private double magnitude;
	private Joystick joystick;
	private Joystick xbox;
	
	public LiftWJoystick(){
		climb = ClimbSubsystem.getInstance();
		speed = 1.0;
		joystick = OI.Log_Controller;
		xbox = OI.Xbox_Controller;
		
	}
	
	protected void execute() {
		magnitude = Math.abs(joystick.getRawAxis(1));
		
		if(joystick.getRawAxis(1) >= 0){
			direction = 1.0;
		}else{
			direction = -1.0;
		}
		
		if(magnitude > DEADZONE){
			if(magnitude > HIGH_DEADZONE){
				speed = 1.0;
			}else{
				speed = magnitude;
			}
		}else{
			speed = 0.0;
		}
		
		SmartDashboard.putNumber("SPEED:", speed);
		climb.Climb(speed * direction);
		
		if(xbox.getPOV(0) != -1){
			climb.Climb(1.0);
		}else if(xbox.getPOV(4) != -1){
			climb.Climb(-1.0);
		}
	
	}
	
	protected void end() {
		climb.Stop();
	}

	@Override
	protected void interrupted() {
		climb.Stop();
	}
	
	}



