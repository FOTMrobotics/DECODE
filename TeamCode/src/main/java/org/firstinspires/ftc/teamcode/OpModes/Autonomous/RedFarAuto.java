package org.firstinspires.ftc.teamcode.OpModes.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.firstinspires.ftc.teamcode.trailblazer.path.PathBuilder;
import org.fotmrobotics.trailblazer.Vector2D;

@Autonomous
public class RedFarAuto extends LinearOpMode {
	Drive drive = new Drive(hardwareMap);

	@Override
	public void runOpMode() throws InterruptedException {
		Path path = new PathBuilder(drive, new Vector2D(0,0))
				.point(new Vector2D(0, 20))
				.action(0.5, () -> {
					// do something
					return false;
				})
				.point(new Vector2D(20,20))
				.build();

		path.run();

	}
}
