package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TeleOp Tutorial", group = "Linear Opmode")
public class TeleOpTutorial extends LinearOpMode
{
    // Declare drive motors
    private DcMotor frWheel;
    private DcMotor flWheel;
    private DcMotor brWheel;
    private DcMotor blWheel;
    private DcMotor crWheel;
    private DcMotor clWheel;
    private DcMotor linSlide;
    private DcMotor Spool;
    private Servo rArm;
    private Servo lArm;
    private Servo grbHand;
    private Servo grbWrist;

    //Extra Values
    double left;
    double right;
    double slide;

    // Range of the Arms
    private static final double rArm_HOME = 0.0;
    private static final double rArm_RETRACTED_POSITION = 1;
    private static final double rArm_EXTENDED_POSITION = 0.65;
    private static final double lArm_HOME = 0.0;
    private static final double lArm_EXTENDED_POSITION = 0.35;
    private static final double lArm_RETRACTED_POSITION = 0.01;
    private static final double grbHand_HOME = 0.0;
    private static final double grbHand_RETRACTED_POSITION = 0.0;
    private static final double grbHand_EXTENDED_POSITION = 0.0;
    private static final double grbWrist_HOME = 0.0;
    private static final double grbWrist_EXTENDED_POSITION = 0.0;
    private static final double grbWrist_RETRACTED_POSITION = 0.0;



    public void init(HardwareMap hwMap)
    {
        // Initialize drive motors
        frWheel = hwMap.dcMotor.get("frWheel");
        flWheel = hwMap.dcMotor.get("flWheel");
        brWheel = hwMap.dcMotor.get("brWheel");
        blWheel = hwMap.dcMotor.get("blWheel");
        crWheel = hwMap.dcMotor.get("crWheel");
        clWheel = hwMap.dcMotor.get("clWheel");
        linSlide = hwMap.dcMotor.get("linSlide");
        Spool = hwMap.dcMotor.get("Spool");
        lArm = hwMap.servo.get("lArm");
        rArm = hwMap.servo.get("rArm");
        grbHand = hwMap.servo.get("grbHand");
        grbWrist = hwMap.servo.get("grbWrist");

        // Setting positions for the servos
        rArm.setPosition(rArm_HOME);
        rArm.setPosition(rArm_RETRACTED_POSITION);
        rArm.setPosition(rArm_EXTENDED_POSITION);
        lArm.setPosition(lArm_HOME);
        lArm.setPosition(lArm_RETRACTED_POSITION);
        lArm.setPosition(lArm_EXTENDED_POSITION);
        grbWrist.setPosition(grbWrist_HOME);
        grbWrist.setPosition(grbHand_RETRACTED_POSITION);
        grbWrist.setPosition(grbWrist_EXTENDED_POSITION);
        grbHand.setPosition(grbHand_HOME);
        grbHand.setPosition(grbHand_RETRACTED_POSITION);
        grbHand.setPosition(grbHand_EXTENDED_POSITION);

    }

    @Override
    public void runOpMode() throws InterruptedException
    {
        // Initilize all the variables and set necessary values for servo
        init(hardwareMap);

        // If drive motors are given full power, robot would spin because of the motors being in
        // opposite directions so reverse one
        flWheel.setDirection(DcMotor.Direction.REVERSE);
        blWheel.setDirection(DcMotor.Direction.REVERSE);
        clWheel.setDirection(DcMotor.Direction.REVERSE);
        linSlide.setDirection(DcMotor.Direction.REVERSE);
        Spool.setDirection(DcMotor.Direction.REVERSE);

        // Wait until start button is pressed
        waitForStart();

        // Repeatedly run code in here until stop button is pressed
        while(opModeIsActive())
        {
            //Tank drive
            /*
            flWheel.setPower(-gamepad1.left_stick_y);
            blWheel.setPower(-gamepad1.left_stick_y);
            clWheel.setPower(-gamepad1.right_stick_x);
            frWheel.setPower(-gamepad1.right_stick_y);
            brWheel.setPower(-gamepad1.right_stick_y);
            crWheel.setPower(gamepad1.right_stick_x);
            */

            linSlide.setPower(-gamepad2.right_stick_y);
            Spool.setPower(-gamepad1.right_trigger);
            Spool.setPower(gamepad1.left_trigger);


            // Other drive
            left = gamepad1.left_stick_y - gamepad1.right_stick_x;
            right = gamepad1.left_stick_y + gamepad1.right_stick_x;
            slide = gamepad1.left_stick_x;

            flWheel.setPower(-left);
            blWheel.setPower(-left);
            frWheel.setPower(-right);
            brWheel.setPower(-right);
            clWheel.setPower(slide);
            crWheel.setPower(-slide);


            // Servo movement
            if(gamepad1.a)
            {
                lArm.setPosition(lArm_EXTENDED_POSITION);
            }
            if(gamepad1.b)
            {
                lArm.setPosition(lArm_RETRACTED_POSITION);
            }
            if(gamepad1.x)
            {
                rArm.setPosition(rArm_EXTENDED_POSITION);
            }
            if(gamepad1.y)
            {
                rArm.setPosition(rArm_RETRACTED_POSITION);
            }
            if(gamepad2.a)
            {
                grbHand.setPosition(grbHand_EXTENDED_POSITION);
            }
            if(gamepad2.b)
            {
                grbHand.setPosition(grbHand_RETRACTED_POSITION);
            }
            if(gamepad2.x)
            {
                grbWrist.setPosition(grbWrist_EXTENDED_POSITION);
            }
            if(gamepad2.y)
            {
                grbWrist.setPosition(grbWrist_RETRACTED_POSITION);
            }

            // Give hardware a chance to catch up
            idle();
        }
    }
}