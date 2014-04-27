/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.testmode;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.*;
/**
 *
 * @author Chance
 */
public class KickerAction extends Action{
    public boolean isDone = false;
   
    private boolean hasShot = false;
    public void init(){
      // Devices.shooterController.fire();
       
        
        
    }
    public boolean doAct() {
      //  Devices.shooterController.step();
     //   if(Devices.shooterController.isIdle()){
       //     isDone = true;
       // }
        return true;
    }
    
}
