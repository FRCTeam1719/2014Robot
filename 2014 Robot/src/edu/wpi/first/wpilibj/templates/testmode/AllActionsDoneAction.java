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
public class AllActionsDoneAction extends Action{
//Do things that need to be done as test mode ends
    public boolean doAct() {
        boolean toReturn = false;
        
        toReturn = true;
        return toReturn;
    }
    
}
