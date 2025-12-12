package org.firstinspires.ftc.teamcode.trailblazer.drivebase;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorGoBildaPinpoint;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.fotmrobotics.trailblazer.MathKt;
import org.fotmrobotics.trailblazer.Pose2D;

/**
 * Controls the odometry. Currently supports the SparkFunOTOS.
 * To change the odometry method, change the methods corresponding to what they do.
 *
 * @author Preston Cokis
 */
public class Odometry {
    HardwareMap hardwareMap;

    DriveValues driveValues = new DriveValues();

    private GoBildaPinpointDriver pinpoint;

    Pose2D currentPos;
    Pose2D lastPos;

    public Odometry(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;

        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, driveValues.pinpoint);

        pinpoint.setOffsets(-170, -14, DistanceUnit.MM);

        pinpoint.recalibrateIMU();
        pinpoint.resetPosAndIMU();
    }

    /**
     * Updates the position values.
     */
    public void update() {
        lastPos = currentPos;

        pinpoint.update();
        org.firstinspires.ftc.robotcore.external.navigation.Pose2D position = pinpoint.getPosition();
        Pose2D pos = new Pose2D(position.getX(DistanceUnit.INCH), -position.getY(DistanceUnit.INCH), position.getHeading(AngleUnit.DEGREES));
        pos.setH(MathKt.angleWrap(pos.getH()));

        currentPos = pos;
    }

    public Pose2D getPosition() {
        update();
        return currentPos;
    }

    public Pose2D getLastPosition() {
        return lastPos;
    }

    /**
     * Resets the heading.
     */
    public void resetHeading() {
        pinpoint.recalibrateIMU();
    }

    /**
     * Resets the position.
     */
    public void resetPosition() {
        pinpoint.resetPosAndIMU();
    }
}
