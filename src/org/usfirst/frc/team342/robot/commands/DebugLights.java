package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.OI;
import org.usfirst.frc.team342.robot.RobotMap;
import org.usfirst.frc.team342.robot.subsystems.LightsSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DebugLights extends Command {
private LightsSubsystem Lights;
private Joystick joystick;
public DebugLights(){
	Lights= LightsSubsystem.Getinstance();
	joystick= OI.joystick;
}
protected void execute (){
	double red = joystick.getRawAxis(0);
	double green = joystick.getRawAxis(1);
	double blue = joystick.getRawAxis(2);
	red = Math.abs(red);
	green = Math.abs(green);
	blue = Math.abs(blue);
	//Lights.setall(red, green, blue);
	Lights.setrgb(1.0, 0.0, 0.0);
}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
