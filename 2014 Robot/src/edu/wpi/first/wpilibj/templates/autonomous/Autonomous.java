package edu.wpi.first.wpilibj.templates.autonomous;

import edu.wpi.first.wpilibj.templates.IStep;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.*;

public class Autonomous implements IStep{
    public Autonomous(){
        
    }
    private Chain run;
    private boolean doneAllActs;
    public void init(){
        run = new Chain(new Action[]{
//            new ArcadeDriveAction(0.75,0.0),
//            new UltrasonicWaitAction(true, 300),
//            new ArcadeDriveAction(0.0,0.0),
            new HotGoalWaitAction(),
//            new ShooterAction()
        });
        doneAllActs = false;
        run.init();
    }
    public void stop(){
        doneAllActs = true;
    }
    public void step(){
        if(!doneAllActs){
            doneAllActs = run.doAct();
        }
    }
}
