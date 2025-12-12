package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Subsystems.GDrivebase;
import org.firstinspires.ftc.teamcode.Subsystems.GFlywheel;
import org.firstinspires.ftc.teamcode.Subsystems.GHood;
import org.firstinspires.ftc.teamcode.Subsystems.GIntake;
import org.firstinspires.ftc.teamcode.Subsystems.GSafety;

import org.firstinspires.ftc.teamcode.Subsystems.Testing;

@TeleOp
public class GMain extends OpMode {
	GDrivebase gDrivebase;
	GFlywheel gFlywheel;
//	GIntake gIntake;
	GHood gHood;
	GSafety gSafety;

	Testing testing;

	@Override
	public void init() {
		gDrivebase = new GDrivebase(hardwareMap);
		gFlywheel = new GFlywheel(hardwareMap);
//		gIntake = new GIntake(hardwareMap);
		gHood = new GHood(hardwareMap);
		gSafety = new GSafety(hardwareMap);

		testing = new Testing(hardwareMap);
	}

	@Override
	public void loop() {

		gDrivebase.update(gamepad1);
		gFlywheel.update(gamepad1);
//		gIntake.update(gamepad1);
		gHood.update(gamepad1, telemetry);
		gSafety.update(gamepad1);
		testing.update(gamepad1, telemetry);
		}
}