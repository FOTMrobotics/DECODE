package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp
public class Drivebase extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        //Declare Motors
        //Reset individual motor IDs on the driver hub
        DcMotor fLMotor = hardwareMap.dcMotor.get(fLMotor);
        DcMotor fRMotor = hardwareMap.dcMotor.get(fRMotor);
        DcMotor bLMotor = hardwareMap.dcMotor.get(bLMotor);
        DcMotor bRMotor = hardwareMap.dcMotor.get(bRMotor);

        //sample motor reversal
        //fLMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if(isStopRequested()) return;

        while(opModeIsActive()) {
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double z = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double fLPower = (y + x + z) / denominator;
            double bLPower = (y - x + z) / denominator;
            double fRPower = (y - x - z) / denominator;
            double bRPower = (y + x - z) / denominator;

            fLMotor.setPower(fLPower);
            bLMotor.setPower(bLPower);
            fRMotor.setPower(fRPower);
            bRMotor.setPower(bRPower);
        }
    }
}
