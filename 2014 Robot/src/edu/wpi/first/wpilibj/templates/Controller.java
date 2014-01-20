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
        Integer transmition = (Integer) RobotTemplate.autoTransmision.getSelected();
        int t = transmition.intValue();

        if ((js1.getRawAxis(3) > 0) ) {
            
                Devices.solenoid.set(false);
            

        } else {
            if(Devices.encoder.get() > 800&&t==1){
                Devices.solenoid.set(false);
            }else{
            Devices.solenoid.set(true);
            }
        }
        //Change SendableChooser Object to an Integer, then to an int for reasions
        Integer driveModeInti = (Integer) RobotTemplate.driveMode.getSelected();
        int driveModeInt = driveModeInti.intValue();
        //Pick DriveMode

        if (driveModeInt == 1) {
            Devices.drive.moveArcade(js1.getRawAxis(2), js1.getRawAxis(1));
        }
        if (driveModeInt != 1) {
            Devices.drive.moveTank(js1.getRawAxis(2), js1.getRawAxis(5));
        }
    }
}
