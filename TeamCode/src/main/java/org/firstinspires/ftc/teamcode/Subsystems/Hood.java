package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
public class Hood {

    // Declare motor
    Servo hoodServo;

    public Hood(HardwareMap hardwareMap) {

        // Encoder positions for moving the ramp
        hoodServo = hardwareMap.get(Servo.class, "hoodServo");

    }

    public void update(Gamepad gamepad2, Telemetry telemetry) {
        // D-pad UP raises the ramp
        if (gamepad2.dpad_right) {
            hoodServo.setPosition(1);
        }

        if (gamepad2.dpad_up) {
            hoodServo.setPosition(0.66);
        }

        if (gamepad2.dpad_left) {
            hoodServo.setPosition(0.33);
        }

        // D-pad DOWN lowers the ramp
        if (gamepad2.dpad_down) {
            hoodServo.setPosition(0);
        }

        telemetry.addData("Ramp Position", hoodServo.getPosition());
        telemetry.update();
    }
}