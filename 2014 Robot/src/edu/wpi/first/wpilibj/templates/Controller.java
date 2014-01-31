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
    //TODO we shouldn't know about ports in this class
    int port;
    //TODO give this joystick a more descriptive name
    //      we will likely have multiple joysticks, one for the driver and one for the operator
    Joystick joyStick1;
    private boolean isSlow = true;
    //TODO do we want this as a member, or are we using the globals.
    //  This way is probably better, but we should be consistent
      GearShiftController gearShiftController;
    

    public void init() {
        joyStick1 = new Joystick(port);
        gearShiftController = new GearShiftController();
        gearShiftController.setJoystick(joyStick1);
    }
    boolean isArcade = true;
    //TODO make name more useful
    public Controller set(int port){
        this.port = port;
        return this;
    }
    
    public void step() {
      //TODO if we move gearShiftController to a global, this should be moved to the devices array
      gearShiftController.step();
       
        
        
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
