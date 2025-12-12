package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class GSafety {

	Servo safety;
	boolean leftBumperPressed = false;
	boolean safetyActivatedState = false;

	public GSafety (HardwareMap hardwareMap) {
		safety = hardwareMap.get(Servo.class, "shooterReleaseServo");
	}

	public void update(Gamepad gamepad1) {
		if (!leftBumperPressed && gamepad1.left_bumper) {
			safetyActivatedState = !safetyActivatedState;
		}

		leftBumperPressed = gamepad1.left_bumper;
		safety.setPosition(safetyActivatedState ? 0.535 : 0.41);
	}

}