package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Auto", group = "OpMode")
public class Auto extends OpMode {
    DcMotor motorFL;
    @Override
    public void init() {
        motorFL = hardwareMap.get(DcMotor.class, "driveFL");
    }
    @Override
    public void loop() {
        motorFL.setPower(0.3);
        }
    }
