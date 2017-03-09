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
	public static final int XBOXPORT = 0;
	//public static final int MANIPULATORPORT = 1;
	public static final int LOGPORT = 1;
	//shooter subsystem

	public static final int FSHOOTERMOTOR = 9;
	public static final int RSHOOTERMOTOR = 10;
	 
	//lights subsystem
	public static final int LightsBlue = 9;
	public static final int LightsGreen = 7;
	public static final int LightsRed = 8;
	public static final int LightsCamera1 = 4;
	public static final int LightsCamera2 = 5;
	public static final int LightsSpot = 6;
	
	//camera subsystem
	public static final int Servo1 = 4;
	public static final int Servo2 = 5;
	
	//PWMs
	public static final int INTAKEMOTOR = 0;
	public static final int CONVEYERMOTOR = 1;
	public static final int CLIMBMOTOR = 2;
	public static final int GEARDOOR = 3;
	public static final int RINGLIGHT1 = 4;
	public static final int RINGLIGHT2 = 5;
	public static final int TARGETINGLIGHT = 6;
	public static final int GREENLED = 7;
	public static final int REDLED = 8;
	public static final int BLUELED = 9;
	
	//talons
	public static final int RFDRIVEMOTOR = 1;
	public static final int RRDRIVEMOTOR = 2;
	public static final int LRDRIVEMOTOR = 3;
	public static final int LFDRIVEMOTOR = 4;
	
	public static final int RFSTEERMOTOR = 5;
	public static final int RRSTEERMOTOR = 6;
	public static final int LRSTEERMOTOR = 7;
	public static final int LFSTEERMOTOR = 8;
	
	//PDP
	public static final int POWERRRDRIVE = 0;
	public static final int POWERRSHOOTER = 1;
	public static final int POWERFSHOOTER = 2;
	public static final int POWERRFDRIVE = 3;
	public static final int POWERRRSTEER = 4;
	public static final int POWERLEDCONTROL = 5;
	public static final int POWERSPARK = 6;
	public static final int POWERRFSTEER = 7;
	public static final int POWERLFSTEER = 8;
	public static final int POWERINTAKE = 9;
	public static final int USELESSPRICK = 10;
	public static final int POWERLRSTEER = 11;
	public static final int POWERLFDRIVE = 12;
	public static final int POWERCLIMB = 13;
	public static final int POWERCONVEYER = 14;
	public static final int POWERLRDRIVE = 15;
	public static final int PDPADDR = 16;
	
	//DigitalInputs
	public static final int HALLEFFECT = 9;
	
	//AnalogInputs
	public static final int SHOOTERULTRASONIC = 0;
	public static final int GEARULTRASONIC = 1;
}

