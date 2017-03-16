package org.usfirst.frc.team342.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShootGroup extends CommandGroup {

	private static final double Time = 10;
	private static final double BlueBKSpeedSetting = 3000;
	private static final double BlueFRSpeedSetting = 2000;
	private static final double RedBKSpeedSetting = 3001;
	private static final double RedFRSppedSetting = 2001;

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
				addSequential(new TimedManualShoot(RedFRSppedSetting, RedBKSpeedSetting, Time));
				addSequential(new DriveFoward(2.0));
			}
		
		
	}
	
	
	
	
	
}
