/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.testmode;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.IStep;
import edu.wpi.first.wpilibj.templates.autonomous.Chain;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.*;
import edu.wpi.first.wpilibj.templates.Constants;
import edu.wpi.first.wpilibj.templates.IntakeArm;

/**
 *
 * @author aaroneline
 */
public class TestMode implements IStep {

    private boolean doneAllActs;
    private boolean doneRunDrive;
    private boolean doneRunKicker;
    private boolean doneRunIntakeArm;
    private Chain runDrive;
    private Chain runKicker;
    private Chain runIntakeArm;
    static double testNumber;

    //Constants
    private final int NO_TEST = 0;
    private final int ALL_TEST = 1;
    private final int DRIVE_TEST = 2;
    private final int KICKER_TEST = 3;
    private final int INTAKE_TEST = 4;
   
    public void step() {
        if (!doneAllActs && testNumber != NO_TEST) {
            if (testNumber == ALL_TEST) {//Run all tests
                if (!doneRunDrive) {
                    doneRunDrive = runDrive.doAct();
                }else if(!doneRunKicker){
                    doneRunKicker = runKicker.doAct();
                }else if(!doneRunIntakeArm){
                    //Use doneAllActs for final act instead of corresponding
                    //    boolean (in this case, instead of doneRunIntakeArm)
                    doneAllActs = runIntakeArm.doAct();
                }
            } else if (testNumber == DRIVE_TEST) {
                doneAllActs = runDrive.doAct();
            } else if(testNumber == KICKER_TEST) {
                doneAllActs = runKicker.doAct();
            } else if(testNumber == INTAKE_TEST) {
                doneAllActs = runIntakeArm.doAct();
            }
        }
    }
    
    public void init() {
        TestResults acc = new TestResults();

        //Create the chain for drive system actions
        runKicker = new Chain(new Action[]{
            new KickerAction()
        });
        runIntakeArm = new Chain(new Action[]{
            new IntakeDown(),
            new TimerWaitAction(1),
            new IntakeUp()
        });
        
        
        runDrive = new Chain(new Action[]{
            new TestEncoderAction(Devices.wheelEncoder1, 0, Constants.EQUAL, "LeftWheelStopped", acc),
            new TestEncoderAction(Devices.wheelEncoder2, 0, Constants.EQUAL, "RightWheelStopped", acc),
            new ArcadeDriveAction(0.75, 0, 1500),
            new TimerWaitAction(3),//Wait
//            new TestEncoderAction("Forwards"),//Read the encoder when moving forwards
            new ArcadeDriveAction(0, 0, 1500),//Stop
            new TimerWaitAction(1),//Wait 1 sec
            new ArcadeDriveAction(-0.75, 0, 1500),//Drive backwards at 75% speed
            new TimerWaitAction(3),//Wait for 3 secs
//            new TestEncoderAction("Backwards"),//Read encoder when moving backwards
            new ArcadeDriveAction(0, 0, 1500),//Stop
            new TimerWaitAction(1),//Wait 1 sec
            new ArcadeDriveAction(0, 1, 1500),//Turn right
            new TimerWaitAction(3),//Wait 3 secs
//            new TestEncoderAction("Turning right"),//Read encoder when turning right
            new ArcadeDriveAction(0, 0, 1500),//Stop
            new TimerWaitAction(1),//Wait 1 sec
            new ArcadeDriveAction(0, -1, 1500),//Turn left
            new TimerWaitAction(3),//Wait 3 secs
//            new TestEncoderAction("Turning left"),//Read encoder when turning left
            new ArcadeDriveAction(0, 0, 1500),//Stop
            new TimerWaitAction(5),//Wait 5 secs
            new GearShiftAction(false),
            new ArcadeDriveAction(0.75, 0, 1500),
            new TimerWaitAction(5),
//            new TestEncoderAction("High Gear"),
            new ArcadeDriveAction(0.75, 0, 1500),
            new GearShiftAction(true)
        });
        doneAllActs = false;
    }
    private boolean isIntakeDown = false;
    IntakeArm intakeArm =  new IntakeArm();
    

    public static void setTestNumber(double number) {
        testNumber = number;
    }
}
