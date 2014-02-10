/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.testmode;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.IStep;
import edu.wpi.first.wpilibj.templates.autonomous.Chain;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.*;
/**
 *
 * @author aaroneline
 */
public class TestMode implements IStep{
    
    private boolean doneAllActs;
    private boolean doneRunDrive;
    private Chain runDrive;
    
    static double testNumber;
    
    //Constants
    private final int NO_TEST = 0;
    private final int ALL_TEST = 1;
    private final int DRIVE_TEST = 2;
    //Temporary constant for non-existant tests
    private final int NOT_A_TEST = 3;
    public void init(){
        
        
        //Create the chain for drive system actions
        runDrive = new Chain(new Action[]{
            new ReadEncoderAction("Stopped"),//Read the encoder when stopped
            new ArcadeDriveAction(0.75, 0),//Drive forward at 75% speed
            new TimerWaitAction(3),//Wait for 3 seconds
            new ReadEncoderAction("Forwards"),//Read the encoder when moving forwards
            new ArcadeDriveAction(0, 0),//Stop
            new TimerWaitAction(1),//Wait 1 sec
            new ArcadeDriveAction(-0.75, 0),//Drive backwards at 75% speed
            new TimerWaitAction(3),//Wait for 3 secs
            new ReadEncoderAction("Backwards"),//Read encoder when moving backwards
            new ArcadeDriveAction(0, 0),//Stop
            new TimerWaitAction(1),//Wait 1 sec
            new ArcadeDriveAction(0, 1),//Turn right
            new TimerWaitAction(3),//Wait 3 secs
            new ReadEncoderAction("Turning right"),//Read encoder when turning right
            new ArcadeDriveAction(0, 0),//Stop
            new TimerWaitAction(1),//Wait 1 sec
            new ArcadeDriveAction(0, -1),//Turn left
            new TimerWaitAction(3),//Wait 3 secs
            new ReadEncoderAction("Turning left"),//Read encoder when turning left
            new ArcadeDriveAction(0, 0),//Stop
            new TimerWaitAction(5),//Wait 5 secs
            new GearShiftAction(false),
            new ArcadeDriveAction(0.75, 0),
            new TimerWaitAction(5),
            new ReadEncoderAction("High Gear"),
            new ArcadeDriveAction(0.75, 0),
            new GearShiftAction(true)
        });
        doneAllActs = false;
    }
    public void step(){        
        if(!doneAllActs&&testNumber!=NO_TEST){
            if(testNumber==ALL_TEST){//Run all tests
                if(!doneRunDrive){
                    doneRunDrive = runDrive.doAct();
                }
//Replace with real code once we have more tests
//              else if(!doneSecondTest){
//                  doneSecondTest = secondTest.doAct();
//              }
//              
//              {...}
//                
//              else if(!doneFinalTest){
//                  doneAllActs = finalTest.doAct();
//              }
            }else if(testNumber==DRIVE_TEST){
                doneAllActs = runDrive.doAct();
            }else if(testNumber==NOT_A_TEST){
                //second type of test; replace with real code once we have
                //another test
                doneAllActs = true;
            }
        }
    }
    public static void setTestNumber(double number){
        testNumber = number;
    }
}
