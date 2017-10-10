package org.usfirst.frc.team342.robot.subsystems;

import org.usfirst.frc.team342.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends Subsystem {

	private static final DriveSubsystem instance = new DriveSubsystem();

	private static final double KP = 0.7;

	private CANTalon FRDrive;
	private CANTalon RRDrive;
	private CANTalon RLDrive;
	private CANTalon FLDrive;

	private CANTalon FRTurn;
	private CANTalon BRTurn;
	private CANTalon BLTurn;
	private CANTalon FLTurn;

	private AHRS NavX;

	private boolean GyroFront;

	public DriveSubsystem() {
		initializeDriveSystem();
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void initializeDriveSystem() {
		// RF = right front, RR = right rear, LR = left rear, LF = left front
		FRDrive = new CANTalon(RobotMap.RFDRIVEMOTOR);
		FRTurn = new CANTalon(RobotMap.RFSTEERMOTOR);
		RRDrive = new CANTalon(RobotMap.RRDRIVEMOTOR);
		BRTurn = new CANTalon(RobotMap.RRSTEERMOTOR);
		RLDrive = new CANTalon(RobotMap.LRDRIVEMOTOR);
		BLTurn = new CANTalon(RobotMap.LRSTEERMOTOR);
		FLDrive = new CANTalon(RobotMap.LFDRIVEMOTOR);
		FLTurn = new CANTalon(RobotMap.LFSTEERMOTOR);

		setUpRotationMotors();

		SmartDashboard.putString("Front", "Gear");

		GyroFront = true;

		NavX = new AHRS(SPI.Port.kMXP);
		NavX.startLiveWindowMode();
		NavX.reset();

	}

	public void setUpRotationMotors() {

		FRTurn.disable();
		FRTurn.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		FRTurn.changeControlMode(TalonControlMode.Position);
		FRTurn.setP(1.0);
		FRTurn.reverseSensor(true);
		FRTurn.reverseOutput(true);
		// Burnie Value: 222 Fenrir(pratice) value: 501
		resetEncoder(FRTurn, 222);
		FRTurn.enable();
		FRTurn.setAllowableClosedLoopErr(10);

		BRTurn.disable();
		BRTurn.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		BRTurn.changeControlMode(TalonControlMode.Position);
		BRTurn.setP(1.0);
		BRTurn.reverseSensor(true);
		BRTurn.reverseOutput(true);
		// Burnie Value: 1076 Fenrir(pratice) value: 113
		resetEncoder(BRTurn, 3965);
		BRTurn.enable();
		BRTurn.setAllowableClosedLoopErr(10);

		BLTurn.disable();
		BLTurn.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		BLTurn.changeControlMode(TalonControlMode.Position);
		BLTurn.setP(1.0);
		BLTurn.reverseOutput(true);
		BLTurn.reverseSensor(true);
		// Burnie Value: 333 Fenrir(pratice) value: 2195
		resetEncoder(BLTurn, 333);
		BLTurn.enable();
		BLTurn.setAllowableClosedLoopErr(10);

		FLTurn.disable();
		FLTurn.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		FLTurn.changeControlMode(TalonControlMode.Position);
		FLTurn.setP(1.0);
		FLTurn.reverseSensor(true);
		FLTurn.reverseOutput(true);
		// Burnie Value: 1389 Fenrir(pratice) value: 396
		resetEncoder(FLTurn, 1389);
		FLTurn.enable();
		FLTurn.setAllowableClosedLoopErr(10);
	}

	public void DWJmanupKeepHeading(double angle, double speed, double rotation, boolean FelO) {
		double navAngle = ((NavX.getAngle()) % 360);
		double newAngle;
		
		newAngle = (angle - navAngle) + 1;
		
		SmartDashboard.putNumber("newAngle", newAngle);
		DWJmanup(newAngle, speed, rotation, FelO);

	}

	public void DWJmanup(double angle, double speed, double rotation, boolean FelO) {
		// FeLO = field orientation

		//SmartDashboard.putNumber("AngelRaw: ", angle);
		
		if (GyroFront) {
			angle += 0.75;
		} else {
			angle += 0.25;
		}

		if (angle > 1) {
			angle = -1 + angle;
		}

		double tempX, tempY;
		double FRX, BRX, BLX, FLX, FRY, BRY, BLY, FLY;
		double FRang, BRang, BLang, FLang;
		double FRpow, BRpow, BLpow, FLpow;

		double FRoffset = 0.375;
		double BRoffset = 0.625;
		double BLoffset = 0.875;
		double FLoffset = 0.125;

		// From the NavX
		double GyRo = (NavX.getAngle() % 360.0) / 360.0;
		if (GyRo < 0) {
			GyRo = 1.0 + GyRo;

		}
		//SmartDashboard.putString("GyRovalue", "" + GyRo);
		if (FelO) {
			angle = angle - GyRo;
			angle = angle % 1.0;
		}
		// angle = 1.0 - angle;
		
		//SmartDashboard.putString("AngleValue", "" + angle);
		// setting individual wheels angle * speed was here
		rotation = rotation * speed * -0.4;
		tempX = Math.cos(angle * (2 * Math.PI)) * speed;
		tempY = Math.sin(angle * (2 * Math.PI)) * speed;

		FRX = Math.cos(FRoffset * (Math.PI * 2)) * rotation;
		FRY = Math.sin(FRoffset * (Math.PI * 2)) * rotation;

		BRX = Math.cos(BRoffset * (Math.PI * 2)) * rotation;
		BRY = Math.sin(BRoffset * (Math.PI * 2)) * rotation;

		BLX = Math.cos(BLoffset * (Math.PI * 2)) * rotation;
		BLY = Math.sin(BLoffset * (Math.PI * 2)) * rotation;

		FLX = Math.cos(FLoffset * (Math.PI * 2)) * rotation;
		FLY = Math.sin(FLoffset * (Math.PI * 2)) * rotation;

		FRang = calcAngle((FRY + tempY), (FRX + tempX) * -1) / 360.0;
		BRang = calcAngle((BRY + tempY), (BRX + tempX) * -1) / 360.0;
		BLang = calcAngle((BLY + tempY), (BLX + tempX) * -1) / 360.0;
		FLang = calcAngle((FLY + tempY), (FLX + tempX) * -1) / 360.0;

		FRpow = Math.sqrt(Math.pow(FRX + tempX, 2) + Math.pow(FRY + tempY, 2)) * -1;
		BRpow = Math.sqrt(Math.pow(BRX + tempX, 2) + Math.pow(BRY + tempY, 2)) * -1;
		BLpow = Math.sqrt(Math.pow(BLX + tempX, 2) + Math.pow(BLY + tempY, 2)) * -1;
		FLpow = Math.sqrt(Math.pow(FLX + tempX, 2) + Math.pow(FLY + tempY, 2)) * -1;

		setAngle(FRang, FRTurn);
		setAngle(BRang, BRTurn);
		setAngle(BLang, BLTurn);
		setAngle(FLang, FLTurn);

		//SmartDashboard.putNumber("X: ", FRX + tempX);
		//SmartDashboard.putNumber("Y: ", (-1.0 * (FRY + tempY)));

		//SmartDashboard.putNumber("tempX", tempX);
		//SmartDashboard.putNumber("tempY", tempY);

		//SmartDashboard.putNumber("FRX", FRX);
		//SmartDashboard.putNumber("FRY", FRY);

		//SmartDashboard.putNumber("BRX", BRX);
		//SmartDashboard.putNumber("BRY", BRY);

		//SmartDashboard.putNumber("BLX", BLX);
		//SmartDashboard.putNumber("BLY", BLY);
		
		//SmartDashboard.putNumber("FLX", FLX);
		//SmartDashboard.putNumber("FLY", FLY);

		//SmartDashboard.putNumber("FRang: ", FRang);
		//SmartDashboard.putNumber("BRang: ", BRang);
		//SmartDashboard.putNumber("BLang: ", BLang);
		//SmartDashboard.putNumber("FLang: ", FLang);

		FRDrive.set(FRpow);
		RRDrive.set(BRpow);
		RLDrive.set(BLpow);
		FLDrive.set(FLpow);

		//SmartDashboard.putNumber("FRPOW: ", FRpow);
		//SmartDashboard.putNumber("BRPOW: ", BRpow);
		//SmartDashboard.putNumber("BLPOW: ", BLpow);
		//SmartDashboard.putNumber("FLPOW: ", FLpow);
	}

	public void changeFront() {
		if (GyroFront) {
			GyroFront = false;
			SmartDashboard.putString("Front", "Rope");
		} else {
			GyroFront = true;
			SmartDashboard.putString("Front", "Gear");
		}
	}

	public void setAngle(double angle, CANTalon talon) {
		double actual = talon.getPosition();

		if (actual > 0) {
			angle = angle + Math.floor(actual);
		} else {
			angle = angle - 1;
			angle = angle + Math.ceil(actual);
		}
		if (Math.abs(actual - angle) > 0.5) {
			if (angle > actual) {
				angle -= 1;
			} else {
				angle += 1;
			}
		}

		talon.set(angle);
	}

	public void spinning(double speed) {
		setAngle(0.625 + .375, FRTurn);// testing offset .1055
		setAngle(0.375 + .375 , FLTurn);
		setAngle(0.875 + .375, BRTurn);
		setAngle(0.125 + .375, BLTurn);
		// ^^^ NEEDS TO BE CHANGED FOR COMPETITION
		speed = speed * -1;
		// for rotation
		FRDrive.set(speed);
		RRDrive.set(speed);
		RLDrive.set(speed);
		FLDrive.set(speed);
	}

	public void resetGyro() {
		NavX.reset();
	}

	public void angleAdjust(int number, double speed) {
		CANTalon Talon = null;
		if (number == 1) {
			Talon = FRTurn;
		}
		if (number == 2) {
			Talon = BRTurn;
		}
		if (number == 3) {
			Talon = BLTurn;
		}
		if (number == 4) {
			Talon = FLTurn;
		}
		if (Talon != null && Talon.getControlMode() == CANTalon.TalonControlMode.Voltage) {
			// Talon.setControlMode(CANTalon.TalonControlMode.Voltage.value);
			Talon.set(speed);
		}
	}

	public void resetEncoder(CANTalon talon, int offset) {
		int holdnum = talon.getPulseWidthPosition();
		if (holdnum > 0) {
			talon.setEncPosition((holdnum % 4096) + offset);
		} else {
			holdnum = holdnum * -1;
			holdnum = holdnum % 4096;
			holdnum = 4096 - holdnum;
			talon.setEncPosition(holdnum + offset);
		}

	}
	
	public double getGyro(){
		return Math.abs(NavX.getAngle() % 360);
	}
	
	public double calcAngle(double x, double y) {
		double angle = 0.0;

		angle = Math.atan(y / x);
		angle = (angle * 180) / Math.PI;

		if (Math.abs(x) > 0.001) {
			if (x > 0.0) {
				angle += 90.0;
			} else {
				angle += 270.0;
			}
		} else {
			if (y < 0.0) {
				angle = 0.0;
			} else {
				angle = 180.0;
			}
		}

		return angle;
	}

	public void stopTurn() {
		if (FRTurn.getControlMode() == CANTalon.TalonControlMode.Position
				&& FRTurn.getControlMode() == FLTurn.getControlMode()
				&& FRTurn.getControlMode() == BRTurn.getControlMode()
				&& FRTurn.getControlMode() == BLTurn.getControlMode()) {
			// position mode
			FRTurn.set(FRTurn.getPosition());
			FLTurn.set(FLTurn.getPosition());
			BRTurn.set(FRTurn.getPosition());
			BLTurn.set(BLTurn.getPosition());
		} else {
			// not position mode
			FRTurn.set(0.0);
			BRTurn.set(0.0);
			FLTurn.set(0.0);
			BLTurn.set(0.0);
		}
	}

	public void stopDrive() {
		if (FRDrive.getControlMode() == CANTalon.TalonControlMode.Position
				&& FRDrive.getControlMode() == RRDrive.getControlMode()
				&& FRDrive.getControlMode() == FLDrive.getControlMode()
				&& FRDrive.getControlMode() == RLDrive.getControlMode()) {
			// position mode
			FRDrive.set(FRDrive.getPosition());
			FLDrive.set(FLDrive.getPosition());
			RRDrive.set(RRDrive.getPosition());
			RLDrive.set(RLDrive.getPosition());
		} else {
			// not position mode
			FRDrive.set(0.0);
			FLDrive.set(0.0);
			RRDrive.set(0.0);
			RLDrive.set(0.0);
		}
	}

	public void stopAll() {
		stopDrive();
		stopTurn();
	}

	public void outputInfo() {
		SmartDashboard.putNumber("Gyro:", NavX.getAngle());

		SmartDashboard.putNumber("FRencPos:", FRTurn.getPosition());
		SmartDashboard.putNumber("BRencPos:", BRTurn.getPosition());
		SmartDashboard.putNumber("BLencPos:", BLTurn.getPosition());
		SmartDashboard.putNumber("FLencPos:", FLTurn.getPosition());
	}
	
	public boolean isInAngleDeadzone(double goal){
		double currentAngle = getGyro();
		double goalHigh = goal + 20.0;
		double goalLow = goal - 20.0;
		double highmodifier = 0.0;
		double lowmodifier = 0.0;
		boolean indeadzone;
		
		if(currentAngle < 0){
			currentAngle += 360;
		}
		if(goalHigh > 360){
			goalHigh -= 360;
			goalLow -= 360;
			highmodifier = 0.0;
			lowmodifier = 360.0;
		}
		if(goalLow < 0){
			goalLow += 360;
			goalHigh += 360;
			highmodifier = 360.0;
			lowmodifier = 0.0;
		}
		
		SmartDashboard.putNumber("curang", currentAngle);
		SmartDashboard.putNumber("angGoalHigh", goalHigh);
		SmartDashboard.putNumber("angGoalLow", goalLow);
		
		if(((currentAngle + lowmodifier) >= goalLow) && ((currentAngle + highmodifier) <= goalHigh)){
			indeadzone = true;
		}else{
			indeadzone = false;
		}
		
		return indeadzone;
	}
	
	public static DriveSubsystem getInstance() {
		return instance;
	}

	public void DebugInfo() {

	}
}