package org.usfirst.frc.team342.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShootGroup extends CommandGroup {

	public AutoShootGroup(){
		addParallel(new ConveyerRun());
		addParallel(new ShooterRun(1.0));
	}
	
	
	
	
	
}
