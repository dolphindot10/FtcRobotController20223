package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.hardware.limelightvision.LLFieldMap;
import com.qualcomm.hardware.limelightvision.LLFieldMap.Fiducial;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.limelightvision.LLResultTypes.FiducialResult;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.List;

@TeleOp(name="Limelight test 3")
public class LLT3 extends OpMode {

    private Limelight3A limelight;

    @Override
    public void init() {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(100); // how often limelight is asked for data
        limelight.start(); // Starts limelight
        limelight.pipelineSwitch(6); // Switch to pipeline number for april tags (in this case its 6)
    }

    @Override
    public void loop() {
        LLResult result = limelight.getLatestResult();

        if (result != null && result.isValid()) {
            List<FiducialResult> tags= result.getFiducialResults();

            if (tags.size() > 0) {
                FiducialResult tag = tags.get(0); // first detected tag

                int id = tag.getFiducialId();
                double area = tag.getTargetArea();
                double tx = tag.getTargetXDegrees();
                double ty = tag.getTargetYDegrees();

                telemetry.addData("Tag ID", id);
                telemetry.addData("Area", area);
                telemetry.addData("tx", tx);
                telemetry.addData("ty", ty);
                telemetry.addData("target pose", tag.getTargetPoseCameraSpace());
            }
            else {
                telemetry.addLine("No AprilTags detected");
            }
        }
        else{
            telemetry.addLine("Limelight: No valid result");
        }
        telemetry.update();
    }
}