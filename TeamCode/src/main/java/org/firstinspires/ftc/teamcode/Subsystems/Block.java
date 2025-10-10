package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Block {
    Servo bl;
    boolean close;
    boolean lbHeld;

    public Block (HardwareMap hwMap) {
        bl = hwMap.get(Servo.class, "shooterReleaseServo");
    }

    //toggle via left bumper
    public void update (Gamepad gamepad1) {
        if(gamepad1.left_bumper && !lbHeld) close ^= true; //Silly idioms
        bl.setPosition(close ? 1 : 0);
    }
}
