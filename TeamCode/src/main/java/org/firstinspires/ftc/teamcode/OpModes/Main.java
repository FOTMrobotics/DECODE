package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Block;
import org.firstinspires.ftc.teamcode.Subsystems.Flywheel;
import org.firstinspires.ftc.teamcode.Subsystems.Drivebase;
import org.firstinspires.ftc.teamcode.Subsystems.Hood;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

@TeleOp
public class Main extends OpMode {
    Flywheel flywheel;
    Drivebase drivebase;
    Hood hood;
    Intake intake;
    Block block;

    @Override
    public void init() {
        flywheel = new Flywheel(hardwareMap);
        drivebase = new Drivebase (hardwareMap);
        hood = new Hood(hardwareMap);
        intake = new Intake(hardwareMap);
        block = new Block(hardwareMap);
    }

    @Override
    public void loop() {
        flywheel.update(gamepad1);
        drivebase.update(gamepad1);
        intake.update(gamepad1, telemetry);
        hood.update(gamepad2, telemetry);
        block.update(gamepad1);
    }
}
