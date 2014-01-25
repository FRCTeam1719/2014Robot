/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;
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
   public static NewSolenoid gearShiftSolonoid;
   public static NewEncoder wheelEncoder1;
   public static UltrasonicSensor ultraSonicSensor1;
   public static CameraLEDController cameraLED;
   
   
   public void step(){
        for(int i = 0; i<Devices.devices.length;i++){
            Devices.devices[i].step();
        }
    }
   
   
    public void init() {
        
        gearShiftSolonoid = new NewSolenoid();
        gearShiftSolonoid.init();
        wheelEncoder1 = new NewEncoder();
        wheelEncoder1.setEncoder1(6);
        wheelEncoder1.setEncoder2(7);
        wheelEncoder1.init();
        cameraLED = new CameraLEDController(2,1);
        cameraLED.init();
        
        drive = new Drive().
                SetBackLeft(new Victor(1))
                .SetBackRight(new Victor(2))
                .init();
        ultraSonicSensor1 = new UltrasonicSensor();
        ultraSonicSensor1.init(7);
        
        CompressorController compressorController = new CompressorController();
        compressorController.init();
        
        autonomous = new Autonomous();
        devices = new IStep[]{
            drive,
            compressorController,
            wheelEncoder1,
            autonomous,
            gearShiftSolonoid,
            ultraSonicSensor1,
            cameraLED
        };
        //don't put anything after here
    }
}
