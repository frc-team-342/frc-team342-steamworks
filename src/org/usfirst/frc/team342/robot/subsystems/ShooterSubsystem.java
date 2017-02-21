package org.usfirst.frc.team342.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem{

	CANTalon FShooterMotor;
	CANTalon RShooterMotor;
	private static final ShooterSubsystem instance=new ShooterSubsystem();
	private ShooterSubsystem (){
		
	}
	public static ShooterSubsystem Getinstance (){
		return instance;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
t
}
