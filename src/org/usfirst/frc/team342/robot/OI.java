package org.usfirst.frc.team342.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team342.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// \/ Make all of the buttons where it's only function is to reverse, to if you press it twice, \/
	// \/ The button will automatically reverse it.													\/

	// A_Button = collector start
	// B_Button = stop all Shooter actions
	// X_Button = Lower gear door
	// Y_Button = Raise gear door
	// Right_Trigger = start shooter, then later on conveyer/elevator
	// Right_Bumper = reverse collector 
	// Left_Bumper = Climb
	// Left_Stick = DebugInfo
	
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
	
	private Command CollectorIn;
	private Command CollectorOut;
	private Command SpinUpShooter;
	private Command StopShooter;
	private Command GearDoorDown;
	private Command GearDoorUp;
	private Command LiftStart;
	private Command ReverseLift;
	private Command DebugInfo;
	
	public OI (){
		//Instantiating all the Joysticks.
		Xbox_Controller = new Joystick(RobotMap.XBOXPORT);
		Manipulator_Controller = new Joystick(RobotMap.MANIPULATORPORT);
		
		//Instantiating all the buttons on each respectable Joystick.
		//XBOX (Main Controller)
		Xbox_A_Button = new JoystickButton(Xbox_Controller, A_BUTTON);
		Xbox_B_Button = new JoystickButton(Xbox_Controller, B_BUTTON);
		Xbox_X_Button = new JoystickButton(Xbox_Controller, X_BUTTON);
		Xbox_Y_Button = new JoystickButton(Xbox_Controller, Y_BUTTON);
		Xbox_Left_Bumper = new JoystickButton(Xbox_Controller, LEFT_BUMPER);
		Xbox_Right_Bumper = new JoystickButton(Xbox_Controller, RIGHT_BUMPER);
		Xbox_Back = new JoystickButton(Xbox_Controller, BACK);
		Xbox_Start = new JoystickButton(Xbox_Controller, START);
		Xbox_Left_Stick_Button = new JoystickButton(Xbox_Controller, LEFT_STICK_BUTTON);
		Xbox_Right_Stick_Button = new JoystickButton(Xbox_Controller, RIGHT_STICK_BUTTON);
		
		//Manipulator Controller (Secondary Controller)
		A_Button = new JoystickButton(Manipulator_Controller, A_BUTTON);
		B_Button = new JoystickButton(Manipulator_Controller, B_BUTTON);
		X_Button = new JoystickButton(Manipulator_Controller, X_BUTTON);
		Y_Button = new JoystickButton(Manipulator_Controller, Y_BUTTON);
		Left_Bumper = new JoystickButton(Manipulator_Controller, LEFT_BUMPER);
		Right_Bumper = new JoystickButton(Manipulator_Controller, RIGHT_BUMPER);
		Back = new JoystickButton(Manipulator_Controller, BACK);
		Start = new JoystickButton(Manipulator_Controller, START);
		Left_Stick_Button = new JoystickButton(Manipulator_Controller, LEFT_STICK_BUTTON);
		Right_Stick_Button = new JoystickButton(Manipulator_Controller, RIGHT_STICK_BUTTON);
		
		//Instantiating all the Commands used with buttons.
		CollectorIn = new CollectorIn();
		CollectorOut = new CollectorOut();
		SpinUpShooter = new SpinUpShooter();
		StopShooter = new StopShooter();
		GearDoorDown = new GearDoorDown();
		GearDoorUp = new GearDoorUp();
		LiftStart = new LiftStart();
		DebugInfo = new DebugInfo();
		
		//Setting the buttons to their individual commands
		A_Button.whileHeld(CollectorIn);
		B_Button.whenPressed(StopShooter);
		X_Button.whenPressed(GearDoorDown);
		Y_Button.whenPressed(GearDoorUp);
		Left_Bumper.whileHeld(LiftStart);
		Right_Bumper.whileHeld(CollectorOut);
		Left_Stick_Button.whileHeld(DebugInfo);
		
		Xbox_A_Button.whileHeld(CollectorIn);
		Xbox_B_Button.whenPressed(StopShooter);
		Xbox_X_Button.whenPressed(GearDoorDown);
		Xbox_Y_Button.whenPressed(GearDoorUp);
		Xbox_Left_Bumper.whenPressed(LiftStart);
		Xbox_Right_Bumper.whileHeld(CollectorOut);
		Xbox_Left_Stick_Button.whileHeld(DebugInfo);
		
	}
	
}
