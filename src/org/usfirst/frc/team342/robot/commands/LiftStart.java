package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.ClimbSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftStart extends Command {
	
	private ClimbSubsystem climb;
	
	private double speed;
	
	public LiftStart(){
		climb = ClimbSubsystem.getInstance();
		speed = 1.0;
	}

	@Override
	protected void initialize() {
		climb.changeDirection();
	}

	@Override
	protected void execute() {
		climb.Climb(speed);
		SmartDashboard.putBoolean("Direction: ", climb.direction);
		SmartDashboard.putNumber("counter: ", climb.speed);
	}

	@Override
	protected boolean isFinished() {
		return false;
		
	}

	@Override
	protected void end() {
		climb.Stop();
	}

	@Override
	protected void interrupted() {
		climb.Stop();
	}

}
