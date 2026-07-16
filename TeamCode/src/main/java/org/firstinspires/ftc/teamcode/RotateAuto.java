package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "RotateAuto", group = "OpMode")
public class RotateAuto extends OpMode {
    DcMotor motorFL;
    DcMotor motorFR;
    DcMotor motorRL;
    DcMotor motorRR;
    DcMotor intake;
    DcMotor geckoWheel;
    DcMotor sushiroll;
    DcMotor flywheel;

    @Override
    public void init() {
        motorFL = hardwareMap.get(DcMotor.class, "driveFL");
        motorFR = hardwareMap.get(DcMotor.class, "driveFR");
        motorRL = hardwareMap.get(DcMotor.class, "driveRL");
        motorRR = hardwareMap.get(DcMotor.class, "driveRR");
        motorFL.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRL.setDirection(DcMotorSimple.Direction.REVERSE);

        intake = hardwareMap.get(DcMotor.class, "intake");
        geckoWheel = hardwareMap.get(DcMotor.class, "gecko_wheel");
        sushiroll = hardwareMap.get(DcMotor.class, "sushi_roll");
        flywheel = hardwareMap.get(DcMotor.class, "fly_wheel");
        geckoWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        sushiroll.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        Rotate(0.5);
    }

    public void Rotate(double power){
        motorFL.setPower(-power);
        motorRL.setPower(-power);
        motorFR.setPower(power);
        motorRR.setPower(power);
    }


}


