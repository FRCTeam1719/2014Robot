package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.LogLevelCheck;
import edu.wpi.first.wpilibj.templates.ShooterController;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

//TODO: implement ShooterAction
public class ShooterAction extends Action{
    private boolean isGoingUp;
    private long milliseconds;
    private long startTime;
    
    public ShooterAction(boolean isGoingUp, long milliseconds) {
        this.isGoingUp = isGoingUp;
        this.milliseconds = milliseconds;
    }
    
    
     ShooterController shooterController;
    public void init(){
        startTime = System.currentTimeMillis();
        shooterController = Devices.shooterController;
       
    }
    public boolean doAct(){
        if(isGoingUp){
            shooterController.back();
        } else {
            shooterController.forward();
        }
        if (System.currentTimeMillis() > (startTime + milliseconds)){
            shooterController.stop();
            return true;
        }
        return false;
    }
}
