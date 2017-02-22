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
	//^ For the hall effect, false means contact is detected ^
	
	public GearSubsystem (){
		DoorMotor = new Spark (3);
		hallEffect = new DigitalInput(9);
		PDP = new PowerDistributionPanel(16);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void forward (){
		if(getHallEffect()){
			DoorMotor.set(1.0);
		}else{
			DoorMotor.set(0.0);
		}
	}
	
	public void backward (){
		if(getHallEffect()){
			DoorMotor.set(-1.0);
		}else{
			DoorMotor.set(0.0);
		}
	}
	
	public void stop (){
		DoorMotor.set(0);
	}

	public double getCurrent(){
		return PDP.getCurrent(6);
		
	}
	
	public boolean getHallEffect(){
		return hallEffect.get();
	}
	
	public static GearSubsystem getInstance (){
		return instance;
		
	}
}

