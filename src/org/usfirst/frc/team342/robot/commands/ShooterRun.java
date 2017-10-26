package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.OI;
import org.usfirst.frc.team342.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterRun extends Command{

	private ShooterSubsystem Shooter;
	private double speed;
	private boolean control;
	
	public ShooterRun() {
		Shooter = ShooterSubsystem.getInstance();
		control = false;
		speed = 0.0;
	}
	
	public ShooterRun(double speedinpt){
		Shooter = ShooterSubsystem.getInstance();
		control = true;
		speed = speedinpt;
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void execute() {
		if(!control){
			Shooter.SpinUpShooters(-OI.Xbox_Controller.getRawAxis(3));
		}else{
			Shooter.SpinUpShooters(speed);
		}
	}
	
	
	

}
