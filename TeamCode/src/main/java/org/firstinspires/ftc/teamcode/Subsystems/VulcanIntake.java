package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class VulcanIntake {

	DcMotor intakeMotor;

	public VulcanIntake(HardwareMap hardwareMap) {

		intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
		intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
	}

	public void update(Gamepad gamepad1) {
		if (gamepad1.right_bumper) {
			intakeMotor.setPower(0.65);
		} else {
			intakeMotor.setPower(0);
		}

	}
}
