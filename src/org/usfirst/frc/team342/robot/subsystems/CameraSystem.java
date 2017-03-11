package org.usfirst.frc.team342.robot.subsystems;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CameraSystem extends Subsystem {
 
	private static final CameraSystem instance = new CameraSystem();
	private CameraServer cameraserver;
	private UsbCamera usbcamera1;
	private UsbCamera usbcamera2;
	private MjpegServer mjserver;
	private static final String SVRNAME = "Mage";
	private static final String CAM1 = "Camera1";
	private static final String CAM2 = "Camera2";
	

	private CameraSystem(){
		cameraserver = CameraServer.getInstance();
		mjserver = cameraserver.addServer(SVRNAME);
		usbcamera1 = new UsbCamera(CAM1, 0);
	    usbcamera2 = new UsbCamera(CAM2, 1);
		usbcamera1.setVideoMode(PixelFormat.kMJPEG, 640, 480, 30);
		usbcamera2.setVideoMode(PixelFormat.kMJPEG, 640, 480, 30);
		mjserver.setSource(usbcamera1);
		SmartDashboard.putString("Camera Port", mjserver.getPort() + "");
	}

	public void ToggleCamera() {
		SmartDashboard.putString("hi:", "TGGL");
		if(mjserver.getSource().getName().equals(CAM1)){
			mjserver.setSource(usbcamera2);
			
		}else if(mjserver.getSource().getName().equals(CAM2)){
			mjserver.setSource(usbcamera1);
			
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public static CameraSystem getInstance(){
		return instance;
	}
	
}

