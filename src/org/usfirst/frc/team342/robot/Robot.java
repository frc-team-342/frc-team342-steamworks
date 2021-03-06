
package org.usfirst.frc.team342.robot;

import org.usfirst.frc.team342.robot.commands.AutoShootGroup;
import org.usfirst.frc.team342.robot.commands.DriveFoward;
import org.usfirst.frc.team342.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team342.robot.commands.LiftWJoystick;
import org.usfirst.frc.team342.robot.commands.RotateToDegree;
import org.usfirst.frc.team342.robot.commands.ShooterRun;
import org.usfirst.frc.team342.robot.commands.Useless;
import org.usfirst.frc.team342.robot.subsystems.CameraSystem;
import org.usfirst.frc.team342.robot.subsystems.ClimbSubsystem;
import org.usfirst.frc.team342.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team342.robot.subsystems.GearSubsystem;
import org.usfirst.frc.team342.robot.subsystems.LightsSubsystem;
import org.usfirst.frc.team342.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	
	private static CameraSystem cameraSystem;
	private static ClimbSubsystem climbSubsystem;
	private static DriveSubsystem drive;
	private static GearSubsystem gearSubsystem;
	private static LightsSubsystem lights;
	private static ShooterSubsystem shooter;
	
	private static Command driveWithJoystick;
	private static Command climbWithJoystick;
	private static Command shooterRun;
	private static Command Drivefoward;
	private static Command useless;
	private static Command autoShoot;
	private static Command autoRotate;
	
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public Robot(){
		cameraSystem = CameraSystem.getInstance();
		climbSubsystem = ClimbSubsystem.getInstance();
		drive = DriveSubsystem.getInstance();
		gearSubsystem = GearSubsystem.getInstance();
		//lights = LightsSubsystem.getInstance();
		shooter = ShooterSubsystem.getInstance();
		oi = OI.getInstance();
		//commands
		driveWithJoystick = new DriveWithJoystick();
		climbWithJoystick = new LiftWJoystick();
		shooterRun = new ShooterRun();
	}
	
	@Override
	public void robotInit() {
		// chooser.addObject("My Auto", new MyAutoCommand());
		useless = new Useless();
		autoShoot = new AutoShootGroup();
		Drivefoward = new DriveFoward(2.0 );
		autoRotate = new RotateToDegree(180.0);
		drive.resetGyro();
		chooser.addDefault("NoAutonomus", useless);
		chooser.addObject("It's Alive!", Drivefoward);
		chooser.addObject("Shoot!", autoShoot);
		chooser.addObject("Rotate 180 deg!", autoRotate);
		SmartDashboard.putData("Auto mode", chooser);
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Command autonomousCommand = chooser.getSelected();
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		//if (autonomousCommand != null)
		//	autonomousCommand.cancel();
		driveWithJoystick.start();
		
		if(!oi.Joystick) {
			climbWithJoystick.start();
			shooterRun.start();
		}
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("Hall-Effex", gearSubsystem.getHallEffect());
		//driveWithJoystick.start();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
