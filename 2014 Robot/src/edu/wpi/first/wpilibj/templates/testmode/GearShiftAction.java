package edu.wpi.first.wpilibj.templates.testmode;

import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

public class GearShiftAction extends Action {

    boolean isFast;

    public GearShiftAction(boolean isFast) {
        this.isFast = isFast;
    }

    public boolean doAct() {
        Devices.gearShiftController.setFast(isFast);
        return true;
    }

}
