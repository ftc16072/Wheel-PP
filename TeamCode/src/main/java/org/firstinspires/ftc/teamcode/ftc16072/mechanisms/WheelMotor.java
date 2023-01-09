package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class WheelMotor extends Mechanism {
    public DcMotor wheelMotor;
    public TouchSensor button;
    private static int currentSpin;
    private final static int WHEEL_ROTATION = 1160  ;
    private final static int SLICE = 1160 / 6 ;
    private final static int OUTREACH = (WHEEL_ROTATION * 2) ;
    private final static int TEAM_PLAN =(WHEEL_ROTATION * 4) + SLICE ;
    private final static int DESIGN_PROCESS = (WHEEL_ROTATION * 6) + 2*SLICE ;
    private final static int EXPERTS = (WHEEL_ROTATION * 8) + 3 * SLICE ;
    private final static int CONTROL_CODE = (WHEEL_ROTATION * 10) + 4 * SLICE ;
    private final static int GOALS = (WHEEL_ROTATION * 12) + 5 *SLICE  ;

    boolean isPressed;

    @Override
    public void init(HardwareMap hwMap) {
        wheelMotor = hwMap.get(DcMotor.class, "wheelMotor");
        button = hwMap.get(TouchSensor.class, "button");
        wheelMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        currentSpin=0;
    }

    public void spin() {
        if (position()==1) {
            wheelMotor.setTargetPosition(OUTREACH);
            wheelMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheelMotor.setPower(.2);
        }else if (position()==2) {
            wheelMotor.setTargetPosition(TEAM_PLAN);
            wheelMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheelMotor.setPower(.2);
        }else if (position()==3) {
            wheelMotor.setTargetPosition(DESIGN_PROCESS);
            wheelMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheelMotor.setPower(.2);
        }else if (position()==4) {
            wheelMotor.setTargetPosition(EXPERTS);
            wheelMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheelMotor.setPower(.2);
        }else if (position()==5) {
            wheelMotor.setTargetPosition(CONTROL_CODE);
            wheelMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheelMotor.setPower(.2);
        }else if (position()==6) {
            wheelMotor.setTargetPosition(GOALS);
            wheelMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheelMotor.setPower(.2);
        }else {
            wheelMotor.setPower(0);
        }

    }

    public int position() {
        if (button.isPressed() && !isPressed) {
            currentSpin++;
        }
        isPressed= button.isPressed();
        return currentSpin;
    }
    public int getPosition(){
        return currentSpin;
    }
}
