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

    public Controller set(int port) {
        this.port = port;
        return this;
    }

    public void step() {

        //Pick DriveMode
        if (driveMode == 1) {
            Devices.drive.moveArcade(joyStick1.getRawAxis(2), joyStick1.getRawAxis(1));
            Devices.logChecker.sendLog("Arcade mode activated", LogLevelCheck.sensor);
        } else {
            Devices.drive.moveTank(joyStick1.getRawAxis(2), joyStick1.getRawAxis(5));
            Devices.logChecker.sendLog("Tank mode activated", LogLevelCheck.sensor);
        }
        Devices.gearShiftController.setFast(joyStick1.getRawAxis(3) <= 0);
    }

    public static void setDriveMode(int number) {
        driveMode = number;
    }

}
