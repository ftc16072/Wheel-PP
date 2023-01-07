package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;


import java.util.List;

abstract public class Mechanism {
    public abstract void init(HardwareMap hwMap);

    public String toString() {
        return this.getClass().getSimpleName();
    }

}
