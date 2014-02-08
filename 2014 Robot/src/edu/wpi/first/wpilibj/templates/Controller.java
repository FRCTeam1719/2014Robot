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
    

    public void init() {
        joyStick1 = new Joystick(port);
    }
    boolean isArcade = true;
    public Controller set(int port){
        this.port = port;
        return this;
    }
    
    public void step() {
        //Change SendableChooser Object to an Integer, then to an int for reasions
        Integer driveModeInti = (Integer) RobotTemplate.driveMode.getSelected();
        int driveModeInt = driveModeInti.intValue();
        //Pick DriveMode

        if (driveModeInt == 1) {
            Devices.drive.moveArcade(joyStick1.getRawAxis(2), joyStick1.getRawAxis(1));
            Devices.logChecker.sendLog("Arcade mode activated",2);
        }
        if (driveModeInt != 1) {
        } else {
            Devices.drive.moveTank(joyStick1.getRawAxis(2), joyStick1.getRawAxis(5));
            Devices.logChecker.sendLog("Tank mode activated",2);
        }
        
        if(joyStick1.getRawButton(1)){
            Devices.shooterController.setReleased(true);
                    
        }else{
             Devices.shooterController.setReleased(false);
        }
        
        Devices.gearShiftController.setFast(joyStick1.getRawAxis(3)<=0);
        Devices.gearShiftController.setAutomatic(((Integer)RobotTemplate.autoTransmision.getSelected()).intValue()==1);        
    }
}
