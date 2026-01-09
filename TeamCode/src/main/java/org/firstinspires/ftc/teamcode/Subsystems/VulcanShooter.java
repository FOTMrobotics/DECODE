package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class VulcanShooter {
	DcMotorEx shooterMotor1;
	DcMotorEx shooterMotor2;
	Boolean xIsPressed;
	Boolean shooterState;

	public VulcanShooter (HardwareMap hardwareMap) {
		shooterMotor1 = hardwareMap.get(DcMotorEx.class, "shooterMotor1");
		shooterMotor2 = hardwareMap.get(DcMotorEx.class, "shooterMotor2");
		shooterState = false;
		xIsPressed = false;
		shooterMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
	}

	public void update(Gamepad gamepad1, Telemetry telemetry) {

		if (!xIsPressed) {
			if (gamepad1.x) {
				shooterState = !shooterState;
			}
		}

//		telemetry.addData("x", gamepad1.x);
//		telemetry.addData("shooterState", shooterState);
//		telemetry.addData("xIsPressed", xIsPressed);
		shooterMotor1.setVelocity(shooterState ? 2500 : 0);
		shooterMotor2.setVelocity(shooterState ? 2500 : 0);
//		telemetry.addData("Shooter Motor Difference", shooterMotor1.getCurrentPosition() - shooterMotor2.getCurrentPosition());
		xIsPressed = gamepad1.x;
	}
}
