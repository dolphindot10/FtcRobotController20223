package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//@Disabled
@Autonomous
public class HelloWorld extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Hello", "World");
    }

    @Override
    public void loop() {

    }


    // Single line comment
    /*
    1.Hello Rohith the coder
    2.Hello vishy
    3.Hello halil
    4.Hello jeep
    5. arya changed some stuff
    6. this is me arya
    7. halils second edit
    8. Vish
    9. Checking If this is working
    10. say wallaHI bro say wallahi
     */
}
