package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.ClimbSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbWithButton extends Command {

	private ClimbSubsystem climbSubsystem;
	
	private double speed;
	
	public ClimbWithButton(double inptspeed){
		climbSubsystem = ClimbSubsystem.getInstance();
		speed = inptspeed;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		climbSubsystem.Climb(speed);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		climbSubsystem.Stop();
	}

	@Override
	protected void interrupted() {
		climbSubsystem.Stop();
	}

}