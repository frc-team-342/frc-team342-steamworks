package org.usfirst.frc.team342.robot.subsystems;

import org.usfirst.frc.team342.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSubsystem extends Subsystem {
	
	private static final GearSubsystem instance = new GearSubsystem();
	private Spark DoorMotor;
	
	
	public GearSubsystem (){
		DoorMotor = new Spark(RobotMap.GEARDOOR);
	}
	
	public void forward (){
		
	}
	
	public void backward (){
		
	}
	
	public void stop (){
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public static GearSubsystem Getinstance (){
		return instance;
		
	}
}

