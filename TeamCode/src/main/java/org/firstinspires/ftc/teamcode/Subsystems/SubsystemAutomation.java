package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SubsystemAutomation {

	GoBildaPinpointDriver pinpoint;

	public SubsystemAutomation(HardwareMap hardwareMap) {

		pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "odo");

	}

	public void update() {

	}
}
