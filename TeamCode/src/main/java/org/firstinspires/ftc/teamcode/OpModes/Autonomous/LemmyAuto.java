package org.firstinspires.ftc.teamcode.OpModes.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.util.concurrent.TimeUnit;

import org.firstinspires.ftc.teamcode.Subsystems.GDrivebase;

@Autonomous
public class LemmyAuto extends LinearOpMode {

	GDrivebase gDrivebase;
	TimeUnit timeUnit;

	@Override
	public void runOpMode() {

		gDrivebase = new GDrivebase(hardwareMap);


		waitForStart();

		while (opModeIsActive()) {
			gDrivebase.learning(5, telemetry);
			sleep(5000);
		}


	}

}
