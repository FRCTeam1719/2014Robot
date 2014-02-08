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
    public boolean isSlow = true;
    Joystick joyStick1;
    private static boolean isTest;
    private static boolean testIsSlow;
    
    public void step(){
         Integer transmition = (Integer) RobotTemplate.autoTransmision.getSelected();
         //TODO do we do anything with this
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
                
            } else if ((t==1 && Devices.wheelEncoder1.get() < 600 )|| (t==2 && joyStick1.getRawAxis(3)<=0)) {
                if (!isSlow) {
                    Devices.drive.stop(200);
                    isSlow = true;
                }
                if (isSlow) {
                } else {
                    SmartDashboard.putString("speed", "fast");
                }
            }

        }
        if(isTest){
            isSlow = testIsSlow;
        }
        Devices.gearShiftSolonoid.set(!isSlow);
        Devices.gearShiftSolonoid2.set(isSlow);
        
    }
    public void setJoystick(Joystick js1){
        joyStick1 = js1;
    }
    
    static public void setIsTest(boolean nIsTest){
         isTest = nIsTest;
    }
    static public void setTestIsSlow(boolean nTestIsSlow){
        testIsSlow = nTestIsSlow;
    }
    
}
