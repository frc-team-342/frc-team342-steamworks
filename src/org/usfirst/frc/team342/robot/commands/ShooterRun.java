package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.OI;
import org.usfirst.frc.team342.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterRun extends Command{

	private ShooterSubsystem Shooter;
	
	public ShooterRun() {
	Shooter = ShooterSubsystem.getInstance();
	
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void execute() {
		Shooter.SpinUpShooters(-OI.Xbox_Controller.getRawAxis(3));
		SmartDashboard.putString("ShooterSpeed", OI.Xbox_Controller.getRawAxis(3) + "");
	}
	
	
	

}
