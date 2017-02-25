package org.usfirst.frc.team.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team.robot.autonomous.AutoNothing;
import org.usfirst.frc.team.robot.autonomous.AutoTest;
import org.usfirst.frc.team.robot.subsystems.Drivetrain;

public class Robot extends IterativeRobot {

	public static Drivetrain drivetrain = new Drivetrain();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> autonomousChooser = new SendableChooser<>();

	public void robotInit() {
		oi = new OI();
		autonomousChooser.addDefault("Nothing", new AutoNothing());
		autonomousChooser.addObject("Test", new AutoTest());
		SmartDashboard.putData("Auto Mode Chooser", autonomousChooser);
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = autonomousChooser.getSelected();

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}