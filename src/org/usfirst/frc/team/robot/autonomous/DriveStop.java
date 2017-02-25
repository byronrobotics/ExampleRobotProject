package org.usfirst.frc.team.robot.autonomous;

import org.usfirst.frc.team.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStop extends Command {

	private double time;
	
    public DriveStop() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    	setTimeout(time);
    }

    protected void execute() {
    	Robot.drivetrain.driveStop();
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