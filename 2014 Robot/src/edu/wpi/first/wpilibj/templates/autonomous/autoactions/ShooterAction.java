package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.LogLevelCheck;
import edu.wpi.first.wpilibj.templates.ShooterController;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

//TODO: implement ShooterAction
public class ShooterAction extends Action{
    ShooterController shooterController = Devices.shooterController;
    public void init(){
        Devices.logChecker.sendLog("ShooterAction init", LogLevelCheck.physical);
        shooterController.setDistanceBack(shooterController.DISTANCE_MEDIUM);
        shooterController.fire();
    }
    public boolean doAct(){
        shooterController.step();
        return shooterController.isIdle();
    }
}
