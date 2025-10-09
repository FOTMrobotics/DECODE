package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class Drivebase {

    DcMotor fLMotor;
    DcMotor fRMotor;
    DcMotor bLMotor;
    DcMotor bRMotor;

    public Drivebase (HardwareMap hardwareMap) {
        fLMotor = hardwareMap.get(DcMotor.class, "fLMotor");
        fRMotor = hardwareMap.get(DcMotor.class, "fRMotor");
        bLMotor = hardwareMap.get(DcMotor.class, "bLMotor");
        bRMotor = hardwareMap.get(DcMotor.class, "bRMotor");
    }

    public void update(Gamepad gamepad1) {

        //sample motor reversal
        //fLMotor.setDirection(DcMotorSimple.Direction.REVERSE);

            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double z = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(z), 1);
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

