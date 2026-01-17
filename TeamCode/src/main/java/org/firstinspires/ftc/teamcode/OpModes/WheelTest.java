package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.GoBildaPinpointDriver;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Odometry;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.DriveValues;
import org.fotmrobotics.trailblazer.Pose2D;


@TeleOp
public class WheelTest extends OpMode {

	Drive drive;
	DcMotor fLMotor;
	DcMotor fRMotor;
	DcMotor bLMotor;
	DcMotor bRMotor;


	public void init() {
		drive = new Drive(hardwareMap);
		fLMotor = hardwareMap.get(DcMotor.class, "fLMotor");
		fRMotor = hardwareMap.get(DcMotor.class, "fRMotor");
		bLMotor = hardwareMap.get(DcMotor.class, "bLMotor");
		bRMotor = hardwareMap.get(DcMotor.class, "bRMotor");
	}

	public void loop() {
		Pose2D position = drive.odometry.getPosition();
		telemetry.addData("X", position.getX());
		telemetry.addData("Y", position.getY());
		telemetry.addData("Angle", position.getH());
		if (gamepad1.x) {
			bLMotor.setPower(1);
		} else if (gamepad1.y) {
			fLMotor.setPower(1);
		} else if (gamepad1.a) {
			bRMotor.setPower(1);
		} else if (gamepad1.b) {
			fRMotor.setPower(1);
		} else {
			bLMotor.setPower(0);
			fLMotor.setPower(0);
			bRMotor.setPower(0);
			fRMotor.setPower(0);
		}
	}
}

