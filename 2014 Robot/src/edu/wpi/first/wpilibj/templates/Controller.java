/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Chance
 */
public class Controller implements IStep{
    Joystick js1;
    
    public void init(){
        js1 = new Joystick(1);
        
    }
    public void step() {
             
            
                
           Devices.drive.move(-js1.getY(), -js1.getX(), js1.getRawAxis(4), 0);
         
        
           
           
           
    }
    
}