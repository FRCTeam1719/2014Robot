/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

/**
 *
 * @author David
 */
public class IntakeArmAction extends Action {
    private boolean isUp;

    public IntakeArmAction(boolean isUp) {
        this.isUp = isUp;
    }
    public boolean doAct() {
        Devices.intakeArm.setArmUp(isUp);
        return true;
    }
    
}
