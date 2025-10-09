package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake  {

    DcMotor intakeMotor1;
    DcMotor intakeMotor2;
    boolean intakeOn;
    boolean lastBumperState;

    public Intake (HardwareMap hardwareMap) {
        intakeMotor1 = hardwareMap.get(DcMotor.class, "intakeMotor1");
        intakeMotor1.setPower(0); // Make sure motor starts off with 0 rotation
        intakeMotor2 = hardwareMap.get(DcMotor.class, "intakeMotor2");
        intakeMotor2.setPower(0);
        intakeOn = false; // Track motor condition
        lastBumperState = false; // For edge detection
    }

    public void update(Gamepad gamepad1, Telemetry telemetry) {
            if (gamepad1.right_bumper) {
                intakeMotor1.setPower(1);
                intakeMotor2.setPower(1);
            }else{
                intakeMotor1.setPower(0);
                intakeMotor2.setPower(0);
            }
//            boolean currentBumperState = gamepad1.right_bumper;
//
//            // Detect rising edge: button was not pressed, now it is
//            if (currentBumperState && !lastBumperState) {
//                intakeOn = !intakeOn; // Toggle intake state
//                intakeMotor1.setPower(intakeOn ? 1.0 : 0.0);// Turn motor on or off
//                intakeMotor2.setPower(intakeOn ? 1.0 : 0.0);
//            }
//
//            // Save bumper state for next loop
//            lastBumperState = currentBumperState;

            // Telemetry for debugging
            telemetry.addData("Intake Status", intakeOn ? "ON" : "OFF");
            telemetry.update();

        }
    }
