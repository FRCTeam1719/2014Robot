/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.testmode;

import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

/**
 *
 * @author Chance
 */
public class IntakeDown extends Action {

    public boolean doAct() {
        Devices.intakeArm.setArmUp(false);
        return true;
    }
}
