package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.LogLevelCheck;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

/**
 * Waits for the SmartDashboard to indicate that we have found the hot-goal
 * Will timeout after 9 seconds if we have not found the hot-goal
 */
public class HotGoalWaitAction extends Action{
    Timer timer;
    
    public HotGoalWaitAction(){
        timer = new Timer();
        timer.reset();
        timer.start();
    }
    
    public void init(){
        SmartDashboard.putBoolean("found", false);
        Devices.logChecker.sendLog("Beggining HotGoalWaitAction", LogLevelCheck.physical);
    }
    
    /**
     * @return We found the target, or are timing out
     */
    public boolean doAct() {
        boolean found = SmartDashboard.getBoolean("found");
        boolean timeout = timer.get()>=2;
        if(found){
            Devices.logChecker.sendLog("Found hotgoal", LogLevelCheck.physical);
        }
        if (timeout){
            Devices.logChecker.sendLog("Hotgoal action timeout", LogLevelCheck.physical);
        }
        return found || timeout;
    }
}
