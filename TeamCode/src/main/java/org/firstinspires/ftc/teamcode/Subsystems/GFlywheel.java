package org.firstinspires.ftc.teamcode.Subsystems;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class GFlywheel {
	DcMotorEx flywheel;
	boolean state = false;
	boolean isPressed = false;


	public GFlywheel (HardwareMap hardwareMap) {
	flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
	flywheel.setDirection(DcMotorSimple.Direction.REVERSE);
	}

	public void update(Gamepad gamepad1) {
		if (!isPressed && gamepad1.a) state = !state;

		isPressed = gamepad1.a;

		if (state) flywheel.setVelocity(3000);
		else flywheel.setVelocity(0);

	}
	public void flywheelAuto (int flywheelAutoSpeed) {
		flywheel.setVelocity(flywheelAutoSpeed);
}
}
