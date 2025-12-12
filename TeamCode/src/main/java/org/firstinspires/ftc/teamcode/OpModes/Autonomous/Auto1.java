package org.firstinspires.ftc.teamcode.OpModes.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.GDrivebase;
//import org.firstinspires.ftc.teamcode.Subsystems.GFlywheel;
//import org.firstinspires.ftc.teamcode.Subsystems.GIntake;
//import org.firstinspires.ftc.teamcode.Subsystems.GHood;
//import org.firstinspires.ftc.teamcode.Subsystems.GSafety;
import org.firstinspires.ftc.teamcode.Subsystems.GFlywheel;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Auto1 extends LinearOpMode {

	GDrivebase gDrivebase;
	ElapsedTime timer;
	GFlywheel gFlywheel;
//	GHood gHood;
//	GIntake gIntake;
//	GSafety gSafety;
	Drive drive;

	@Override
	public void runOpMode() throws InterruptedException {
		drive = new Drive(hardwareMap);
		timer = new ElapsedTime();
		gFlywheel = new GFlywheel(hardwareMap);
//		gHood = new GHood(hardwareMap);
//		gIntake = new GIntake(hardwareMap);
//		gSafety = new GSafety(hardwareMap);

		gDrivebase = new GDrivebase(hardwareMap);
		waitForStart();

		while (opModeIsActive()) {
			//gDrivebase.learning(5, telemetry);
			gFlywheel.flywheelAuto(3000);
			//sleep(5000);
			//telemetry.addData("X Offset", );
			//telemetry.addData("Y Offset", yOffset);
			//telemetry.update();
		}

		telemetry.update();
	}
}
