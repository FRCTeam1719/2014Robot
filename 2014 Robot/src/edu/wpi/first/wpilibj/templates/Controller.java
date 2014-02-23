/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Chance
 */

public class Controller implements IStep {
    int port;
    Joystick joyStick1;
    static int driveMode;

    public void init() {
        joyStick1 = new Joystick(port);
    }
    
    
    
    boolean isArcade = true;
    public Controller set(int port){
        this.port = port;
        return this;
    }
    
    
    
    public void step() {
        
        
        //Pick DriveMode
        if (driveMode == 1) {
            Devices.drive.moveArcade(joyStick1.getRawAxis(2), joyStick1.getRawAxis(1));
            Devices.logChecker.sendLog("Arcade mode activated",LogLevelCheck.sensor);
        } else {
            Devices.drive.moveTank(joyStick1.getRawAxis(2), joyStick1.getRawAxis(5));
            Devices.logChecker.sendLog("Tank mode activated",LogLevelCheck.sensor);
        }
        if(joyStick1.getRawButton(4)){
            Devices.intakeArm.setArmUp(true);
            System.out.println("ARM UP TRUE");
            Devices.intakeArm.stopIntake();
        }
        if(joyStick1.getRawButton(3)){
            Devices.intakeArm.setArmUp(false);
            System.out.println("ARM UP FALSE");
            Devices.intakeArm.runIntake();
        }
        if(joyStick1.getRawButton(1)){
            Devices.shooterController.setMotorOn(true);
        }else{
            Devices.shooterController.setMotorOn(false);
        }
        if(joyStick1.getRawButton(2)){
            Devices.shooterController.fire();
        }else{
            Devices.shooterController.unfire();
        }
        /*
        if(joyStick1.getRawButton(1)){
            Devices.
        }
        if(joyStick1.getRawButton(2)){
            Devices.intakeArm.setArmUp(true);
        } */
        Devices.gearShiftController.setFast(joyStick1.getRawAxis(3)<=0);
        //TODO: Chance told me to comment this out, yelll at him to fix it
        // -- Aaron
        //Devices.gearShiftController.setAutomatic(((Integer)RobotTemplate.autoTransmision.getSelected()).intValue()==1);        
    }
    
    public static void setDriveMode(int number){
        driveMode = number;
    }
    
}
