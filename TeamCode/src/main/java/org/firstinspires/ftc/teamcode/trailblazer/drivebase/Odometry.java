package org.firstinspires.ftc.teamcode.trailblazer.drivebase;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.fotmrobotics.trailblazer.Pose2D;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;

/**
 * Controls the odometry. Currently supports the SparkFunOTOS and GoBilda Odom Computers.
 * To change the odometry method, change the methods corresponding to what they do.
 *
 * @author Preston Cokis
 */
public class Odometry {
    private final GoBildaPinpointDriver odo;

    Pose2D currentPos;
    Pose2D lastPos;

    public Odometry(HardwareMap hardwareMap) {
        odo = hardwareMap.get(GoBildaPinpointDriver.class, "odo");

        odo.setOffsets(DriveValues.offset.getX(),DriveValues.offset.getY(), DriveValues.offsetUnit);

        odo.setEncoderDirections(DriveValues.odoDir[0], DriveValues.odoDir[1]);

        odo.setEncoderResolution(DriveValues.podType);

        odo.resetPosAndIMU();

        currentPos = new Pose2D(0,0,0);

        odo.setPosition(new org.firstinspires.ftc.robotcore.external.navigation.Pose2D(
                DistanceUnit.MM, 0,0,AngleUnit.RADIANS, 0));
    }

    /**
     * Updates the position values.
     */
    public void update() {
        lastPos = (Pose2D) currentPos.clone();
        odo.update();

        currentPos.setX(odo.getPosX(DriveValues.linearUnit));
        currentPos.setY(odo.getPosY(DriveValues.linearUnit));
        currentPos.setH(odo.getHeading(DriveValues.angularUnit));
    }

    public Pose2D getPosition() {
        update();
        return currentPos;
    }

    public void setPosition (double x, double y, double h, DistanceUnit dU, AngleUnit aU) {
        odo.setPosition(new org.firstinspires.ftc.robotcore.external.navigation.Pose2D(
                dU,
                x,
                y,
                aU,
                h
        ));
    }

    public Pose2D getLastPosition() {
        return lastPos;
    }

    /**
     * Resets the heading.
     */
    public void resetHeading() {
        odo.setHeading(0, AngleUnit.DEGREES);
    }

    /**
     * Resets the position.
     */
    public void resetPosition() {
        odo.setPosX(0, DistanceUnit.MM);
        odo.setPosY(0, DistanceUnit.MM);
        odo.setHeading(0, AngleUnit.DEGREES);
    }

    public int getLoopTime () {
        return odo.getLoopTime();
    }

    public double getFrequency () {
        return odo.getFrequency();
    }
}