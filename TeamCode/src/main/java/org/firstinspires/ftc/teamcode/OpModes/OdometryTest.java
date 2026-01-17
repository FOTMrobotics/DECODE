package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.GoBildaPinpointDriver;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Odometry;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.DriveValues;
import org.fotmrobotics.trailblazer.Pose2D;

import org.firstinspires.ftc.teamcode.Subsystems.VulcanTurret;


@TeleOp
public class OdometryTest extends OpMode {

	Drive drive;
	VulcanTurret vulcanTurret;
	double vulkanXPosition;
	double vulkanYPosition;
	double xOffsetFromTarget;
	double yOffsetFromTarget;
	double angleOffset;
	double autoAimTurretTargetAngle;
	boolean startCompleted;


	public void init() {
		drive = new Drive(hardwareMap);
		vulcanTurret = new VulcanTurret(hardwareMap);

		Pose2D position = drive.odometry.getPosition();

		startCompleted = false;

	}

	public void loop() {
//		if (!vulcanTurret.startupCompleted()) {
//			vulcanTurret.startupReset();
//		} else {
			drive.mecanumDrive(gamepad1);
			Pose2D position = drive.odometry.getPosition();

			vulkanXPosition = 54.5 + position.getX();
			vulkanYPosition = 8.75 + position.getY();
			xOffsetFromTarget = 6 - vulkanXPosition;
			yOffsetFromTarget = 138 - vulkanYPosition;
			angleOffset = 90 - Math.atan2(yOffsetFromTarget, xOffsetFromTarget) * 180 / Math.PI;

			autoAimTurretTargetAngle = 180 + angleOffset + position.getH();
			if (autoAimTurretTargetAngle > 270) {
				autoAimTurretTargetAngle = ((autoAimTurretTargetAngle + 90) % 360) - 90;
			}

			vulcanTurret.toAngle(autoAimTurretTargetAngle);

			telemetry.addData("X", position.getX());
			telemetry.addData("Y", position.getY());
			telemetry.addData("Angle", position.getH());

			telemetry.addData("Vulkan X Position", vulkanXPosition);
			telemetry.addData("Vulkan Y Position", vulkanYPosition);
			telemetry.addData("💥💥💥Angle Offset💥💥💥", angleOffset);
			telemetry.addData("Auto Aim Turret Target Angle", autoAimTurretTargetAngle);

	//		vulcanTurret.telemetryPrintout(telemetry);
//		}
	}



}
