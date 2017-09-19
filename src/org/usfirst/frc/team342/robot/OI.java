package org.usfirst.frc.team342.robot;

import org.usfirst.frc.team342.robot.commands.ClimbWithButton;
import org.usfirst.frc.team342.robot.commands.CollectorIn;
import org.usfirst.frc.team342.robot.commands.CollectorOut;
import org.usfirst.frc.team342.robot.commands.ConveyerRun;
import org.usfirst.frc.team342.robot.commands.FelOreset;
import org.usfirst.frc.team342.robot.commands.GearDoorDown;
import org.usfirst.frc.team342.robot.commands.GearDoorUp;
import org.usfirst.frc.team342.robot.commands.ShooterRun;
import org.usfirst.frc.team342.robot.commands.StopShooter;
import org.usfirst.frc.team342.robot.commands.ToggleCamera;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private Command StopShooter;
	private Command GearDoorDown;
	private Command GearDoorUp;
	private Command Conveyer;
	private Command ResetFelO;
	private Command ToggleCamera;
	private Command SpinUpShooterJoy;
	private Command ClimbUpWithButton;
	private Command ClimbDownWithButton;
	
	public boolean Joystick;
	
	public OI(){
		
			//3D Logitech Controller
			//Log_3d_Controller = new Joystick(RobotMap.LOG3DPORT);
			
			//Setting the public variable joystick to false to tell other classes that we are using a joystick and custom controller.
			//Joystick = true;
		
		
		
			//Instantiating all the Joysticks.
			Xbox_Controller = new Joystick(RobotMap.XBOXPORT);
		
			//Manipulator_Controller = new Joystick(RobotMap.MANIPULATORPORT);
			Log_Controller = new Joystick(RobotMap.LOGPORT);
		
			//Setting the public variable joystick to true to tell other classes that we are using our xbox and logitech controllers.  
			Joystick = false;
		
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
	
		//Logitech 3d Joystick
		/*Log_3d_Button_One = new JoystickButton(Log_3d_Controller, LOG_3D_BUTTON_ONE);
		Log_3d_Button_Two = new JoystickButton(Log_3d_Controller, LOG_3D_BUTTON_TWO);
		Log_3d_Button_Three = new JoystickButton(Log_3d_Controller, LOG_3D_BUTTON_THREE);
		Log_3d_Button_Four = new JoystickButton(Log_3d_Controller, LOG_3D_BUTTON_FOUR);
		Log_3d_Button_Six = new JoystickButton(Log_3d_Controller, LOG_3D_BUTTON_SIX);
		Log_3d_Button_Seven = new JoystickButton(Log_3d_Controller, LOG_3D_BUTTON_SEVEN);
		Log_3d_Button_Eight = new JoystickButton(Log_3d_Controller, LOG_3D_BUTTON_EIGHT);
		Log_3d_Button_Nine = new JoystickButton(Log_3d_Controller, LOG_3D_BUTTON_NINE);
		Log_3d_Button_Ten = new JoystickButton(Log_3d_Controller, LOG_3D_BUTTON_TEN);
		Log_3d_Button_Eleven = new JoystickButton(Log_3d_Controller, LOG_3D_BUTTON_ELEVEN);
		Log_3d_Button_Twelve = new JoystickButton(Log_3d_Controller, LOG_3D_BUTTON_TWELVE);
		*/
		//Instantiating all the Commands used with buttons.
		CollectorIn = new CollectorIn();
		CollectorOut = new CollectorOut();
		SpinUpShooterJoy = new ShooterRun(1.0);
		StopShooter = new StopShooter();
		GearDoorDown = new GearDoorDown();
		GearDoorUp = new GearDoorUp();
		Conveyer = new ConveyerRun();
		ToggleCamera = new ToggleCamera();
		ResetFelO = new FelOreset();
		ClimbUpWithButton = new ClimbWithButton(1.0);
		ClimbDownWithButton = new ClimbWithButton(-1.0);
		
		//Setting each button to a command for each controller
		
		//XBOX
		Xbox_B_Button.whenPressed(StopShooter);
		Xbox_Right_Bumper.whileHeld(Conveyer);
		Xbox_Start.whenPressed(ResetFelO);
		//Xbox_Back.whenPressed(ToggleCamera);
		
		//Logitech controller
		Log_A_Button.whenPressed(GearDoorUp);
		Log_B_Button.whenPressed(GearDoorDown);
		Log_Right_Bumper.whileHeld(CollectorIn);
		//Log_Left_Bumper.whenPressed(ToggleCamera);
		Log_Back.whileHeld(CollectorOut);
		
		//Logitech 3d Joystick
		/*Log_3d_Button_One.whileHeld(SpinUpShooterJoy);
		Log_3d_Button_Two.whileHeld(GearDoorDown);
		Log_3d_Button_Three.whileHeld(GearDoorUp);
		Log_3d_Button_Four.whileHeld(CollectorIn);
		Log_3d_Button_Ten.whileHeld(ClimbUpWithButton);
		Log_3d_Button_Eleven.whileHeld(Conveyer);
		Log_3d_Button_Twelve.whileHeld(ClimbDownWithButton);
		*/
		
	}
	
	public static OI getInstance(){
		return INSTANCE;
	}
	
}
