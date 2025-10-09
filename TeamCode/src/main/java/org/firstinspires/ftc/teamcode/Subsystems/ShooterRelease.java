package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//TODO WHAT IS THIS?
@TeleOp
public class ShooterRelease extends LinearOpMode {

    // Declare the servo
    Servo shooterReleaseServo;

    // Define servo positions (you will need to adjust these based on your arm's design)
    private static final double ARM_DEFAULT_POSITION = 0.0;  // Neutral position (adjust as needed)
    private static final double ARM_MOVE_POSITION = 1.0;     // Position where arm moves out of the way (adjust as needed)

    @Override
    public void runOpMode() {

        // Initialize the servo from the hardware map
        shooterReleaseServo = hardwareMap.get(Servo.class, "shooterReleaseServo");

        // Initial arm position (start with the default position)
        shooterReleaseServo.setPosition(ARM_DEFAULT_POSITION);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // If the Left Bumper is pressed, move the arm to the move position
            if (gamepad1.left_bumper) {
                shooterReleaseServo.setPosition(ARM_MOVE_POSITION);  // Move arm out of the way
            } else {
                shooterReleaseServo.setPosition(ARM_DEFAULT_POSITION); // Return arm to default position
            }

            // Display the current position of the servo (for debugging purposes)
            telemetry.addData("Arm Position", shooterReleaseServo.getPosition());
            telemetry.update();
        }
    }
}