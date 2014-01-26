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
   final public static int ENCODER_1_PWM = 2;
   final public static int ENCODER_2_PWM = 3;
   final public static int ENCODER_3_PWM = 4;
   final public static int ENCODER_4_PWM = 5;
   final public static int WHEEL_lEFT_PWM = 10;
   final public static int WHEEL_RIGHT_PWM = 8;
   final public static int GEAR_SHIFT_SOLONOID_1_PWM = 1;
   final public static int GEAR_SHIFT_SOLONOID_2_PWM = 2;
   final public static int PRESSURE_SWITCH_SLOT = 1;
   final public static int PRESSURE_SWITCH_CHANEL = 1;
   final public static int COMPRESSOR_RELAY_SLOT = 1;
   final public static int COMPRESSOR_RELAY_CHANNEL = 1;
   final public static int ULTRASONIC_PWM = 7;
   static final int CONTROLLER_1 = 1;
    
   
   
   
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
        gearShiftSolonoid.set(GEAR_SHIFT_SOLONOID_1_PWM);
        gearShiftSolonoid2.set(GEAR_SHIFT_SOLONOID_2_PWM);
        
        //other encoders 1-2
        
        //2- 3
        
        wheelEncoder1 = new NewEncoder();
        wheelEncoder1.setEncoder1(ENCODER_3_PWM);
        wheelEncoder1.setEncoder2(ENCODER_4_PWM);
        wheelEncoder1.init();
        cameraLED = new CameraLEDController(2,1);
        cameraLED.init();
        
        
        drive = new Drive().
                SetBackLeft(new Victor(WHEEL_lEFT_PWM))
                .SetBackRight(new Victor(WHEEL_RIGHT_PWM))
                .init();
        ultraSonicSensor1 = new UltrasonicSensor();
        ultraSonicSensor1.init(ULTRASONIC_PWM);
        
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
