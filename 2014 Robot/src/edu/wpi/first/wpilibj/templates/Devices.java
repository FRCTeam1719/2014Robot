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

   public static IStep[] devices;
   public static Drive drive;
   public static Autonomous autonomous;
   public static NewSolenoid solenoid;
   public static NewEncoder encoder;
   public static UltrasonicSensor uss;
   
   
   public void step(){
        for(int i = 0; i<Devices.devices.length;i++){
            Devices.devices[i].step();
        }
    }
   
   
    public void init() {
        
        solenoid = new NewSolenoid();
        solenoid.init();
        encoder = new NewEncoder();
        encoder.setEncoder1(6);
        encoder.setEncoder2(7);
        encoder.init();
        
        
        drive = new Drive().
                SetBackLeft(new Victor(1))
                .SetBackRight(new Victor(2))
                .init();
        uss = new UltrasonicSensor();
        uss.init();
        
        CompressorController cc1 = new CompressorController();
        cc1.init();
        
        autonomous = new Autonomous();
        devices = new IStep[]{
            drive,
            cc1,
            encoder,
            autonomous,
            solenoid,
            uss
        };
        //don't put anything after here
    }
}
