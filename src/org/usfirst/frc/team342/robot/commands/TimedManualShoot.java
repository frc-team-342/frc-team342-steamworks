package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.ShooterSubsystem;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TimedManualShoot extends Command {
	 
	private double FrontSpeed;
	private double BackSpeed;
	private double Delay = 3.0;
	private double Endtime;
	
	private ShooterSubsystem shooter;
	
	public TimedManualShoot(double FSpeed, double BSpeed, double seconds){
		shooter = ShooterSubsystem.getInstance();
		Delay = seconds;
		FrontSpeed = FSpeed;
		BackSpeed = BSpeed;
		
		
	}
	
	protected void initialize(){
		Endtime = System.currentTimeMillis() + (Delay * 1000);
		
		SmartDashboard.putString("TS", "It's Working!");
	}

	protected void execute(){
		
		shooter.ManualShoot(FrontSpeed, BackSpeed);
		shooter.ConveyerOn();
		
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (System.currentTimeMillis() > Endtime);
	}

	protected void end(){
		
		shooter.StopShooter();
		shooter.ConveyerStop();
	}
	
	protected void interuppted(){
		
		end();
		
	}
	
}
