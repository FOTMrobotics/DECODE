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

	@Override
	public void runOpMode() throws InterruptedException {

		Drive drive = new Drive(hardwareMap);
	VulcanHood vulcanHood = new VulcanHood(hardwareMap);
	VulcanIntake vulcanIntake = new VulcanIntake(hardwareMap);
	VulcanLift vulcanLift = new VulcanLift(hardwareMap);
	VulcanShooter vulcanShooter = new VulcanShooter(hardwareMap);
	VulcanTurretBlue vulcanTurretBlue = new VulcanTurretBlue(hardwareMap);
	VulcanTurretRed vulcanTurretRed = new VulcanTurretRed(hardwareMap);
		ElapsedTime timer = new ElapsedTime();

		waitForStart();
		Path path = new PathBuilder(drive, new Vector2D(0,0))
				.headingConstant(0)
				.action(0.0, () -> {
					vulcanTurretRed.startupReset();
					return false;
				})
				.action(0.0, () -> {
					vulcanTurretRed.toAngle(vulcanTurretRed.setAutoAimTurretTargetAngle(89.5, 8.75, 138, 138) + 13);
					return false;
				})
				.point(new Vector2D(0, 25))

				.action(0.0, () -> {
					vulcanShooter.shooterOnOff(2050);
					return false;
				})

//				.action(0.0, () -> {
//					vulcanLift.addIndex();
//					vulcanLift.setPosition(vulcanLift.indexToTargetPosition(vulcanLift.addIndex()));
//				})
	//			.point(new Vector2D(20, 20))

				.build();

		path.run();

	}

}