package org.usfirst.frc.team342.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CamraSubsystem extends Subsystem {
 
	private static final CamraSubsystem instance = new CamraSubsystem();
	private CameraServer camServer;
	private UsbCamera cam0;
	private UsbCamera cam1;
	private String curCam;
	private static final int CAM1 = 0;
	private static final int CAM2 = 1;
	
	private CamraSubsystem(){
		cam0 = new UsbCamera("cam0", "dev/cam0");
		cam1 = new UsbCamera("cam1", "dev/cam1");
		camServer = CameraServer.getInstance();
		curCam = cam1.getName();
	}
	
	@Override
	protected void initDefaultCommand() {
			
	}
	
	public void seeWithCamera(String currentCamera){
		if(currentCamera.equals(cam0.getName())){
			camServer.startAutomaticCapture(cam0);
		}else if(currentCamera.equals(cam1.getName())){
			camServer.startAutomaticCapture(cam1);
		}
	}
	
	public void switchCamera(){
		if(curCam.equals("cam0")){
			
			camServer.removeCamera(curCam);
			curCam = cam1.getName();
		}else if(curCam.equals("cam1")){
			
			camServer.removeCamera(curCam);
			curCam = cam0.getName();
		}
	}
	
	public String getCurrentCamera(){
		return curCam;
	}
	
	public static CamraSubsystem getInstance(){
		return instance;
		
	}
	public void DegubInfo(){
		
	}
}

