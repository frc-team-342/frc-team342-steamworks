package org.usfirst.frc.team342.robot.subsystems;

import org.usfirst.frc.team342.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem{

	private CANTalon FShooterMotor;
	private CANTalon RShooterMotor;
	
	private Talon IntakeMotor;
	private Talon ConveyerMotor;
	
	private static final ShooterSubsystem instance=new ShooterSubsystem();
	
	private ShooterSubsystem (){
		FShooterMotor = new CANTalon(RobotMap.FSHOOTERMOTOR);
		RShooterMotor = new CANTalon(RobotMap.RSHOOTERMOTOR);
		IntakeMotor = new Talon(RobotMap.INTAKEMOTOR);
		ConveyerMotor = new Talon(RobotMap.CONVEYERMOTOR);
		
		setUpShooterMotors();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	private void setUpShooterMotors(){
		
	}
	
	public void ReverseIntake(){
		IntakeMotor.set(0.8);
	}
	
	public void IntakeOn(){
		IntakeMotor.set(-0.8);
	}
	
	public void ConveyerOn(){
		ConveyerMotor.set(0.5);
	}
	
	public void SpinUpShooters(double speed){
		FShooterMotor.set(speed);
		RShooterMotor.set(speed);
	}
	
	public boolean ShootersSpeedMet(){
		if(FShooterMotor.getSpeed() == 0 && RShooterMotor.getSpeed() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void StopAll(){
		FShooterMotor.set(0.0);
		RShooterMotor.set(0.0);
		IntakeMotor.set(0.0);
		ConveyerMotor.set(0.0);
	}
	
	public void StopShooter(){
		FShooterMotor.set(0.0);
		RShooterMotor.set(0.0);
	}
	
	public void StopIntake(){
		IntakeMotor.set(0.0);
	}
	public static ShooterSubsystem getInstance (){
		return instance;
	}
	
}
