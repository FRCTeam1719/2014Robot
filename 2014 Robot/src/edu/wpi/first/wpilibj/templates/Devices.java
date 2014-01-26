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
   final private static int ENCODER_1_PWM = 2;
   final private static int ENCODER_2_PWM = 3;
   final private static int ENCODER_3_PWM = 4;
   final private static int ENCODER_4_PWM = 5;
   final private static int WHEEL_lEFT_PWM = 10;
   final private static int WHEEL_RIGHT_PWM = 8;
   final private static int GEAR_SHIFT_SOLONOID_1_PWM = 1;
   final private static int GEAR_SHIFT_SOLONOID_2_PWM = 2;
   final private static int PRESSURE_SWITCH_SLOT = 1;
   final private static int PRESSURE_SWITCH_CHANEL = 1;
   final private static int COMPRESSOR_RELAY_SLOT = 1;
   final private static int COMPRESSOR_RELAY_CHANNEL = 1;
   final private static int ULTRASONIC_PWM = 7;
   final private static int CONTROLLER_1 = 1;
    
   
   
   
   public void step(){
        for(int i = 0; i<Devices.devices.length;i++){
            Devices.devices[i].step();
        }
    }
   
   
    public void init() {
        //make gear shift solonoids
        gearShiftSolonoid = new NewSolenoid();
        gearShiftSolonoid.init();
        gearShiftSolonoid2 = new NewSolenoid();
        gearShiftSolonoid2.init();
        gearShiftSolonoid.set(GEAR_SHIFT_SOLONOID_1_PWM);
        gearShiftSolonoid2.set(GEAR_SHIFT_SOLONOID_2_PWM);
        
        //other encoders 1-2
        //2- 3
        //make wheel encoders
        wheelEncoder1 = new NewEncoder();
        wheelEncoder1.setEncoder1(ENCODER_3_PWM);
        wheelEncoder1.setEncoder2(ENCODER_4_PWM);
        wheelEncoder1.init();
        
        //make camera
        cameraLED = new CameraLEDController(2,1);
        cameraLED.init();
        
        //make drive
        drive = new Drive().
                SetBackLeft(new Victor(WHEEL_lEFT_PWM))
                .SetBackRight(new Victor(WHEEL_RIGHT_PWM))
                .init();
        //make ultrasonic sensor
        ultraSonicSensor1 = new UltrasonicSensor();
        ultraSonicSensor1
                .setSlot(ULTRASONIC_PWM)
                .init();
        
        //make compressor
        CompressorController compressorController = new CompressorController();
        compressorController
                .setCompressorRelayChannel(COMPRESSOR_RELAY_CHANNEL)
                .setCompressorRelaySlot(COMPRESSOR_RELAY_SLOT)
                .setPressureSwitchChannel(PRESSURE_SWITCH_SLOT)
                .setPressureSwitchSlot(PRESSURE_SWITCH_SLOT)
                .init();
        //make autonomous
        autonomous = new Autonomous();
        
        //devices array
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
