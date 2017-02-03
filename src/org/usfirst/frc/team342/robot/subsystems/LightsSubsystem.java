package org.usfirst.frc.team342.robot.subsystems;

import org.usfirst.frc.team342.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LightsSubsystem extends Subsystem {
	private Servo red;
	private Servo green;
	private Servo blue;
	private static final LightsSubsystem instance= new LightsSubsystem ();
	private LightsSubsystem (){
		red= new Servo (RobotMap.LightsRed);
		green= new Servo (RobotMap.LightsGreen);
		blue= new Servo (RobotMap.LightsBlue);
		
	
	}
	public static LightsSubsystem Getinstance (){
		return instance;
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	
		
	}
public void setall (double redn, double greenn, double bluen){
	red.setRaw((int)(redn*255));
	green.setRaw((int)(greenn*255));
	blue.setRaw((int)(bluen*255));
	SmartDashboard.putDouble("red", redn);
}
public void setred (double redn){
	red.set(redn);
}
public void setgreen (double greenn){
	green.set(greenn);
}
public void setblue (double bluen){
	blue.set(bluen);
}
public void setoff (){
	red.set(0);
	green.set(0);
	blue.set(0);
}

}
