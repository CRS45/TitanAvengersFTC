package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous
public class odometers extends OpMode {
    public static final Double TRIGGER_THRESHOLD=0.5;
    DcMotor motorFL;
    DcMotor motorFR;
    DcMotor motorBL;
    DcMotor motorBR;

    public void init(){
        motorFL = hardwareMap.get(DcMotor.class, "driveFL");
        motorFL.setDirection(DcMotorSimple.Direction.REVERSE);

        motorFR = hardwareMap.get(DcMotor.class, "driveFR");

        motorBL = hardwareMap.get(DcMotor.class, "driveRL");
        motorBL.setDirection(DcMotorSimple.Direction.REVERSE);

        motorBR = hardwareMap.get(DcMotor.class, "driveRR");
    }

    public void loop() {

    }
}
