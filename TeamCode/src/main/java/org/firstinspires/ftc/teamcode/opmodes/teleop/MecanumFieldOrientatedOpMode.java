package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class MecanumFieldOrientatedOpMode extends OpMode {

    newMecanumDrive drive = new newMecanumDrive();

    double forward, strafe, rotate;

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = -gamepad1.left_stick_x;
        rotate = -gamepad1.right_stick_x;

        if (gamepad1.dpad_up) {
            drive.driveFieldRelative(-1.0, 0, 0);
        }
        else if (gamepad1.dpad_down) {
            drive.driveFieldRelative(1.0, 0, 0);
        }
        else {
            drive.driveFieldRelative(forward, strafe, rotate);
        }

        if (gamepad1.a){
            drive.resetYaw();
        }



    }
}
