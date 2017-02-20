package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.ClimbSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class LiftStart extends Command {
	
	private ClimbSubsystem climb;
	private boolean finished;
	
	private double speed;
	
	public LiftStart(){
		climb = ClimbSubsystem.getInstance();
		finished = false;
		speed = 1.0;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		climb.Climb(speed);
		
		if(climb.getCurrent() > 35.0){
			finished = true;
		}else{
			finished = false;
		}
		
	}

	@Override
	protected boolean isFinished() {
		return finished;
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
