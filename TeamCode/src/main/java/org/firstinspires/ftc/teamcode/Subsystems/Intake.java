package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp
public class Intake extends LinearOpMode {


    @Override
    public void runOpMode() {
        // Initialize hardware
        DcMotor intakeMotor = hardwareMap.dcMotor.get(intakeMotor);
        intakeMotor.setPower(0); // Make sure motor starts off with 0 rotation
        boolean intakeOn = false; // Track motor condition
        boolean lastBumperState = false; // For edge detection

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start
        waitForStart();

        while (opModeIsActive()) {
            boolean currentBumperState = gamepad1.right_bumper;

            // Detect rising edge: button was not pressed, now it is
            if (currentBumperState && !lastBumperState) {
                intakeOn = !intakeOn; // Toggle intake state
                intakeMotor.setPower(intakeOn ? 1.0 : 0.0); // Turn motor on or off
            }

            // Save bumper state for next loop
            lastBumperState = currentBumperState;

            // Telemetry for debugging
            telemetry.addData("Intake Status", intakeOn ? "ON" : "OFF");
            telemetry.update();

        }
    }
}
