package org.firstinspires.ftc.teamcode.ftc16072.opmodes;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.WheelMotor;

@TeleOp()
public class SpinWheel extends OpMode {
    public WheelMotor wheel = new WheelMotor();

    @Override
    public void init() {
        wheel.init(hardwareMap);
    }

    @Override
    public void loop() {
        wheel.spin();
        telemetry.addData("position: ",wheel.getPosition());
        telemetry.addData("Motor position", wheel.wheelMotor.getCurrentPosition());
        telemetry.addData("button ", wheel.button.isPressed());

    }
}
