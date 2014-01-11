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
   static Controller controller;
   static NewEncoder encoder;
    public void init() {
        controller = new Controller();
        controller.init();
        encoder = new NewEncoder();
        encoder.init();
        
        
        drive = new Drive().
                SetBackLeft(new Victor(9))
                .SetBackRight(new Victor(2))
                .init();
        autonomous = new Autonomous();
        devices = new IStep[]{
            drive,
            controller,
            encoder
        };
        //don't put anything after here
    }
}
