/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.autonomous.*;
/**
 *
 * @author Chance
 */
public class Devices {

   static IStep[] devices;
   static Drive drive;
   static Autonomous autonomous;
  
   static NewEncoder encoder;
   
   
   public void step(){
        for(int i = 0; i<Devices.devices.length;i++){
            Devices.devices[i].step();
        }
    }
   
   
    public void init() {
        
        
        encoder = new NewEncoder();
        encoder.init();
        
        
        drive = new Drive().
                SetBackLeft(new Victor(9))
                .SetBackRight(new Victor(2))
                .init();
        autonomous = new Autonomous();
        devices = new IStep[]{
            drive,
            encoder
        };
        //don't put anything after here
    }
}
