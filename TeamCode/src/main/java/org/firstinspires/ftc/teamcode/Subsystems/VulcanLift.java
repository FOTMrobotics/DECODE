package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class VulcanLift {

	Servo liftMotor;
	ColorSensor ballKnowledge;
	AnalogInput liftEncoder;
	Double originalLiftPosition;
	Double rawLiftPosition;
	Double relativeLiftPosition;

	public VulcanLift(HardwareMap hardwareMap) {

		liftMotor = hardwareMap.get(Servo.class, "liftMotor");
		ballKnowledge = hardwareMap.get(ColorSensor.class, "ballKnowledge");
		liftEncoder = hardwareMap.get(AnalogInput.class, "liftEncoder");
		originalLiftPosition = (liftEncoder.getVoltage() / 3.3 * 720) % 360;

	}

	public void update(Gamepad gamepad1, Telemetry telemetry) {


		rawLiftPosition = (liftEncoder.getVoltage() / 3.3 * 720) % 360;
		relativeLiftPosition = originalLiftPosition - rawLiftPosition;

		if (rawLiftPosition > originalLiftPosition) {
			relativeLiftPosition = originalLiftPosition + 360 - rawLiftPosition
			;
		}

		if (gamepad1.left_bumper) {
			liftMotor.setPosition(0.6);
		} else {
			liftMotor.setPosition(0.5);
		}


//		telemetry.addData("Lift Position", liftMotor.());
//		telemetry.addData("Red", ballKnowledge.red());
//		telemetry.addData("Green", ballKnowledge.green());
//		telemetry.addData("Blue", ballKnowledge.blue());
//		telemetry.addData("originalLiftPosition", originalLiftPosition);
//		telemetry.addData("rawLiftPosition", rawLiftPosition);
//		telemetry.addData("relativeLiftPosition", relativeLiftPosition);



		//telemetry.addData("Proximity", ballKnowledge.);
	}
}
