package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class HoodControl extends LinearOpMode {

    // Declare motor
    DcMotor hoodMotor;

    // Encoder positions for moving the ramp
    private static final int RAISED_POSITION = 0; // You may need to adjust this
    private static final int LOWERED_POSITION = -500; // Adjust depending on your gear ratio

    @Override
    public void runOpMode() {

        // Initialize motor from hardware map
        hoodMotor = hardwareMap.get(DcMotor.class, "rampMotor");

        // Set motor direction and mode
        hoodMotor.setDirection(DcMotor.Direction.FORWARD);
        hoodMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hoodMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // D-pad UP raises the ramp
            if (gamepad2.dpad_up) {
                moveRampToPosition(RAISED_POSITION);
            }

            // D-pad DOWN lowers the ramp
            if (gamepad2.dpad_down) {
                moveRampToPosition(LOWERED_POSITION);
            }

            telemetry.addData("Ramp Position", hoodMotor.getCurrentPosition());
            telemetry.update();
        }
    }

    // Helper method to move the ramp
    private void moveRampToPosition(int targetPosition) {2
        hoodMotor.setTargetPosition(targetPosition);
        hoodMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hoodMotor.setPower(0.5); // Moderate power for controlled movement

        while (opModeIsActive() && hoodMotor.isBusy()) {
            telemetry.addData("Moving to", targetPosition);
            telemetry.addData("Current Pos", hoodMotor.getCurrentPosition());
            telemetry.update();
        }

        hoodMotor.setPower(0);
        hoodMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}