package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Tejas on 11/9/17.
 */

public class PreScrimmageOPMode extends LinearOpMode {


    //Defining the parts of the robot
    private DcMotor frWheel;
    private DcMotor crWheel;
    private DcMotor brWheel;
    private DcMotor flWheel;
    private DcMotor clWheel;
    private DcMotor blWheel;
    private DcMotor Spool;
    private DcMotor linSlide;
    private Servo rArm;
    private Servo lAarm;
    private Servo grbWrist;
    private Servo grbHand;

    @Override
    public void runOPMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        frWheel = hardwareMap.get(DcMotor.class, "frWheel");
        flWheel = hardwareMap.get(DcMotor.class, "flWheel");
        brWheel = hardwareMap.get(DcMotor.class, "brWheel");
        blWheel = hardwareMap.get(DcMotor.class, "blWheel");

        waitForStart();

        while (opModeIsActive()){

            double left;
            double right;
            double forward;
            double backward;



        }
    }
}
