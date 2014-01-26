/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

import edu.wpi.first.wpilibj.templates.autonomous.*;
/**
 *
 * @author Chance
 */
public class Devices {
   public static NewSolenoid  gearShiftSolonoid2;
   public static IStep[] devices;
   public static Drive drive;
   public static Autonomous autonomous;
   public static NewSolenoid gearShiftSolonoid;
   public static NewEncoder wheelEncoder1;
   public static UltrasonicSensor ultraSonicSensor1;
   public static CameraLEDController cameraLED;
   
   //ports
   final public static int ENCODER_1 = 2;
   final public static int ENCODER_2 = 3;
   final public static int ENCODER_3 = 4;
   final public static int ENCODER_4 = 5;
   final public static int WHEEL_lEFT = 10;
   final public static int WHEEL_RIGHT = 8;
   final public static int GEAR_SHIFT_SOLONOID_1 = 1;
   final public static int GEAR_SHIFT_SOLONOID_2 = 2;
   final public static int PRESSURE_SWITCH_SLOT = 1;
   final public static int PRESSURE_SWITCH_CHANEL = 1;
   final public static int COMPRESSOR_RELAY_SLOT = 1;
   final public static int COMPRESSOR_RELAY_CHANNEL = 1;
   final public static int ULTRASONIC = 7;
    
   
   
   
   public void step(){
        for(int i = 0; i<Devices.devices.length;i++){
            Devices.devices[i].step();
        }
    }
   
   
    public void init() {
        
        gearShiftSolonoid = new NewSolenoid();
        gearShiftSolonoid.init();
        gearShiftSolonoid2 = new NewSolenoid();
        gearShiftSolonoid2.init();
        gearShiftSolonoid.set(GEAR_SHIFT_SOLONOID_1);
        gearShiftSolonoid2.set(GEAR_SHIFT_SOLONOID_2);
        
        //other encoders 1-2
        
        //2- 3
        
        wheelEncoder1 = new NewEncoder();
        wheelEncoder1.setEncoder1(ENCODER_3);
        wheelEncoder1.setEncoder2(ENCODER_4);
        wheelEncoder1.init();
        cameraLED = new CameraLEDController(2,1);
        cameraLED.init();
        
        
        drive = new Drive().
                SetBackLeft(new Victor(WHEEL_lEFT))
                .SetBackRight(new Victor(WHEEL_RIGHT))
                .init();
        ultraSonicSensor1 = new UltrasonicSensor();
        ultraSonicSensor1.init(ULTRASONIC);
        
        CompressorController compressorController = new CompressorController();
        compressorController.init();
        
        autonomous = new Autonomous();
        devices = new IStep[]{
            drive,
            compressorController,
            wheelEncoder1,
            autonomous,
            gearShiftSolonoid,
             gearShiftSolonoid2,
            ultraSonicSensor1,
            cameraLED
        };
        //don't put anything after here
    }
}
