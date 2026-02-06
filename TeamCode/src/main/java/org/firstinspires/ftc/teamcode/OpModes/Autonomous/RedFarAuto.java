package org.firstinspires.ftc.teamcode.OpModes.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.VulcanHood;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanIntake;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanLift;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanShooter;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanTurretBlue;
import org.firstinspires.ftc.teamcode.Subsystems.VulcanTurretRed;
import org.firstinspires.ftc.teamcode.trailblazer.drivebase.Drive;
import org.firstinspires.ftc.teamcode.trailblazer.path.Path;
import org.firstinspires.ftc.teamcode.trailblazer.path.PathBuilder;
import org.fotmrobotics.trailblazer.Vector2D;

@Autonomous
public class RedFarAuto extends LinearOpMode {
	Drive drive = new Drive(hardwareMap);
//	VulcanHood vulcanHood = new VulcanHood(hardwareMap);
//	VulcanIntake vulcanIntake = new VulcanIntake(hardwareMap);
//	VulcanLift vulcanLift = new VulcanLift(hardwareMap);
//	VulcanShooter vulcanShooter = new VulcanShooter(hardwareMap);
//	VulcanTurretBlue vulcanTurretBlue = new VulcanTurretBlue(hardwareMap);
//	VulcanTurretRed vulcanTurretRed = new VulcanTurretRed(hardwareMap);
	ElapsedTime timer = new ElapsedTime();

	@Override
	public void runOpMode() throws InterruptedException {
		Path path = new PathBuilder(drive, new Vector2D(0,0))
				.point(new Vector2D(0, 5))

				.point(new Vector2D(20, 20))

				.build();

		path.run();

	}

}