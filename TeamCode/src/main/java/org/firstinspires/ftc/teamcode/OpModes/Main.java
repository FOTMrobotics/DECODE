package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Flywheel;
import org.firstinspires.ftc.teamcode.Subsystems.Drivebase;
import org.firstinspires.ftc.teamcode.Subsystems.HoodControl;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

@TeleOp
public class Main extends OpMode {
    Flywheel flywheel;

    @Override
    public void init() {
        flywheel = new Flywheel(hardwareMap);
        drivebase = new Drivebase (hardwareMap);
        hood = new HoodControl(hardwareMap);
        intake = new Intake(hardwareMap);
    }

    @Override
    public void loop() {
        flywheel.update(gamepad1);
        drivebase.update(gamepad1);
        intake.update(gamepad1);
        hood.update(gamepad2);
    }
}
