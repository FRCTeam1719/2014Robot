package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.*;

public class UltrasonicWaitAction extends Action{
    private int targetDistance;
    private boolean maxDist;
    /**
     * 
     * @param waitForLessThan If true, wait until we are close enough to the wall, otherwise wait until we are far enough
     * @param dist Target distance in sensor units
     */
    public UltrasonicWaitAction(boolean waitForLessThan, int dist){
        targetDistance = dist;
        maxDist = waitForLessThan;
    }
    
    public void init(){
        Devices.logChecker.sendLog("Begging UltrasonicWaitAction, dist="+targetDistance+",waitForLessThan="+maxDist, LogLevelCheck.physical);
    }
    
    public boolean doAct() {
        int distance=Devices.ultraSonicSensor1.getValue();
        boolean done = distance<targetDistance;
        if(!maxDist){
            done = !done;
        }
        if(done){
            Devices.logChecker.sendLog("Done ultrasonicWaitAction", LogLevelCheck.physical);
        }
        return done;
    }
}
