package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Flywheel;

@TeleOp
public class Main extends OpMode {
    Flywheel flywheel;

    @Override
    public void init() {
        flywheel = new Flywheel(hardwareMap);
    }

    @Override
    public void loop() {
        flywheel.update(gamepad1);
    }
}
