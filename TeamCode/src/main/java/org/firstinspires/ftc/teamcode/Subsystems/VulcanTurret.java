package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class VulcanTurret {

	DcMotorEx turretMotor;
	int turretTargetPosition = 0;

	public VulcanTurret (HardwareMap hardwareMap) {
		turretMotor = hardwareMap.get(DcMotorEx.class, "turretMotor");
		turretMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		turretMotor.setTargetPosition(turretTargetPosition);
	}

	public void update (Gamepad gamepad2, Telemetry telemetry) {
		//turretMotor.setPower(-gamepad2.right_stick_x / 3);

		if (gamepad2.right_stick_x != 0) {
			turretTargetPosition -= gamepad2.right_stick_x * 10;
		}

		turretTargetPosition = Math.max(turretTargetPosition, -360);
		turretTargetPosition = Math.min(turretTargetPosition, 360);

		turretMotor.setTargetPosition(turretTargetPosition);
		turretMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
		turretMotor.setPower(0.8);

		telemetry.addData("Turret Encoder", turretMotor.getCurrentPosition());
		telemetry.addData("Target Position", turretTargetPosition);


	}
}

//Sensors
//Good things - two motors working on the same drive axle without breaking,
//Future - color sensor, limelight, lift positions, odometry, auto

