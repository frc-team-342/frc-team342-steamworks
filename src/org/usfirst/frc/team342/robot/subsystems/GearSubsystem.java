package org.usfirst.frc.team342.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSubsystem extends Subsystem {
	
	private static final GearSubsystem instance= new GearSubsystem ();
	private Spark DoorMotor;
	private PowerDistributionPanel PDP; 
	private double CurrentLimit = 40;
	private DigitalInput hallEffect;
	
	public GearSubsystem (){
		DoorMotor = new Spark (3);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void forward (){
		DoorMotor.set(1);
	}
	
	public void backward (){
		DoorMotor.set(-1);	
	}
	
	public void stop (){
		DoorMotor.set(0);
	}

	public double GearCurrent(){
	//	return PDP.getCurrent(6);
		return 0.0;
		
	}
	
	public static GearSubsystem getInstance (){
		return instance;
		
	}
}

