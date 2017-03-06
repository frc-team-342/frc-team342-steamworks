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
	private UsbCamera usbcamer2;
	private MjpegServer mjserver;
	

	private CameraSystem(){
		cameraserver = CameraServer.getInstance();
		mjserver = cameraserver.addServer("Mage");
		usbcamera1 = new UsbCamera("Camera1", 0);
	  //usbcamera2 = new UsbCamera("Camera2", 1);
		usbcamera1.setVideoMode(PixelFormat.kMJPEG, 640, 480, 30);
		mjserver.setSource(usbcamera1);
		SmartDashboard.putString("Camera Port", mjserver.getPort() + "");
	}
	public static CameraSystem getInstance(){
		return instance;
		
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void ToggleCamera() {
		
	}
	
}

