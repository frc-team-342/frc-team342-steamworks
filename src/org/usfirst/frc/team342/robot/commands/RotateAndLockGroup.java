package org.usfirst.frc.team342.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RotateAndLockGroup extends CommandGroup {
	
	public RotateAndLockGroup(double degree){
		addSequential(new RotateToDegree(degree));
		addSequential(new LockHeading());
	}
}
