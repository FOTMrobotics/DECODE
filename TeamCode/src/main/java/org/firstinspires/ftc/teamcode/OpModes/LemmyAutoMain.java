package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Subsystems.GDrivebase;

@TeleOp
public class LemmyAutoMain extends OpMode {
	GDrivebase gDrivebase;

	@Override
	public void init() {
		gDrivebase = new GDrivebase(hardwareMap);

	}

	@Override
	public void loop() {
		gDrivebase.update(gamepad1);

	}
}
