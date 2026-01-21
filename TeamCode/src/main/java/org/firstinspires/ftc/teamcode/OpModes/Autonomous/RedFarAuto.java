package org.firstinspires.ftc.teamcode.OpModes.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

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
	VulcanHood vulcanHood = new VulcanHood(hardwareMap);
	VulcanIntake vulcanIntake = new VulcanIntake(hardwareMap);
	VulcanLift vulcanLift = new VulcanLift(hardwareMap);
	VulcanShooter vulcanShooter = new VulcanShooter(hardwareMap);
	VulcanTurretBlue vulcanTurretBlue = new VulcanTurretBlue(hardwareMap);
	VulcanTurretRed vulcanTurretRed = new VulcanTurretRed(hardwareMap);

	@Override
	public void runOpMode() throws InterruptedException {
		Path path = new PathBuilder(drive, new Vector2D(0,0))
				.point(new Vector2D(0, 5))
				.action(0.3, () -> {
					// do something
					vulcanTurretRed.toAngle(vulcanTurretRed.setAutoAimTurretTargetAngle(89.5, 8.75, 138, 138));
					return false;
				})

				.action(0.5, () -> {
					// do something
					vulcanShooter.shooterOn(1800);
				})

				.point(new Vector2D(5, 5))

				.action(() -> {
					vulcanLift.indexToTargetPosition(vulcanLift.addIndex());
					vulcanLift.setPosition();
				})

				.point(new Vector2D(0, 5))
				.point(new Vector2D(5, 5))

				.action(() -> {
					vulcanLift.indexToTargetPosition(vulcanLift.addIndex());
					vulcanLift.setPosition();
				})

				.point(new Vector2D(0, 5))
				.point(new Vector2D(5, 5))

				.action(() -> {
					vulcanLift.indexToTargetPosition(vulcanLift.addIndex());
					vulcanLift.setPosition();
				})

				.action(() -> {
					vulcanShooter.shooterOff();
				})

				.point(new Vector2D(0, 0))
				.build();

		path.run();

	}
}
