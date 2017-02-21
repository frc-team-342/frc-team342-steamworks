package org.usfirst.frc.team342.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team342.robot.subsystems.*;

public class DebugInfo extends Command {

	private CamraSystem camera;
	private ClimbSubsystem climb;
	private DriveSubsystem drive;
	private GearSubsystem gearSystem;
	private LightsSubsystem lights;
	private ShooterSubsystem shooter;
	
	public DebugInfo(){
		camera = CamraSystem.getInstance();
		climb = ClimbSubsystem.getInstance();
		drive = DriveSubsystem.getInstance();
		gearSystem = GearSubsystem.getInstance();
		//lights = LightsSubsystem.getInstance();
		shooter = ShooterSubsystem.getInstance();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
