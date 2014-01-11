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
        //Changing Varible Types
        Integer driveModeInti = (Integer) RobotTemplate.driveMode.getSelected();
        int driveModeInt = driveModeInti.intValue();
        if(driveModeInt==1){
            isArcade = true;
        }else{
            isArcade = false;
        }
        
        if (isArcade) {
            Devices.drive.moveArcade(js1.getRawAxis(2), js1.getRawAxis(1));
        }
        if (!isArcade) {
            Devices.drive.moveTank(js1.getRawAxis(2), js1.getRawAxis(5));
        }
    }
}
