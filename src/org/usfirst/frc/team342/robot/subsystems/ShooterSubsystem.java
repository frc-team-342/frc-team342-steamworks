package org.usfirst.frc.team342.robot.subsystems;

import org.usfirst.frc.team342.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterSubsystem extends Subsystem {

	private CANTalon FShooterMotor;
	private CANTalon RShooterMotor;

	private Talon IntakeMotor;
	private Talon ConveyerMotor;

	private static final ShooterSubsystem instance = new ShooterSubsystem();

	private ShooterSubsystem() {
		FShooterMotor = new CANTalon(RobotMap.FSHOOTERMOTOR);
		RShooterMotor = new CANTalon(RobotMap.RSHOOTERMOTOR);
		IntakeMotor = new Talon(RobotMap.INTAKEMOTOR);
		ConveyerMotor = new Talon(RobotMap.CONVEYERMOTOR);

		SmartDashboard.putNumber("ForwardSpeed", 2000);
		SmartDashboard.putNumber("BackwardSpeed", 3000);

		setDriveParameters();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	private void setUpShooterMotors() {

	}

	public void ReverseIntake() {
		IntakeMotor.set(0.5);
	}

	public void IntakeOn() {
		IntakeMotor.set(-0.5);
	}

	public void ConveyerOn() {
		ConveyerMotor.set(0.5);
	}

	public void SpinUpShooters(double speed) {
		// FShooterMotor.set(speed * 1750.0);
		// RShooterMotor.set(speed * 2950.0);

		FShooterMotor.set(speed * SmartDashboard.getNumber("ForwardSpeed", 2000));
		RShooterMotor.set(speed * SmartDashboard.getNumber("BackwardSpeed", 3000));

	}

	public boolean ShootersSpeedMet() {
		if (FShooterMotor.getSpeed() == 0 && RShooterMotor.getSpeed() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void setDriveParameters() {
		FShooterMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		FShooterMotor.changeControlMode(TalonControlMode.Speed);
		FShooterMotor.set(0);
		FShooterMotor.setP(0.01);
		FShooterMotor.setI(0);
		FShooterMotor.setD(0);
		FShooterMotor.setF(0.037);
		FShooterMotor.setAllowableClosedLoopErr(100);
		FShooterMotor.enableBrakeMode(false);

		RShooterMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		RShooterMotor.changeControlMode(TalonControlMode.Speed);
		RShooterMotor.set(0);
		RShooterMotor.setP(0.01);
		RShooterMotor.setI(0);
		RShooterMotor.setD(0);
		RShooterMotor.setF(0.037);
		RShooterMotor.setAllowableClosedLoopErr(100);
		RShooterMotor.enableBrakeMode(false);

	}

	public void StopAll() {
		FShooterMotor.set(0.0);
		RShooterMotor.set(0.0);
		IntakeMotor.set(0.0);
		ConveyerMotor.set(0.0);
	}

	public void ConveyerStop() {
		ConveyerMotor.set(0.0);
	}

	public void StopShooter() {
		FShooterMotor.set(0.0);
		RShooterMotor.set(0.0);
	}

	public void StopIntake() {
		IntakeMotor.set(0.0);
	}

	public static ShooterSubsystem getInstance() {
		return instance;
	}

}
