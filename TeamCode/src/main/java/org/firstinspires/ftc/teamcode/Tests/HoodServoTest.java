package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.OpModes.Main;
import org.opencv.core.Mat;

@TeleOp(group = "Tests")
public class HoodServoTest extends OpMode {
    double pos = 0;
    double incSize = 0.1;

    Servo hoodServo;

    boolean dUpHeld, dDownHeld, yHeld, aHeld;

    @Override
    public void init() {
        hoodServo = hardwareMap.get(Servo.class, "hoodServo");
    }

    @Override
    public void loop() {
        if (gamepad1.y && !yHeld) incSize *= 10;
        else if (gamepad1.a && !aHeld) incSize /= 10;
        incSize = Math.min(incSize, 1);

        if (gamepad1.dpad_up && !dUpHeld) pos += incSize;
        else if (gamepad1.dpad_down && !dDownHeld) pos -= incSize;
        pos = Math.max(0, Math.min(incSize, 1));

        hoodServo.setPosition(pos);

        telemetry.addData("Servo at position", pos);
        telemetry.addData("Increments are of size", incSize);

        telemetry.addLine("Press DPad up to increase position");
        telemetry.addLine("Press DPad down to decrease position");
        telemetry.addLine("Press y to increase increment size");
        telemetry.addLine("Press a to decrease increment size");
    }
}
