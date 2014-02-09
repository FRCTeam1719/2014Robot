package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.LogLevelCheck;
import edu.wpi.first.wpilibj.templates.autonomous.Action;


public class TimerWaitAction extends Action{
    double waitTime;
    Timer timer;
    
    /**
     * 
     * @param timeAmt time to wait in seconds
     */
    public TimerWaitAction(double timeAmt){
        timer = new Timer();
        waitTime = timeAmt;
    }
    public void init(){
        Devices.logChecker.sendLog("Waiting: "+waitTime+"s", LogLevelCheck.physical);
        timer.reset();
        timer.start();
    }
    public boolean doAct(){
        boolean done = timer.get()>waitTime;
        if(done){
            Devices.logChecker.sendLog("Done waiting", LogLevelCheck.physical);
        }
        return timer.get()>=waitTime;
    }
}
