package org.usfirst.frc.team.robot.autonomous;

import org.usfirst.frc.team.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTurn extends Command {

	private double time;
	private double speed;
	
    public DriveTurn(double inputSpeed, double inputTime) {
        requires(Robot.drivetrain);
        
        speed = inputSpeed;
        time = inputTime;
    }

    protected void initialize() {
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.drivetrain.driveTurn(speed);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.drivetrain.driveStop();
    }

    protected void interrupted() {
    	Robot.drivetrain.driveStop();
    }
}