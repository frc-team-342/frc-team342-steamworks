package org.usfirst.frc.team342.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSubsystem extends Subsystem {
	
	private static final GearSubsystem instance= new GearSubsystem ();
	private Relay DoorMotor;
	
	
	public GearSubsystem (){
		DoorMotor = new Relay (3);
	
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	public static GearSubsystem Getinstance (){
		return instance;
		
	}
}

