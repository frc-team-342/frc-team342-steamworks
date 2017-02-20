package org.usfirst.frc.team342.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSubsystem extends Subsystem {
	
	private static final GearSubsystem instance= new GearSubsystem ();
	private Spark DoorMotor;
	private PowerDistributionPanel PDP; 
	private double CurrentLimit = 40;
	public void forward (){
		//DoorMotor.setDirection(Direction.kForward);
		if(GearCurrent() < CurrentLimit){
			DoorMotor.set(1);
		}
	}
	
	public void backward (){
		//DoorMotor.setDirection(Direction.kReverse)
		if(GearCurrent() < CurrentLimit){
		DoorMotor.set(-1);	
		}
	}
	
	public void stop (){
		//DoorMotor.stopMotor();
		DoorMotor.set(0);
	}
	
	public GearSubsystem (){
		DoorMotor = new Spark (3);
	
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	public static GearSubsystem Getinstance (){
		return instance;
		
	}
	public double GearCurrent(){
		return PDP.getCurrent(6);
		
	}

}

