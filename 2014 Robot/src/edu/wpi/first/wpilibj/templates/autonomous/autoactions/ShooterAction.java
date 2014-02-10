package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.LogLevelCheck;
import edu.wpi.first.wpilibj.templates.ShooterController;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

//TODO: implement ShooterAction
public class ShooterAction extends Action{
    ShooterController shooterController;
    public ShooterAction(int motorPort, int potentiometerPort, int solenoidPort,
            double point){
        shooterController.setMotorPort(motorPort);
        shooterController.setPotentiometerPort(potentiometerPort);
        shooterController.setSolonoidPort(solenoidPort);
        shooterController.setPoint(point);
        shooterController.init();
    }
    public void init(){
        Devices.logChecker.sendLog("ShooterAction init", LogLevelCheck.physical);
    }
    public boolean doAct(){
        shooterController.step();
        return true;
    }
}
