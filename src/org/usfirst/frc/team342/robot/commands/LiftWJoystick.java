package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.OI;
import org.usfirst.frc.team342.robot.subsystems.ClimbSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class LiftWJoystick extends Command {

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	private ClimbSubsystem climb;
	private double speed;
	private Joystick joystick;
	
	public LiftWJoystick(){
		climb = ClimbSubsystem.getInstance();
		speed = 1.0;
		joystick = OI.Log_Controller;
		
		
	}
	
	protected void execute() {
		speed = joystick.getRawAxis(1);
			if(speed > 0.9) {
				speed = 1.0;
			}
			if(speed < -0.9) {
				speed = -1.0;
			}
		climb.Climb(speed);
	
	}
	
	protected void end() {
		climb.Stop();
	}

	@Override
	protected void interrupted() {
		climb.Stop();
	}
	
	}



