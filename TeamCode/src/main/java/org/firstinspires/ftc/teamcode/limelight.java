package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "Limelight AprilTag", group = "OpMode")
public class limelight extends OpMode {
    private Limelight3A limelight;

    private double CAMERA_HEIGHT=0.368;
    private double CAMERA_ANGLE=0;
    private double GOAL_HEIGHT=0.45085;
    private double distance=0.508;
    private IMU imu;
    DcMotor motorOne;
    @Override
    public void init() {
        motorOne = hardwareMap.get(DcMotor.class, "driveFL");
        limelight = hardwareMap.get(Limelight3A.class,"limelight");
        limelight.pipelineSwitch(8);
        imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot revHubOrientationOnRobot = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD);
        imu.initialize(new IMU.Parameters(revHubOrientationOnRobot));

    }

    @Override
    public void start() {
        limelight.start();
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            motorOne.setPower(0.3);
        } else {
            motorOne.setPower(0.0);
        }
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        limelight.updateRobotOrientation(orientation.getYaw());
        LLResult llResult= limelight.getLatestResult();
        if (llResult != null && llResult.isValid()) {
            distance=getDistance(llResult.getTy());
            Pose3D botpose = llResult.getBotpose_MT2();
            telemetry.addData("Target X", llResult.getTx());
            telemetry.addData("Target Y", llResult.getTy());
            telemetry.addData("Target Area", llResult.getTa());
            telemetry.addData("Bot Pose", botpose.toString());
            telemetry.addData("Distance", distance);
        } else {
            telemetry.addData("No Valid Target", "Found");
        }
    }

    public double getDistance(double ty) {
        double AngleToTarget = CAMERA_ANGLE+ty;
        double heightDifference=GOAL_HEIGHT-CAMERA_HEIGHT;

        return heightDifference / Math.tan(Math.toRadians(AngleToTarget));
    }

}