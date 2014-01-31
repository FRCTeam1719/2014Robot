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
public class GearShiftController {
    public boolean isSlow = false;
    Joystick joyStick1;
   
    
    public void step(){
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
        
    }
    public void setJoystick(Joystick js1){
        joyStick1 = js1;
    }
    
    
    
}
