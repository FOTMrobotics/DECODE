package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Odometry;
import org.fotmrobotics.trailblazer.PIDF;

public class VulcanLift {

	Servo liftServo;
	RevColorSensorV3 ballKnowledge;
	double targetPosition;
	double ballDistance;
	int currentIndex;
	boolean leftBumperIsPressed;
	boolean liftActive;

//	private double p = 0;
//	private double i = 0;
//	private double d = 0;
//	private double f = 0;
//	private PIDF pidf = new PIDF(p, i, d, f);


	private final double[] positions = {0.40, 0.52, 0.65, 0.72, 0.84, 0.96};

	public VulcanLift(HardwareMap hardwareMap) {

		liftServo = hardwareMap.get(Servo.class, "liftServo");
		ballKnowledge = hardwareMap.get(RevColorSensorV3.class, "ballKnowledge");

		currentIndex = 0;
		leftBumperIsPressed = false;
		liftActive = false;
	}

	public void update(Gamepad gamepad1, Telemetry telemetry) {

		liftActive();
		currentIndex(gamepad1);
		setPosition();
		telemetry(telemetry);


	}

	public void liftActive() {
		if (ballKnowledge.blue() > 50) {
			liftActive = true;
		} else if (ballKnowledge.blue() < 50) {
			liftActive = false;
		}
	}

	public void currentIndex(Gamepad gamepad1) {
		if (gamepad1.left_bumper && !leftBumperIsPressed) {
			currentIndex = (currentIndex + 1) % positions.length;
		} else if (ballKnowledge.blue() > 50 && !liftActive) {
			if (currentIndex < 2) {
				currentIndex = (currentIndex + 1) % positions.length;
			}
		}

		targetPosition = (positions[currentIndex]);
		leftBumperIsPressed = gamepad1.left_bumper;
	}

	public void setPosition() {
		liftServo.setPosition(targetPosition);
	}

	public void addIndex() {
		currentIndex += currentIndex + 1;
	}

	public void telemetry(Telemetry telemetry) {
//		telemetry.addData("Lift Position", liftServo.getPosition());
//		telemetry.addData("Red", ballKnowledge.red());
//		telemetry.addData("Green", ballKnowledge.green());
//		telemetry.addData("Blue", ballKnowledge.blue());
//		telemetry.addData("originalLiftPosition", originalLiftPosition);
//		telemetry.addData("Target Position", targetPosition);
//		telemetry.addData("currentIndex", currentIndex);
//		telemetry.addData("Lift Servo Position", positions[currentIndex]);
//		telemetry.addData("Color Sensor Distance", ballDistance);
//		telemetry.addData("relativeLiftPosition", relativeLiftPosition);
	}
}
