package org.firstinspires.ftc.teamcode.trailblazer.drivebase;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.fotmrobotics.trailblazer.PIDF;
import org.fotmrobotics.trailblazer.Vector2D;

/**
 * Edit all components here.
 * All attributes are marked as final by default under the assumption you will keep them
 * constant throughout your OpModes.
 */
public class DriveValues {
    /*
    Name of the motors in the configuration
    Control Hub:
    0. Front Left
    1. Front Right
    Expansion Hub
    TBD Back Left
    TBD Back Right
    */
    static final String[] motorNames = {
            "fLMotor",
            "fRMotor",
            "bLMotor",
            "bRMotor"
    };

    // TODO: Reverse motors if necessary.
    static final int[] reverseMotors = {
            1,
            3
            //0,
            //2
    };

    static final GoBildaPinpointDriver.EncoderDirection[]  odoDir = {
            GoBildaPinpointDriver.EncoderDirection.FORWARD,
            GoBildaPinpointDriver.EncoderDirection.REVERSED
    };

    // TODO: Tune the PIDF loops.
    static final PIDF positionPID = new PIDF(0.06, 0,0.05,0);
    static final PIDF headingPID = new PIDF(0.01, 0,0,0);

    // TODO: Change if necessary.
    // Position of the GoBildaPinpointDriver relative to the center.
    static final Vector2D offset = new Vector2D(0,0);
    static final DistanceUnit offsetUnit = DistanceUnit.MM;

    // Units
    static final public DistanceUnit linearUnit = DistanceUnit.INCH;
    static final public AngleUnit angularUnit = AngleUnit.DEGREES;

    //Type of odom pod used
    static final public GoBildaPinpointDriver.GoBildaOdometryPods podType = GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD;

    // Scale for speed.
    static final double xScale = 1;
    static final double yScale = 1;
    static final double angularScale = 0.9;
}