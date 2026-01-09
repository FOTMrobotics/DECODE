package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.VulcanDrivebase;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanHood;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanIntake;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanLift;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanShooter;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanTurret;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.DriveValues;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Odometry;
import org.firstinspires.ftc.teamcode.trailblazer.opModes.OTOS_tuning;
import org.firstinspires.ftc.teamcode.trailblazer.path.Event;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.firstinspires.ftc.teamcode.trailblazer.path.PathBuilder;

@TeleOp
public class VulcanMain extends OpMode {
	VulcanDrivebase vulcanDrivebase;
	VulcanHood vulcanHood;
	VulcanIntake vulcanIntake;
	VulcanLift vulcanLift;
	VulcanShooter vulcanShooter;
	VulcanTurret vulcanTurret;

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
		vulcanTurret = new VulcanTurret(hardwareMap);

//		drive = new Drive(hardwareMap);
//		odometry = new Odometry(hardwareMap);

	}

	@Override
	public void loop() {

		vulcanDrivebase.update(gamepad1);
		vulcanIntake.update(gamepad1);
		vulcanLift.update(gamepad1, telemetry);
		vulcanShooter.update(gamepad1, telemetry);
		vulcanHood.update(gamepad2, telemetry);
		vulcanTurret.update(gamepad2, telemetry);
	}
}
