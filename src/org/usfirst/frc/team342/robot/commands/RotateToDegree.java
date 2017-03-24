package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateToDegree extends Command {

	private DriveSubsystem drive;
	private double goal;
	private double goalhigh;
	private double goallow;
	private boolean direction;
	private double speed;
	private double highmodifier;
	private double lowmodifier;

	public RotateToDegree(double degrees) {
		drive = DriveSubsystem.getInstance();
		goal = degrees;
		goalhigh = goal + 20;
		goallow = goal - 20;
		direction = true;
		speed = 0.5;

		if (goalhigh > 360.0) {
			goalhigh -= 360;
			goallow -= 360;
			highmodifier = 0.0;
			lowmodifier = 360.0;
		}
		if (goallow < 0.0) {
			goallow += 360;
			goalhigh += 360;
			highmodifier = 360.0;
			lowmodifier = 0.0;
		}
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		double angle = drive.getGyro();
		
		if (((angle + highmodifier) < goalhigh) && ((angle + lowmodifier) > goallow)) {
			speed = 0.2;
		}

		if ((goal > 180) && (angle < (goal - 180))) {
			angle += 360;
		}
		
		//if (((angle - goal) < 180.0) && !((angle - goal) < 0.0)) {
			//direction = false;
		//}
		

		//if (!direction) {
			//speed = speed * -1;
		//}
		
		//SmartDashboard.putNumber("angle", angle);
		//SmartDashboard.putNumber("speed", speed);
		

		drive.spinning(speed);
	}

	@Override
	protected boolean isFinished() {
		return drive.isInAngleDeadzone(goal);
	}

	@Override
	protected void end() {
		drive.stopAll();
		speed = 0.5;
	}

	@Override
	protected void interrupted() {
		drive.stopAll();
	}

}
