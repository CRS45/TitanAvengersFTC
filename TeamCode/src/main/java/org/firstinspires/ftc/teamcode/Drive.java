package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Basic TeleOp", group = "OpMode")
public class Drive extends OpMode {
    DcMotor motorFL;
    DcMotor motorFR;
    DcMotor motorBL;
    DcMotor motorBR;
    DcMotor intake;
    DcMotor geckoWheel;
    DcMotor sushiroll;
    DcMotor flywheel;
    @Override
    public void init() {
        motorFL = hardwareMap.get(DcMotor.class, "driveFL");
        motorFR = hardwareMap.get(DcMotor.class, "driveFR");
        motorBL = hardwareMap.get(DcMotor.class, "driveRL");
        motorBR = hardwareMap.get(DcMotor.class, "driveRR");
        motorFL.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBL.setDirection(DcMotorSimple.Direction.REVERSE);

        intake = hardwareMap.get(DcMotor.class, "intake");
        geckoWheel = hardwareMap.get(DcMotor.class, "gecko_wheel");
        sushiroll = hardwareMap.get(DcMotor.class, "sushi_roll");
        flywheel = hardwareMap.get(DcMotor.class, "fly_wheel");
        geckoWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        sushiroll.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {
        ForwardBackward(-(gamepad1.left_stick_y));
        if (gamepad1.left_trigger>0.5) {
            intakeBall(0.5);
        } else {
            intakeBall(0);
        }
        if (gamepad1.right_trigger>0.5) {
            shootBall(0.5);
        } else {
            shootBall(0);
        }
        rotate(-(gamepad1.left_stick_x));
    }

    public void ForwardBackward(double power) {
        motorFL.setPower(power);
        motorFR.setPower(power);
        motorBL.setPower(power);
        motorBR.setPower(power);
    }

    public void intakeBall(double power) {
        intake.setPower(power);
        geckoWheel.setPower(power);
        sushiroll.setPower(power);

    }

    public void shootBall(double power) {
        flywheel.setPower(power);
    }

    public void rotate(double power) {
        motorFL.setPower(-(power));
        motorBL.setPower(-(power));
        motorBR.setPower(power);
        motorFR.setPower(power);
    }
}
