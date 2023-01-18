package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class WheelMotor extends Mechanism {
    public DcMotor wheelMotor;
    public TouchSensor button;
    private static int currentSpin;
    private final static int WHEEL_ROTATION = 1120   ;
    private final static int SLICE = WHEEL_ROTATION / 6 ;
    private final static int OUTREACH = 937 + WHEEL_ROTATION ;
    private final static int TEAM_PLAN =0 + WHEEL_ROTATION  ;
    private final static int DESIGN_PROCESS = 2541 +  WHEEL_ROTATION;
    private final static int EXPERTS = 379 + WHEEL_ROTATION ;
    private final static int CONTROL_CODE = 2855 + WHEEL_ROTATION ;
    private final static int GOALS = 1897 + WHEEL_ROTATION  ;

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
            wheelMotor.setTargetPosition(TEAM_PLAN);
            wheelMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheelMotor.setPower(.2);
        }else if (position()==2) {
            wheelMotor.setTargetPosition(EXPERTS);
            wheelMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheelMotor.setPower(.2);

        }else if (position()==3) {
            wheelMotor.setTargetPosition(OUTREACH);
            wheelMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheelMotor.setPower(.2);
        }else if (position()==4) {
            wheelMotor.setTargetPosition(GOALS);
            wheelMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheelMotor.setPower(.2);
        }else if (position()==5) {
            wheelMotor.setTargetPosition(DESIGN_PROCESS);
            wheelMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheelMotor.setPower(.2);
        }else if (position()==6) {
            wheelMotor.setTargetPosition(CONTROL_CODE);
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
