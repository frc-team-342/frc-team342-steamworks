package org.usfirst.frc.team342.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShootGroup extends CommandGroup {

	private static final double Time = 9.0;
	private static final double BlueBKSpeedSetting = 4000;
	private static final double BlueFRSpeedSetting = 2300;
	private static final double RedBKSpeedSetting = 4000;
	private static final double RedFRSpeedSetting = 2300;

	public AutoShootGroup(){
		boolean Blue = true;
		DriverStation DS = DriverStation.getInstance();
		if(DS.getAlliance() == Alliance.Red){
			Blue = false;
		}
		if(Blue){
				addSequential(new TimedManualShoot(BlueFRSpeedSetting, BlueBKSpeedSetting, Time));
				addSequential(new DriveFoward(2.0));
			}else{
				addSequential(new DriveFoward(1.0));
				addSequential(new RotateToDegree(180));
				addSequential(new DriveBackward(1.0));
				addSequential(new TimedManualShoot(RedFRSpeedSetting, RedBKSpeedSetting, Time));
				addSequential(new DriveFoward(2.0));
				
				addSequential(new TimedManualShoot(RedFRSpeedSetting, RedBKSpeedSetting, Time));
				addSequential(new DriveFoward(2.0));
			}
		
		
	}
	
	
	
	
	
}
