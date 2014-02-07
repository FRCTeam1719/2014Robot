/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.testmode;

import edu.wpi.first.wpilibj.templates.GearShiftController;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

/**
 *
 * @author aaroneline
 */
public class GearShiftAction extends Action{
boolean isSlow;
    public GearShiftAction(boolean isSlow){
    this.isSlow = isSlow;
}
    public boolean doAct() {
        boolean toReturn = false;
        
        GearShiftController.setTestIsSlow(isSlow);
        
        
        return toReturn;
   }
    
}
