/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.testmode;
import edu.wpi.first.wpilibj.templates.RobotTemplate;
import edu.wpi.first.wpilibj.templates.autonomous.Chain;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.*;
/**
 *
 * @author aaroneline
 */
public class TestMode {
    
    
    private Chain runDrive;
    public void init(){
        
        Integer testModeInti = (Integer) RobotTemplate.testMode.getSelected();
        int testModeInt = testModeInti.intValue();
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
            new GearShiftAction(true),
            new AllActionsDoneAction()
        });
        
    }
}
