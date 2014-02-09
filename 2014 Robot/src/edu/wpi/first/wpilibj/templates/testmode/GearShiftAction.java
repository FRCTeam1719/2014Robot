/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.testmode;

import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.GearShiftController;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
//TODO: IMPORTANT currently the testIsFast verible seems to have gone missing
//We need to reimpliment this. 
/**
 *
 * @author aaroneline
 */
public class GearShiftAction extends Action{
boolean isFast;
    public GearShiftAction(boolean isFast){
    this.isFast = isFast;
}
    public boolean doAct() {
        boolean toReturn = false;
        Devices.gearShiftController.setFast(isFast);
        toReturn = true;
        return toReturn;
   }
    
}
