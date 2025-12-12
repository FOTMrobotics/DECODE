package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class GDrivebase {

	DcMotor fLMotor;
	DcMotor fRMotor;
	DcMotor bLMotor;
	DcMotor bRMotor;
	ElapsedTime timer;


	public GDrivebase (HardwareMap hardwareMap){
		fLMotor = hardwareMap.get(DcMotor.class, "fLMotor");
		fRMotor = hardwareMap.get(DcMotor.class, "fRMotor");
		bLMotor = hardwareMap.get(DcMotor.class, "bLMotor");
		bRMotor = hardwareMap.get(DcMotor.class, "bRMotor");
		timer = new ElapsedTime();
	}

	public void update(Gamepad gamepad1){

		fLMotor.setDirection(DcMotorSimple.Direction.REVERSE);
		bLMotor.setDirection(DcMotorSimple.Direction.REVERSE);

		double x = gamepad1.left_stick_x * 1.1;
		double y = -gamepad1.left_stick_y;
		double z = gamepad1.right_stick_x;

		double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(z), 1);
		double fLPower = (y + x + z) / denominator;
		double fRPower = (y - x - z) / denominator;
		double bLPower = (y - x + z) / denominator;
		double bRPower = (y + x - z) / denominator;

		fLMotor.setPower(fLPower);
		fRMotor.setPower(fRPower);
		bLMotor.setPower(bLPower);
		bRMotor.setPower(bRPower);

	}

	public void learning( int testingInt, Telemetry telemetry){
		timer.startTime();
		testingInt = 0;

		
		if (timer.milliseconds() > 1000) {
			timer.reset();
			testingInt += 1;
			telemetry.addData("If this says 5, then it works", testingInt);
		}
	}
}
