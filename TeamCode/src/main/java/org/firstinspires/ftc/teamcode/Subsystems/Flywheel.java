package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class Flywheel {
    DcMotorEx flywheel;
    boolean state = false;
    boolean isPressed = false;

    public Flywheel(HardwareMap hardwareMap) {
        flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
        flywheel.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void update(Gamepad gamepad) {
        if (!isPressed) if (gamepad.a) state = !state;

        isPressed = gamepad.a;

        if (state) flywheel.setVelocity(2000);
        else flywheel.setVelocity(0);
    }
}
