package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.VulcanDrivebase;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanHood;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanIntake;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanLift;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanShooter;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanTurretRed;

@TeleOp
public class VulcanMainRed extends OpMode {
	VulcanDrivebase vulcanDrivebase;
	VulcanHood vulcanHood;
	VulcanIntake vulcanIntake;
	VulcanLift vulcanLift;
	VulcanShooter vulcanShooter;
	VulcanTurretRed vulcanTurret;

//	Drive drive;
//	DriveValues driveValues;
//	Odometry odometry;
//	OTOS_tuning otosTuning;
//	Event event;
//	Path path;
//	PathBuilder pathBuilder;

	@Override
	public void init() {
		vulcanDrivebase = new VulcanDrivebase(hardwareMap);
		vulcanHood = new VulcanHood(hardwareMap);
		vulcanIntake = new VulcanIntake(hardwareMap);
		vulcanLift = new VulcanLift(hardwareMap);
		vulcanShooter = new VulcanShooter(hardwareMap);
		vulcanTurret = new VulcanTurretRed(hardwareMap);

//		drive = new Drive(hardwareMap);
//		odometry = new Odometry(hardwareMap);

	}

	@Override
	public void loop() {

		vulcanDrivebase.update(gamepad1);
		vulcanIntake.update(gamepad1, telemetry);
		vulcanLift.update(gamepad1, telemetry);
		vulcanShooter.update(gamepad1, telemetry);
		vulcanHood.update(gamepad2, telemetry);
		vulcanTurret.update(gamepad2, telemetry);
	}
}


//  TODO
// Convert each class from one update function to independent functions - DONE
// Make sure each system can be called for autonymous - DONE
// Fix turret limit switch - DONE
// Code turret auto aim for blue goal - DONE
// Code turret auto aim for red goal - DONE
// Code autonymous for blue far zone start
// Code autonymous for red far zone start
// Implement PID into turret - DONE
// Code red corner reset for TeleOp use - DONE
// Code blue corner reset for TeleOp use - DONE
// Separate auto aim code for Autonymous use - DONE
// Function for flap height
// Manual override for turret and hood flap - DONE
// Fix color sensor for lift - DONE(?)
// Implement PID into lift - DONE
