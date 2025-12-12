package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class GIntake {
	DcMotor intakeMotor1;
	DcMotor intakeMotor2;

	public GIntake(HardwareMap hardwareMap) {
		intakeMotor1 = hardwareMap.get(DcMotor.class, "intakeMotor1");
		intakeMotor2 = hardwareMap.get(DcMotor.class, "intakeMotor2");
	}

	public void update(Gamepad gamepad1) {
		if (gamepad1.right_bumper) {
			intakeMotor1.setPower(0.65);
			intakeMotor2.setPower(0.65);
		} else {
			intakeMotor1.setPower(0);
			intakeMotor2.setPower(0);
		}
	}
}