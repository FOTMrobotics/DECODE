package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.fotmrobotics.trailblazer.Pose2D;

public class VulcanTurret {
	// TeleOp Turret
	DcMotorEx turretMotor;
	DigitalChannel turretLimitSwitch;
	double turretTargetPosition = 0;
	double turretTargetAngle;
	boolean startupCompleted;

	boolean aIsPressed;
	boolean manualOverride;

	// Auto Aim Turret
	double vulkanXPosition;
	double vulkanYPosition;
	double xOffsetFromTarget;
	double yOffsetFromTarget;
	double angleOffset;
	double autoAimTurretTargetAngle;
	Drive drive;
	boolean bIsPressed;
	boolean xIsPressed;



	public VulcanTurret (HardwareMap hardwareMap) {
		turretMotor = hardwareMap.get(DcMotorEx.class, "turretMotor");
		turretLimitSwitch = hardwareMap.get(DigitalChannel.class, "turretLimitSwitch");
		turretMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		turretMotor.setTargetPosition((int)turretTargetPosition);
		startupCompleted = false;

		aIsPressed = false;
		manualOverride = false;

		drive = new Drive(hardwareMap);
	}

	public void update (Gamepad gamepad2, Telemetry telemetry) {
		if (!startupCompleted) {
			startupReset();
			telemetryPrintout(telemetry);
		} else {
			if (aimingManualOverride(gamepad2)) {
				setTargetAngle(gamepad2);
				toAngle(turretTargetAngle);
				telemetryPrintout(telemetry);
			} else {
				setAutoAimTurretTargetAngle(54.5, 8.75, 6, 138);
				toAngle(autoAimTurretTargetAngle);
				autoTurretTelemetryPrintout(telemetry);
			}
		}

	}



	public double encoderToAngle() {
		return 90 + ((-turretMotor.getCurrentPosition()) / 145.1 / 61 * 12) * 360;
	}

	public double angleToEncoder(double angle) {
		return angle / 360 * 61 / 12 * 145.1;
	}

	public void toAngle(double angle) {
		turretMotor.setTargetPosition((int)angleToEncoder(-angle));
		turretMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
		turretMotor.setPower(0.8);
	}

	public void startupReset() {
		if (!startupCompleted) {
			turretMotor.setPower(0.2);
			if (!turretLimitSwitch.getState()) {
				turretMotor.setPower(0);
//			turretMotor.setTargetPosition((int) angleToEncoder(turretTargetAngle));
				turretMotor.setTargetPosition(turretMotor.getCurrentPosition());
				turretTargetPosition = 0;
				turretTargetAngle = 0;
				turretMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
				startupCompleted = true;
			}
		}
	}


	public void setTargetAngle(Gamepad gamepad2) {
		if (gamepad2.right_stick_x != 0) {
			turretTargetAngle -= gamepad2.right_stick_x * 8;
		}
		turretTargetAngle = Math.max(turretTargetAngle, -90);
		turretTargetAngle = Math.min(turretTargetAngle, 270);
//		return turretTargetAngle;
	}

	public void telemetryPrintout (Telemetry telemetry) {
//		telemetry.addData("Limit Switch State", turretLimitSwitch.getState());
//		telemetry.addData("Turret Encoder Position", turretMotor.getCurrentPosition());
//		telemetry.addData("Encoder to Angle", encoderToAngle());
//		telemetry.addData("Angle to Encoder", angleToEncoder(turretTargetAngle));
//		telemetry.addData("Target Angle", turretTargetAngle);
//		telemetry.addData("turret target position", turretTargetPosition);
		telemetry.addData("startup completed", startupCompleted);

	}

	//AUTO AIM FUNCTIONS

	public void setAutoAimTurretTargetAngle(double xStartPosition, double yStartPosition, double xTargetPosition, double yTargetPosition) {
		Pose2D position = drive.odometry.getPosition();

		vulkanXPosition = xStartPosition + position.getX();
		vulkanYPosition = yStartPosition + position.getY();
		xOffsetFromTarget = xTargetPosition - vulkanXPosition;
		yOffsetFromTarget = yTargetPosition - vulkanYPosition;
		angleOffset = 90 - Math.atan2(yOffsetFromTarget, xOffsetFromTarget) * 180 / Math.PI;

		autoAimTurretTargetAngle = 180 + angleOffset + position.getH();
		if (autoAimTurretTargetAngle > 270) {
			autoAimTurretTargetAngle = ((autoAimTurretTargetAngle + 90) % 360) - 90;
		}
	}

	public boolean aimingManualOverride(Gamepad gamepad2) {
		if (!aIsPressed && gamepad2.a) {
			manualOverride = !manualOverride;
		}
		aIsPressed = gamepad2.a;
		return manualOverride;
	}

	public void manualOverride(Gamepad gamepad2) {
		if (!bIsPressed && gamepad2.b) {
			turretMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			setAutoAimTurretTargetAngle(137.375, 8.75, 6, 138);
		} else if (!xIsPressed && gamepad2.x) {
			turretMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
			setAutoAimTurretTargetAngle(6.625, 8.75, 138, 138);
		}
		bIsPressed = gamepad2.b;
		xIsPressed = gamepad2.x;
	}
		
	public void autoTurretTelemetryPrintout(Telemetry telemetry) {
	//	telemetry.addData("X", position.getX());
	//	telemetry.addData("Y", position.getY());
	//	telemetry.addData("Angle", position.getH());

	//	telemetry.addData("Vulkan X Position", vulkanXPosition);
	//	telemetry.addData("Vulkan Y Position", vulkanYPosition);
	//	telemetry.addData("💥💥💥Angle Offset💥💥💥", angleOffset);
	//	telemetry.addData("Auto Aim Turret Target Angle", autoAimTurretTargetAngle);
		// bruh
	}
}


