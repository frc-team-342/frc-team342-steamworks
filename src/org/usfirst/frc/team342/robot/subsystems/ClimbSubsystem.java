package org.usfirst.frc.team342.robot.subsystems;

import org.usfirst.frc.team342.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbSubsystem extends Subsystem {

	Talon climbMotor;
	PowerDistributionPanel pdp;
	double current = 40;
	
	private static final ClimbSubsystem INSTANCE = new ClimbSubsystem();
	
	public ClimbSubsystem(){
		climbMotor = new Talon(RobotMap.CLIMBMOTOR);
		pdp = new PowerDistributionPanel(16);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void Stop(){
		climbMotor.set(0.0);
	}
	
	public void Climb(double speed){
		if (getCurrent()< current){
			climbMotor.set(speed);
			
		}
		
	}
	
	public double getCurrent(){
		return pdp.getCurrent(13);
	}
	
	public static ClimbSubsystem getInstance(){
		return INSTANCE;
	}

}
