package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
public class Hood {

    // Declare motor
    DcMotor hoodMotor;

    //TODO FIGURE OUT IF THESE ARE RIGHT BECAUSE THEY DEFINITELY AREN'T. SORRY.
    public static final int RAISED_POSITION = 0; // You may need to adjust this
    public static final int LOWERED_POSITION = -500; // Adjust depending on your gear ratio

    public Hood(HardwareMap hardwareMap) {

        // Encoder positions for moving the ramp
        hoodMotor = hardwareMap.get(DcMotor.class, "rampMotor");
        // Set motor direction and mode
        hoodMotor.setDirection(DcMotor.Direction.FORWARD);
        hoodMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hoodMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void update(Gamepad gamepad2, Telemetry telemetry) {
            // D-pad UP raises the ramp
            if (gamepad2.dpad_up) {
                moveRampToPosition(RAISED_POSITION, telemetry);
            }

            // D-pad DOWN lowers the ramp
            if (gamepad2.dpad_down) {
                moveRampToPosition(LOWERED_POSITION, telemetry);
            }

            telemetry.addData("Ramp Position", hoodMotor.getCurrentPosition());
            telemetry.update();
    }

    // Helper method to move the ramp
    private void moveRampToPosition(int targetPosition, Telemetry telemetry) {
        hoodMotor.setTargetPosition(targetPosition);
        hoodMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        hoodMotor.setPower(0.5); // Moderate power for controlled movement

        while (hoodMotor.isBusy()) {
            telemetry.addData("Moving to", targetPosition);
            telemetry.addData("Current Pos", hoodMotor.getCurrentPosition());
            telemetry.update();
        }

        hoodMotor.setPower(0);
        hoodMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}