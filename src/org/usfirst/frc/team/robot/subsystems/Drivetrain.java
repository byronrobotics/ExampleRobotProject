package org.usfirst.frc.team.robot.subsystems;

import org.usfirst.frc.team.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	public static CANTalon motorDrivetrainFrontLeft = new CANTalon(RobotMap.frontLeftDriveMotor);
	public static CANTalon motorDrivetrainFrontRight = new CANTalon(RobotMap.frontRightRightMotor);
	public static CANTalon motorDrivetrainBackLeft = new CANTalon(RobotMap.backLeftDriveMotor);
	public static CANTalon motorDrivetrainBackRight = new CANTalon(RobotMap.backRightRightMotor);
	
	public static RobotDrive drive = new RobotDrive(motorDrivetrainFrontLeft, motorDrivetrainBackLeft, motorDrivetrainFrontRight, motorDrivetrainBackRight);
	
public Drivetrain() {
		
		// Set a timeout for the motors
		drive.setSafetyEnabled(true);
		drive.setExpiration(1);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}

	public void driveWithJoystick(Joystick joystick) {
		double y = joystick.getY();
		double x = joystick.getX();
		double twist = joystick.getTwist();
		
		drive.mecanumDrive_Cartesian(x, y, twist, 0);
	}
	
	public void driveForward(double inputSpeed) {
		drive.mecanumDrive_Cartesian(0, inputSpeed, 0, 0);
	}
	
	public void driveStop() {
		drive.mecanumDrive_Cartesian(0, 0, 0, 0);
	}
	
	public void driveTurn(double inputTwist) {
		drive.mecanumDrive_Cartesian(0, 0, inputTwist, 0);
	}
}