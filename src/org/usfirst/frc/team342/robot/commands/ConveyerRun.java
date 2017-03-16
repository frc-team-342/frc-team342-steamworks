package org.usfirst.frc.team342.robot.commands;
import org.usfirst.frc.team342.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class ConveyerRun extends Command{

private ShooterSubsystem shooterSystem;
	
	public ConveyerRun(){
		shooterSystem = ShooterSubsystem.getInstance();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

		public void intialize(){
			
		}
		public void execute(){
			shooterSystem.ConveyerOn();
		}
		protected void end() {
			shooterSystem.ConveyerStop();
		}

		@Override
		protected void interrupted() {
			shooterSystem.ConveyerStop();
		}
}
