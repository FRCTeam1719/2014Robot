/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.autonomous.Chain;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.ArcadeDriveAction;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.IntakeArmAction;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.ShooterAction;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.TimerWaitAction;

/**
 *
 * @author Chance
 */
public class OperatorController extends GenericController {
private boolean doneAllActs = true;
    private final boolean ARM_DOWN = false;
    private final boolean ARM_UP = true;
    private final boolean KICK_BACK = false;
    private final boolean KICK_FORWARD = true;
    private Chain run = new Chain(new Action[]{
          
            
    
            new ShooterAction(KICK_BACK, 2000), // raise the kicker
            //Out of time in auton mode
            new ShooterAction(KICK_FORWARD, 1000) // kick
        });
    //public void init(){
      //   run.init();
    //}
    public void step() {
        super.step();
         if (!doneAllActs) {
            doneAllActs = run.doAct();
        }
    }
   public void leftTriggerPressed(){
        if(!Devices.intakeArm.isUp()){
        doneAllActs = false;
        }
        
        run = new Chain(new Action[]{
          
            
            
            new ShooterAction(KICK_BACK, 2000), // raise the kicker
            //Out of time in auton mode
            new ShooterAction(KICK_FORWARD, 1000) // kick
                    
        });
   
        run.init();
        
   }
    public void rightTriggerPressed(){
  
    }
    public void triggerPressed() {
      
    }
    public void noTriggerPressed(){
   
    }
    public void bPressed() {
        Devices.intakeArm.reverseIntake();
    }

    public void yPressed() {
      
    }

    public void aPressed() {
       
    }

    public void xPressed() {
       
    }

    public void leftBumperPressed() {
        System.out.println("left bumper pressed");
        Devices.intakeArm.setArmUp(false);
        Devices.intakeArm.runIntake();
    }

    public void rightBumperPressed() {
        System.out.println("right bumber pressed");
        Devices.intakeArm.setArmUp(true);
        Devices.intakeArm.stopIntake();
    }
}
