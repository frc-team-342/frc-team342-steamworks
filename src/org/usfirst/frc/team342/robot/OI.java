package org.usfirst.frc.team342.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team342.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private static final OI INSTANCE = new OI();
	
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
	
	private static final int LOG_A_BUTTON = 1;
	private static final int LOG_B_BUTTON = 2;
	private static final int LOG_X_BUTTON = 3;
	private static final int LOG_Y_BUTTON = 4;
	private static final int LOG_LEFT_BUMPER = 5;
	private static final int LOG_RIGHT_BUMPER = 6;
	private static final int LOG_BACK = 7;
	private static final int LOG_START = 8;
	private static final int LOG_LS_BUTTON = 9;
	private static final int LOG_RS_BUTTON = 10;
	
	private static final int LOG_3D_BUTTON_ONE = 1;
	private static final int LOG_3D_BUTTON_TWO = 2;
	private static final int LOG_3D_BUTTON_THREE = 3;
	private static final int LOG_3D_BUTTON_FOUR = 4;
	private static final int LOG_3D_BUTTON_FIVE = 5;
	private static final int LOG_3D_BUTTON_SIX = 6;
	private static final int LOG_3D_BUTTON_SEVEN = 7;
	private static final int LOG_3D_BUTTON_EIGHT = 8;
	private static final int LOG_3D_BUTTON_NINE = 9;
	private static final int LOG_3D_BUTTON_TEN = 10;
	private static final int LOG_3D_BUTTON_ELEVEN = 11;
	private static final int LOG_3D_BUTTON_TWELVE = 12;
	
	// Xbox controls
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
	
	// Logitech(XBOX) controls
	private static Button Log_A_Button;
	private static Button Log_B_Button;
	private static Button Log_X_Button;
	private static Button Log_Y_Button;
	private static Button Log_Left_Bumper;
	private static Button Log_Right_Bumper;
	private static Button Log_Back;
	private static Button Log_Start;
	private static Button Log_Left_Stick_Button;
	private static Button Log_Right_Stick_Button;
	
	// Logitech(3D Joy) controls
	private static Button Log_3d_Button_One;
	private static Button Log_3d_Button_Two;
	private static Button Log_3d_Button_Three;
	private static Button Log_3d_Button_Four;
	private static Button Log_3d_Button_Five;
	private static Button Log_3d_Button_Six;
	private static Button Log_3d_Button_Seven;
	private static Button Log_3d_Button_Eight;
	private static Button Log_3d_Button_Nine;
	private static Button Log_3d_Button_Ten;
	private static Button Log_3d_Button_Eleven;
	private static Button Log_3d_Button_Twelve;
	
	public static Joystick Xbox_Controller;
	public static Joystick Log_Controller;
	public static Joystick Log_3d_Controller;
	
	private Command CollectorIn;
	private Command CollectorOut;
	private Command SpinUpShooter;
	private Command StopShooter;
	private Command GearDoorDown;
	private Command GearDoorUp;
	private Command LiftStart;
	private Command ReverseLift;
	private Command DebugInfo;
	private Command Conveyer;
	private Command ResetFelO;
	private Command ToggleCamera;
	
	public OI (){
		
		
		//DO STUFF HERE NOW!!!!!
		if(!SmartDashboard.getBoolean("Joy", false)){
			
		//Instantiating all the Joysticks.
		Xbox_Controller = new Joystick(RobotMap.XBOXPORT);
		
		//Manipulator_Controller = new Joystick(RobotMap.MANIPULATORPORT);
		Log_Controller = new Joystick(RobotMap.LOGPORT);
		
		}else{
			
		//3D Logitec Controller
		Log_3d_Controller = new Joystick(RobotMap.LOG3DPORT);
				
		}
		
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
		
		//Logitech Controller
		Log_A_Button = new JoystickButton(Log_Controller, LOG_A_BUTTON);
		Log_B_Button = new JoystickButton(Log_Controller, LOG_B_BUTTON);
		Log_X_Button = new JoystickButton(Log_Controller, LOG_X_BUTTON);
		Log_Y_Button = new JoystickButton(Log_Controller, LOG_Y_BUTTON);
		Log_Left_Bumper = new JoystickButton(Log_Controller, LOG_LEFT_BUMPER);
		Log_Right_Bumper = new JoystickButton(Log_Controller, LOG_RIGHT_BUMPER);
		Log_Start = new JoystickButton(Log_Controller, LOG_START);
		Log_Back = new JoystickButton(Log_Controller, LOG_BACK);
		Log_Left_Stick_Button = new JoystickButton(Log_Controller, LOG_LS_BUTTON);
		Log_Right_Stick_Button = new JoystickButton(Log_Controller, LOG_RS_BUTTON);
		
		//Instantiating all the Commands used with buttons.
		CollectorIn = new CollectorIn();
		CollectorOut = new CollectorOut();
		SpinUpShooter = new SpinUpShooter();
		StopShooter = new StopShooter();
		GearDoorDown = new GearDoorDown();
		GearDoorUp = new GearDoorUp();
		LiftStart = new LiftStart();
		Conveyer = new ConveyerRun();
		ToggleCamera = new ToggleCamera();
		ResetFelO = new FelOreset();
		
		//Xbox_A_Button.whileHeld(CollectorIn);
		Xbox_B_Button.whenPressed(StopShooter);
		Xbox_Right_Bumper.whileHeld(Conveyer);
		Xbox_Start.whenPressed(ResetFelO);
		Xbox_Back.whenPressed(ToggleCamera);
		
		Log_A_Button.whenPressed(GearDoorUp);
		Log_B_Button.whenPressed(GearDoorDown);
		Log_Right_Bumper.whileHeld(CollectorIn);
		Log_Left_Bumper.whenPressed(ToggleCamera);
		Log_Back.whileHeld(CollectorOut);
	}
	
	public static OI getInstance(){
		return INSTANCE;
	}
	
}
