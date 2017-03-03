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
	
	private CANTalon FRDrive;
	private CANTalon RRDrive;
	private CANTalon RLDrive;
	private CANTalon FLDrive;
		
	private CANTalon FRTurn;
	private CANTalon RRTurn;
	private CANTalon RLTurn;
	private CANTalon FLTurn;
	
	private AHRS NavX;
	
	public DriveSubsystem(){
		initializeDriveSystem();
	}
	
	@Override
	protected void initDefaultCommand(){
	}
	
	public void initializeDriveSystem(){
		//RF = right front, RR = right rear, LR = left rear, LF = left front
		FRDrive = new CANTalon(RobotMap.RFDRIVEMOTOR);
		FRTurn = new CANTalon(RobotMap.RFSTEERMOTOR);
		RRDrive = new CANTalon(RobotMap.RRDRIVEMOTOR);
		RRTurn = new CANTalon(RobotMap.RRSTEERMOTOR);
		RLDrive = new CANTalon(RobotMap.LRDRIVEMOTOR);
		RLTurn = new CANTalon(RobotMap.LRSTEERMOTOR);
		FLDrive = new CANTalon(RobotMap.LFDRIVEMOTOR);
		FLTurn = new CANTalon(RobotMap.LFSTEERMOTOR);
		
		setUpRotationMotors();
		
		NavX = new AHRS(SPI.Port.kMXP);
		NavX.startLiveWindowMode();
		
	}
	public void setUpRotationMotors(){
		
		FRTurn.disable();
		FRTurn.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		FRTurn.changeControlMode(TalonControlMode.Position);
		FRTurn.setP(1.0);
		FRTurn.reverseSensor(true);
		FRTurn.reverseOutput(true);
		resetEncoder(FRTurn, 0);
		FRTurn.enable();
		
		RRTurn.disable();
		RRTurn.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		RRTurn.changeControlMode(TalonControlMode.Position);
		RRTurn.setP(1.0);
		RRTurn.reverseSensor(true);
		RRTurn.reverseOutput(true);
		resetEncoder(FRTurn, 0);
		RRTurn.enable();
		
		RLTurn.disable();
		RLTurn.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		RLTurn.changeControlMode(TalonControlMode.Position);
		RLTurn.setP(1.0);
		RLTurn.reverseOutput(true);
		RLTurn.reverseSensor(true);
		resetEncoder(FRTurn, 0);
		RLTurn.enable();
		
		FLTurn.disable();
		FLTurn.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		FLTurn.changeControlMode(TalonControlMode.Position);
		FLTurn.setP(1.0);
		FLTurn.reverseSensor(true);
		FLTurn.reverseOutput(true);
		resetEncoder(FRTurn, 0);
		FLTurn.enable();
		
	}
	
	public void DWJmanup(double angle, double speed, double rotation, boolean FelO) {
		// FeLO = field orientation
		
		SmartDashboard.putNumber("AngelRaw: ", angle);
		
		angle += 0.25;
		if(angle > 1){
			angle = -1 + angle;
		}
		
		double tempX, tempY;
		double FRX, BRX, BLX, FLX, FRY, BRY, BLY, FLY;
		double FRang, BRang, BLang, FLang;
		double FRpow, BRpow, BLpow, FLpow;
		
		double FRoffset = 0.125;
		double BRoffset	= 0.375;
		double BLoffset = 0.625;
		double FLoffset = 0.875;
		
		// From the NavX
		double GyRo = NavX.getAngle();

		// setting individual wheels angle	* speed was here
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
		
		FRpow = Math.sqrt(Math.pow(FRX + tempX, 2) + Math.pow(FRY + tempY, 2));
		BRpow = Math.sqrt(Math.pow(BRX + tempX, 2) + Math.pow(BRY + tempY, 2));
		BLpow = Math.sqrt(Math.pow(BLX + tempX, 2) + Math.pow(BLY + tempY, 2));
		FLpow = Math.sqrt(Math.pow(FLX + tempX, 2) + Math.pow(FLY + tempY, 2));
		
		setAngle(FRang, FRTurn);
		setAngle(BRang, RRTurn);
		setAngle(BLang, RLTurn);
		setAngle(FLang, FLTurn);
		
		SmartDashboard.putNumber("X: ", FRX + tempX);
		SmartDashboard.putNumber("Y: ", (-1.0 * (FRY + tempY)));
		
		SmartDashboard.putNumber("tempX", tempX);
		SmartDashboard.putNumber("tempY", tempY);
		
		SmartDashboard.putNumber("FRX", FRX);
		SmartDashboard.putNumber("FRY", FRY);
		
		SmartDashboard.putNumber("BRX", BRX);
		SmartDashboard.putNumber("BRY", BRY);
		
		SmartDashboard.putNumber("BLX", BLX);
		SmartDashboard.putNumber("BLY", BLY);
		
		SmartDashboard.putNumber("FLX", FLX);
		SmartDashboard.putNumber("FLY", FLY);
		
		SmartDashboard.putNumber("FRang: ", FRang);
		SmartDashboard.putNumber("BRang: ", BRang);
		SmartDashboard.putNumber("BLang: ", BLang);
		SmartDashboard.putNumber("FLang: ", FLang);
		
		FRDrive.set(FRpow);
		RRDrive.set(BRpow);
		RLDrive.set(BLpow);
		FLDrive.set(FLpow);
		
		SmartDashboard.putNumber("FRPOW: ", FRpow);
		SmartDashboard.putNumber("BRPOW: ", BRpow);
		SmartDashboard.putNumber("BLPOW: ", BLpow);
		SmartDashboard.putNumber("FLPOW: ", FLpow);
	}
	
	public void setAngle(double angle, CANTalon talon){
		double actual = talon.getPosition();
		
		if(actual > 0){
			angle = angle + Math.floor(actual);
		}else{
			angle = angle - 1;
			angle = angle + Math.ceil(actual);
		}
		if(Math.abs(actual - angle) > 0.5){
			if(angle > actual){
				angle -= 1;
			}else{
				angle += 1;
			}
		}

		talon.set(angle);
	}
	
	public void spinning(double speed) {
		setAngle(0.375, FRTurn);
		setAngle(0.125, FLTurn);
		setAngle(0.625, RRTurn);
		setAngle(0.875, RLTurn);

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
			Talon = RRTurn;
		}
		if (number == 3) {
			Talon = RLTurn;
		}
		if (number == 4) {
			Talon = FLTurn;
		}
		if (Talon != null && Talon.getControlMode() == CANTalon.TalonControlMode.Voltage) {
			// Talon.setControlMode(CANTalon.TalonControlMode.Voltage.value);
			Talon.set(speed);
		}
	}
	
	public void resetEncoder(CANTalon talon, int offset){
		int holdnum = talon.getPulseWidthPosition();
			if (holdnum > 0){
			talon.setEncPosition((holdnum % 4096)+ offset);
		}
			else{
			holdnum = holdnum * -1;	
			holdnum = holdnum % 4096;
			holdnum = 4096 - holdnum;
			talon.setEncPosition(holdnum + offset);
			}
	
	}
	
	public double calcAngle(double x, double y){
		double angle = 0.0;
		
		angle = Math.atan(y / x);
		angle = (angle * 180) / Math.PI;
		
		if(Math.abs(x) > 0.001){
			if(x > 0.0){
				angle += 90.0;
			}else{
				angle += 270.0;
			}
		}else{
			if(y < 0.0){
				angle = 0.0;
			}else{
				angle = 180.0;
			}
		}
		
		return angle;
	}
	
	public void stopTurn() {
		if (FRTurn.getControlMode() == CANTalon.TalonControlMode.Position
				&& FRTurn.getControlMode() == FLTurn.getControlMode()
				&& FRTurn.getControlMode() == RRTurn.getControlMode()
				&& FRTurn.getControlMode() == RLTurn.getControlMode()) {
			// position mode
				FRTurn.set(FRTurn.getPosition());
				FLTurn.set(FLTurn.getPosition());
				RRTurn.set(FRTurn.getPosition());
				RLTurn.set(RLTurn.getPosition());
		} else {
			// not position mode
				FRTurn.set(0.0);
				RRTurn.set(0.0);
				FLTurn.set(0.0);
				RLTurn.set(0.0);
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
	
	public void stopAll(){
		stopDrive();
		stopTurn();
	}
	
	public void outputInfo(){
		SmartDashboard.putNumber("Gyro:", NavX.getAngle());
		
		SmartDashboard.putNumber("FRencPos:", FRTurn.getPosition());
		SmartDashboard.putNumber("BRencPos:", RRTurn.getPosition());
		SmartDashboard.putNumber("BLencPos:", RLTurn.getPosition());
		SmartDashboard.putNumber("FLencPos:", FLTurn.getPosition());
	}
	
	public static DriveSubsystem getInstance() {
		return instance;
	}
	
	public void DebugInfo(){
		
	}
	
}