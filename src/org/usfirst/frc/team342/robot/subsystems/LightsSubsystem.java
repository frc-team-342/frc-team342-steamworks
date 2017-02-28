package org.usfirst.frc.team342.robot.subsystems;

import org.usfirst.frc.team342.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LightsSubsystem extends Subsystem {
	private Servo red;
	private Servo green;
	private Servo blue;
	private Servo Camera1;
	private Servo Camera2;
	private Servo Spot;
	
	private static final LightsSubsystem INSTANCE = new LightsSubsystem();
	
	private LightsSubsystem (){
		red= new Servo (RobotMap.LightsRed);
		green= new Servo (RobotMap.LightsGreen);
		blue= new Servo (RobotMap.LightsBlue);
		Camera1= new Servo (RobotMap.LightsCamera1);
		Camera2= new Servo(RobotMap.LightsCamera2);
		Spot= new Servo (RobotMap.LightsSpot);
	
	}

	public static LightsSubsystem getInstance (){
		return INSTANCE;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	
		
	}
	public void setrgb (double redn, double greenn, double bluen){
		red.setRaw((int)(redn*255));
		green.setRaw((int)(greenn*255));
		blue.setRaw((int)(bluen*255));
	
		//SmartDashboard.putDouble("red", redn);
	}
	public void setred (double redn){
		red.set(redn);
	}
	public void setgreen (double greenn){
		green.set(greenn);
	}
	public void setblue (double bluen){
		blue.set(bluen);
	}
	public void setCamera1 (double Camera1n){
		Camera1.set(Camera1n);
	}
	public void setCamera2 (double Camera2n){
		Camera2.set(Camera2n);
	}
	public void setSpot (double Spotn){
		Spot.set(Spotn);
	}

	public void setoff (){
		red.set(0);
		green.set(0);
		blue.set(0);
	}
	
	public void DebugInfo(){
		
	}

}
