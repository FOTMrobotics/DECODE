package org.firstinspires.ftc.teamcode.Tests;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
@TeleOp
public class LearnToDriveTest extends OpMode {

	DcMotor fLeft;
	DcMotor fRight;
	DcMotor bLeft;
	DcMotor bRight;
	@Override
	public void init () {
		fLeft = hardwareMap.get(DcMotor.class, "fLMotor");
		fLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
		fLeft.setPower(0);

		fRight = hardwareMap.get(DcMotor.class, "fRMotor");
		fRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
		fLeft.setPower(0);

		bLeft = hardwareMap.get(DcMotor.class, "bLMotor");
		bLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
		bLeft.setPower(0);

		bRight = hardwareMap.get(DcMotor.class, "bRMotor");
		bRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
		bRight.setPower(0);
	}
	@Override
	public void loop(){
		double x = gamepad1.left_stick_x;
		double y = -gamepad1.left_stick_y;
		double r = gamepad1.right_stick_x;

		fLeft.setPower(-y - x - r);
		fRight.setPower(y - x - r);
		bLeft.setPower(y - x + r);
		bRight.setPower(y + x - r);
	}
}
