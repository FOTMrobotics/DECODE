package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.hardware.bosch.BNO055IMU;

import org.firstinspires.ftc.robotcontroller.external.samples.UtilityOctoQuadConfigMenu;
import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Testing {
	BNO055IMU imu;
	boolean bIsPressed;

	public Testing(HardwareMap hardwareMap) {
		imu = hardwareMap.get(BNO055IMU.class, "imu");
		BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
		parameters.mode = BNO055IMU.SensorMode.IMU;
		parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
		parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
		parameters.loggingEnabled = true;
		imu.initialize(parameters);
	}

	public void update(Gamepad gamepad1, Telemetry telemetry) {
		if (!bIsPressed && gamepad1.b) {
			telemetry.addData("Heading", imu.getAngularOrientation());
			telemetry.addData("Position", imu.getPosition());
			telemetry.update();
		}

		bIsPressed = gamepad1.b;
	}
}