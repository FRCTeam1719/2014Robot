package edu.wpi.first.wpilibj.templates.autonomous;

import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.LogLevelCheck;

/**
 * This class provides a basic way to combine actions into more complicated
 * ones, by running them in sequence
 */
public class Chain extends Action {

    Action[] actions;
    boolean done = false;
    int index = 0;

    public Chain(Action[] acts) {
        actions = acts;
    }

    public void init() {
        index = 0;
        if(actions.length>0){
            actions[0].init();
        }
    }

    public boolean doAct() {
        if (actions.length > index) {
            if (actions[index].doAct()) {
                index++;
                if (index != actions.length) {
                    actions[index].init();
                } else {
                    done = true;
                }
                Devices.logChecker.sendLog("Action #" + index + " is done", LogLevelCheck.sensor);
            }
            return done;
        } else {
            return true;
        }
    }
}
