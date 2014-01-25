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

    Joystick js1;
    private boolean isSlow = true;

    public void init() {
        js1 = new Joystick(1);

    }
    boolean isArcade = true;

    public void step() {
        Integer transmition = (Integer) RobotTemplate.autoTransmision.getSelected();
        int t = transmition.intValue();

        if ((js1.getRawAxis(3) > 0)) {
            if (isSlow) {
                Devices.drive.stop(500);
                isSlow = false
                        ;
                System.out.println("solonoid on");
            }
        } else {
            if (Devices.encoder.get() > 800 && t == 1) {
               if(isSlow){
                   
                Devices.drive.stop(200);
                
                isSlow = false;
               }
            } else if(Devices.encoder.get()<600) {
                if(!isSlow){
                Devices.drive.stop(200);
                isSlow = true;
                System.out.println("solonoid on");
                }
                if(isSlow){
                    SmartDashboard.putString("speed", "slow");
                }else{
                    SmartDashboard.putString("speed", "fast");
                }
            }

        }
        Devices.solenoid.set(isSlow);
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
