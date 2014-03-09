package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.*;

public class UltrasonicWaitAction extends Action{
    private int targetDistance;
    private boolean waitForLessThan;
    /**
     * 
     * @param waitForLessThan If true, wait until we are close enough to the wall, otherwise wait until we are far enough
     * @param dist Target distance in sensor units
     */
    public UltrasonicWaitAction(boolean waitForLessThan, int dist){
        targetDistance = dist;
        this.waitForLessThan = waitForLessThan;//maxDist is a terrible name. I prefer waitForLessThan.
    }
    
    public void init(){
        Devices.logChecker.sendLog("Begging UltrasonicWaitAction, dist="+targetDistance+",waitForLessThan="+waitForLessThan, LogLevelCheck.physical);
    }
    
    public boolean doAct() {
        return true;
    }
}
