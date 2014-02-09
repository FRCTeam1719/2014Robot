package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.LogLevelCheck;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

//TODO: implement ShooterAction
public class ShooterAction extends Action{
    public ShooterAction(){
        
    }
    public void init(){
        Devices.logChecker.sendLog("ShooterAction init", LogLevelCheck.physical);
    }
    public boolean doAct(){
        return true;
    }
}
