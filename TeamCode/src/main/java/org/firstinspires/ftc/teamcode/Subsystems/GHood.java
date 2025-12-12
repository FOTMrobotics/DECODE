
package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class GHood {

	Servo hoodServo;
	double hoodPosition;
	boolean dpadUpIsPressed = false;
	boolean dpadDownIsPressed = false;

	public GHood (HardwareMap hardwareMap) {
		hoodServo = hardwareMap.get(Servo.class, "hoodServo");
		hoodPosition = 0;
	}

public void update(Gamepad gamepad1, Telemetry telemetry) {
	if (!dpadUpIsPressed && gamepad1.dpad_up) {

		hoodPosition += 0.25;

	}

	if (!dpadDownIsPressed && gamepad1.dpad_down) {

		hoodPosition -= 0.25;

	}

	hoodPosition = Math.min(hoodPosition, 1);
	hoodPosition = Math.max(hoodPosition, 0);

	dpadUpIsPressed = gamepad1.dpad_up;
	dpadDownIsPressed = gamepad1.dpad_down;
	hoodServo.setPosition(hoodPosition);

	telemetry.addData("Ramp Position", hoodServo.getPosition());
	telemetry.addData("Target Position", hoodPosition);
	telemetry.update();
}
}
