package org.usfirst.frc.team342.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//controls
	public static final int JOYSTICK=0;
	
	//shooter subsystem
	public static final int FShooterMotor=9;
	public static final int RShooterMotor=10;
	
	//climb subsystem
	public static final int ClimberMotor=0;
	
	//lights subsystem
	public static final int LightsBlue=1;
	public static final int LightsGreen=2;
	public static final int LightsRed=3;
	public static final int LightsCamera1=4;
	public static final int LightsCamera2=5;
	public static final int LightsSpot=6;
	
	//camera subsystem
	public static final int Servo1=4;
	public static final int Servo2=5;
}
