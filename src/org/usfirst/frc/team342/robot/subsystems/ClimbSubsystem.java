package org.usfirst.frc.team342.robot.subsystems;

import org.usfirst.frc.team342.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbSubsystem extends Subsystem {

	private Talon climbMotor;
	private PowerDistributionPanel pdp;
	private boolean direction;
	
	private static final ClimbSubsystem INSTANCE = new ClimbSubsystem();
	
	public ClimbSubsystem(){
		climbMotor = new Talon(RobotMap.CLIMBMOTOR);
		pdp = new PowerDistributionPanel(RobotMap.PDPADDR);
		direction = false;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void Stop(){
		climbMotor.set(0.0);
	}
	
	
	
	public void Climb(double speed){
		climbMotor.set(speed);
		
	}
	
	public double getCurrent(){
		return pdp.getCurrent(13);
	}
	
	public static ClimbSubsystem getInstance(){
		return INSTANCE;
	}
	
	public void DebugInfo(){
		
	}

}
