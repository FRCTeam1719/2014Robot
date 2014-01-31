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
    private boolean isSlow = true;
      GearShiftController gearShiftController;
    

    public void init() {
        joyStick1 = new Joystick(port);
        gearShiftController = new GearShiftController();
        gearShiftController.setJoystick(joyStick1);
    }
    boolean isArcade = true;
    public Controller set(int port){
        this.port = port;
        return this;
    }
    
    public void step() {
      gearShiftController.step();
       
        
        if(js1.getRawAxis(3)!=0){
            Devices.solenoid.set(true);
            System.out.println("trigger pressed");
            Devices.logger.sendMessage("Trigger pressed");
        }else{
             Devices.solenoid.set(false);
             System.out.println("trigger off");
             Devices.logger.sendMessage("Trigger off");
        }
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
