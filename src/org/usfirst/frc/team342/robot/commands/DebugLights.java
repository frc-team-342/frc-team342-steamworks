package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.LightsSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

	public class DebugLights extends Command {
	private LightsSubsystem Lights;
	private Joystick joystick;

	public DebugLights(){
	
	}
	
	protected void execute (){
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
