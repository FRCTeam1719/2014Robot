/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Chance
 */
public class Devices {

   static IStep[] devices;
   static Drive drive;
    public void init() {
        
        
        
        drive = new Drive().
                SetFrontLeft(new Victor(1))
                .SetFrontRight(new Victor(2))
                .SetBackLeft(new Victor(9))
                .SetBackRight(new Victor(10))
                .init();
        
        devices = new IStep[]{
            
        };
        //don't put anything after here
    }
}
