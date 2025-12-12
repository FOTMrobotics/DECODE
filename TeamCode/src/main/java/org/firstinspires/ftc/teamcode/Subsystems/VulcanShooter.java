package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class VulcanShooter {
	DcMotor shooterMotor1;
	DcMotor shooterMotor2;
	Boolean xIsPressed;
	Boolean shooterState;

	public VulcanShooter (HardwareMap hardwareMap) {
		shooterMotor1 = hardwareMap.get(DcMotor.class, "shooterMotor1");
		shooterMotor2 = hardwareMap.get(DcMotor.class, "shooterMotor2");

	}

	public void update(Gamepad gamepad1) {

		if (!xIsPressed && gamepad1.x) {
			shooterState = !shooterState;
		}

		shooterMotor1.setPower(shooterState ? 0.0 : 1000);
		xIsPressed = gamepad1.x;
	}
}
