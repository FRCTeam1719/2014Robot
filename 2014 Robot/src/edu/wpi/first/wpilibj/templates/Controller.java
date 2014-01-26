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

    Joystick joyStick1;
    private boolean isSlow = true;
    static final int CONTROLLER_1 = 1;

    public void init() {
        joyStick1 = new Joystick(CONTROLLER_1);

    }
    boolean isArcade = true;

    public void step() {
        Integer transmition = (Integer) RobotTemplate.autoTransmision.getSelected();
        int t = transmition.intValue();

        if ((joyStick1.getRawAxis(3) > 0)) {
            if (isSlow) {
                Devices.drive.stop(500);
                isSlow = false;

            }
        } else {
            if (Devices.wheelEncoder1.get() > 800 && t == 1) {
                if (isSlow) {

                    Devices.drive.stop(200);

                    isSlow = false;
                }
            } else if (Devices.wheelEncoder1.get() < 600) {
                if (!isSlow) {
                    Devices.drive.stop(200);
                    isSlow = true;
                    System.out.println("solonoid on");
                }
                if (isSlow) {
                    SmartDashboard.putString("speed", "slow");
                } else {
                    SmartDashboard.putString("speed", "fast");
                }
            }

        }
        Devices.gearShiftSolonoid.set(!isSlow);
        Devices.gearShiftSolonoid2.set(isSlow);
        
        
        //Change SendableChooser Object to an Integer, then to an int for reasions
        Integer driveModeInti = (Integer) RobotTemplate.driveMode.getSelected();
        int driveModeInt = driveModeInti.intValue();
        //Pick DriveMode

        if (driveModeInt == 1) {
            Devices.drive.moveArcade(joyStick1.getRawAxis(2), joyStick1.getRawAxis(1));
        }
        if (driveModeInt != 1) {
            Devices.drive.moveTank(joyStick1.getRawAxis(2), joyStick1.getRawAxis(5));
        }
    }
}
