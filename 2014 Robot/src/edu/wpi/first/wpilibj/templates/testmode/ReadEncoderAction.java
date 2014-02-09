package edu.wpi.first.wpilibj.templates.testmode;

import edu.wpi.first.wpilibj.templates.autonomous.Action;

public class ReadEncoderAction extends Action {

    String outputLabel;

    public ReadEncoderAction(String label) {
        outputLabel = label;
    }
//TODO: Thomas please explain the function of this class
    public boolean doAct() {
        boolean toReturn = false;
        toReturn = true;
        return toReturn;
    }
}
