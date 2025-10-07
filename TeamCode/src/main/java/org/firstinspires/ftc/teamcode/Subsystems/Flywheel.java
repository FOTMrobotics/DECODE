package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Flywheel {
    DcMotorEx flywheel;
    boolean state = false;
    boolean isPressed = false;

    public Flywheel(HardwareMap hardwareMap) {
        flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
    }

    public void update(Gamepad gamepad) {
        if (!isPressed) if (gamepad.a) state = !state;

        isPressed = gamepad.a;

        if (state) flywheel.setVelocity(1);
        else flywheel.setVelocity(0);
    }
}
