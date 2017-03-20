package org.usfirst.frc.team342.robot.commands;

import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateToDegree extends Command {

	private DriveSubsystem drive;
	private double goal;
	private double goalhigh;
	private double goallow;
	private double direction;
	private double speed;

	public RotateToDegree(double degrees) {
		drive = DriveSubsystem.getInstance();
		goal = degrees;
		goalhigh = goal + 20;
		goallow = goal - 20;
		direction = 1.0;
		speed = 0.5;

		if (goalhigh > 360.0) {
			goalhigh = goalhigh - 360;
		}
		if (goallow < 0.0) {
			goallow += 360;
		}
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		double angle = drive.getGyro();
		if(angle < 0.0){
			angle += 360;
		}

		if ((angle < goalhigh) && (angle > goallow)) {
			speed = 0.2;
		}

		if ((goal > 180) && (angle < (goal - 180))) {
			angle += 360;
		}
		if ((angle - goal < 180.0) && !((angle - goal) < 0.0)) {
			direction = -1.0;
		}

		SmartDashboard.putNumber("Gyro", drive.getGyro());
		SmartDashboard.putNumber("angle", angle);
		SmartDashboard.putNumber("Speed", speed);
		SmartDashboard.putNumber("Direction", direction);
		SmartDashboard.putNumber("GoalHigh", goalhigh);
		SmartDashboard.putNumber("GoalLow", goallow);
		
		speed = speed * -1;
		drive.spinning(speed * direction);
	}

	@Override
	protected boolean isFinished() {
		return drive.isInAngleDeadzone(goal);
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
