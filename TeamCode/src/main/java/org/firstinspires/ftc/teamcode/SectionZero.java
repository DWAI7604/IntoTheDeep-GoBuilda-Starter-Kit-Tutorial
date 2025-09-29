package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@TeleOp(name="Into The Deep Starter Kit, Section 0", group="Robot")
public class SectionZero extends LinearOpMode {

    public DcMotor  leftDrive   = null;
    public DcMotor  rightDrive  = null;
    public DcMotor  armMotor    = null;
    public CRServo  intake      = null;
    public Servo    wrist       = null;

    final double ARM_TICKS_PER_DEGREE =
                    28
                    * 250047.0 / 4913.0
                    * 100.0 / 20.0
                    * 1/360.0;

    final double ARM_COLLAPSED_INTO_ROBOT  = 0;
    final double ARM_COLLECT               = 250 * ARM_TICKS_PER_DEGREE;
    final double ARM_CLEAR_BARRIER         = 230 * ARM_TICKS_PER_DEGREE;
    final double ARM_SCORE_SPECIMEN        = 160 * ARM_TICKS_PER_DEGREE;
    final double ARM_SCORE_SAMPLE_IN_LOW   = 160 * ARM_TICKS_PER_DEGREE;
    final double ARM_ATTACH_HANGING_HOOK   = 120 * ARM_TICKS_PER_DEGREE;
    final double ARM_WINCH_ROBOT           = 15  * ARM_TICKS_PER_DEGREE;

    final double INTAKE_COLLECT    = -1.0;
    final double INTAKE_OFF        =  0.0;
    final double INTAKE_DEPOSIT    =  0.5;

    final double WRIST_FOLDED_IN   = 0.8333;
    final double WRIST_FOLDED_OUT  = 0.5;

    final double FUDGE_FACTOR = 15 * ARM_TICKS_PER_DEGREE;

    double armPosition = (int)ARM_COLLAPSED_INTO_ROBOT;
    double armPositionFudgeFactor;

    @Override
    public void runOpMode() {
        double leftPower;
        double rightPower;
        double forward;
        double rotate;
        double max;

        leftDrive  = hardwareMap.get(DcMotor.class, "left_front_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        armMotor   = hardwareMap.get(DcMotor.class, "left_arm");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        ((DcMotorEx) armMotor).setCurrentAlert(5,CurrentUnit.AMPS);

        armMotor.setTargetPosition(0);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        intake = hardwareMap.get(CRServo.class, "intake");
        wrist  = hardwareMap.get(Servo.class, "wrist");

        intake.setPower(INTAKE_OFF);
        wrist.setPosition(WRIST_FOLDED_IN);

        telemetry.addLine("Robot Ready.");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            forward = -gamepad1.left_stick_y;
            rotate  = gamepad1.right_stick_x;

            leftPower  = forward + rotate;
            rightPower = forward - rotate;

            max = Math.max(Math.abs(leftPower), Math.abs(rightPower));
            if (max > 1.0)
            {
                leftPower /= max;
                rightPower /= max;
            }

            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

            if (gamepad1.a) {
                intake.setPower(INTAKE_COLLECT);
            }
            else if (gamepad1.x) {
                intake.setPower(INTAKE_OFF);
            }
            else if (gamepad1.b) {
                intake.setPower(INTAKE_DEPOSIT);
            }

            if(gamepad1.right_bumper){
                armPosition = ARM_COLLECT;
                wrist.setPosition(WRIST_FOLDED_OUT);
                intake.setPower(INTAKE_COLLECT);
                }

                else if (gamepad1.left_bumper){
                    armPosition = ARM_CLEAR_BARRIER;
                }

                else if (gamepad1.y){
                    armPosition = ARM_SCORE_SAMPLE_IN_LOW;
                }

                else if (gamepad1.dpad_left) {
                    armPosition = ARM_COLLAPSED_INTO_ROBOT;
                    intake.setPower(INTAKE_OFF);
                    wrist.setPosition(WRIST_FOLDED_IN);
                }

                else if (gamepad1.dpad_right){
                    armPosition = ARM_SCORE_SPECIMEN;
                    wrist.setPosition(WRIST_FOLDED_IN);
                }

                else if (gamepad1.dpad_up){
                    armPosition = ARM_ATTACH_HANGING_HOOK;
                    intake.setPower(INTAKE_OFF);
                    wrist.setPosition(WRIST_FOLDED_IN);
                }

                else if (gamepad1.dpad_down){
                    armPosition = ARM_WINCH_ROBOT;
                    intake.setPower(INTAKE_OFF);
                    wrist.setPosition(WRIST_FOLDED_IN);
            }

            armPositionFudgeFactor = FUDGE_FACTOR * (gamepad1.right_trigger + (-gamepad1.left_trigger));

            armMotor.setTargetPosition((int) (armPosition + armPositionFudgeFactor));

            ((DcMotorEx) armMotor).setVelocity(2100);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            if (((DcMotorEx) armMotor).isOverCurrent()){
                telemetry.addLine("MOTOR EXCEEDED CURRENT LIMIT!");
            }

            telemetry.addData("armTarget: ", armMotor.getTargetPosition());
            telemetry.addData("arm Encoder: ", armMotor.getCurrentPosition());
            telemetry.update();

        }
    }
}