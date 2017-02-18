package org.usfirst.frc.team342.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// LeftBumper = climb
	// A_Button = collector start
	// Right_Trigger = start shooter, then later on conveyer/elevator
	// X_Button = Lower gear door
	// Y_Button = Raise gear door
	
	
	
	private static final int A_BUTTON = 1;
	private static final int B_BUTTON = 2;
	private static final int X_BUTTON = 3;
	private static final int Y_BUTTON = 4;
	private static final int LEFT_BUMPER = 5;
	private static final int RIGHT_BUMPER = 6;
	private static final int BACK = 7;
	private static final int START = 8;
	private static final int LEFT_STICK_BUTTON = 9;
	private static final int RIGHT_STICK_BUTTON = 10;
	
	private static Button A_Button;
	private static Button B_Button;
	private static Button X_Button;
	private static Button Y_Button;
	private static Button Left_Bumper;
	private static Button Right_Bumper;
	private static Button Back;
	private static Button Start;
	private static Button Left_Stick_Button;
	private static Button Right_Stick_Button;
	
	private static Button Xbox_A_Button;
	private static Button Xbox_B_Button;
	private static Button Xbox_X_Button;
	private static Button Xbox_Y_Button;
	private static Button Xbox_Left_Bumper;
	private static Button Xbox_Right_Bumper;
	private static Button Xbox_Back;
	private static Button Xbox_Start;
	private static Button Xbox_Left_Stick_Button;
	private static Button Xbox_Right_Stick_Button;
	
	public static Joystick Xbox_Controller;
	public static Joystick Manipulator_Controller;
	
	public OI (){
		Xbox_Controller = new Joystick(RobotMap.XBOXPORT);
		Manipulator_Controller = new Joystick(RobotMap.MANIPULATORPORT);
		
		
	}
	
}
