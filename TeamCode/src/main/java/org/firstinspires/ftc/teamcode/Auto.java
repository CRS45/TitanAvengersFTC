package org.firstinspires.ftc.teamcode;

import com.pedropathing.
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Auto", group = "OpMode")
public class Auto extends OpMode {
    DcMotor motorFL;
    DcMotor motorFR;
    DcMotor motorBL;
    DcMotor motorBR;
    @Override
    public void init() {
        motorFL = hardwareMap.get(DcMotor.class, "driveFL");
        motorFR = hardwareMap.get(DcMotor.class, "driveFR");
        motorBL = hardwareMap.get(DcMotor.class, "driveBL");
        motorBR = hardwareMap.get(DcMotor.class, "driveBR");
    }
    @Override
    public void loop() {
        }
    }
