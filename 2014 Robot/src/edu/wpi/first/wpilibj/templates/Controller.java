/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Chance
 */
public class Controller implements IStep {

    Joystick js1;

    public void init() {
        js1 = new Joystick(1);

    }
    boolean isArcade = true;
    
    public void step() {
        
        if(js1.getRawAxis(3)!=0){
            Devices.solenoid.set(true);
            System.out.println("trigger pressed");
        }else{
             Devices.solenoid.set(false);
             System.out.println("trigger off");
        }
        //Change SendableChooser Object to an Integer, then to an int for reasions
        Integer driveModeInti = (Integer) RobotTemplate.driveMode.getSelected();
        int driveModeInt = driveModeInti.intValue();
        //Pick DriveMode
        
        if (driveModeInt==1) {
            Devices.drive.moveArcade(js1.getRawAxis(2), js1.getRawAxis(1));
        }
        if (driveModeInt!=1) {
            Devices.drive.moveTank(js1.getRawAxis(2), js1.getRawAxis(5));
        }
    }
}
