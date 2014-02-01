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
    //TODO unused variables
    public static NewSolenoid gearShiftSolonoid2;
    public static IStep[] devices;
    public static Drive drive;
    public static Autonomous autonomous;
    public static NewSolenoid gearShiftSolonoid;
    public static NewEncoder wheelEncoder1;
    public static UltrasonicSensor ultraSonicSensor1;
    public static CameraLEDController cameraLED;
    static Log logger = new Log();
    Integer selectedRobot = (Integer) RobotTemplate.robot.getSelected();
    //ports
    private static int ENCODER_1_PWM = 2;
    private static int ENCODER_2_PWM = 3;
    private static int ENCODER_3_PWM = 4;
    private static int ENCODER_4_PWM = 5;
    private static int WHEEL_lEFT_PWM = 10;
    private static int WHEEL_RIGHT_PWM = 8;
    private static int GEAR_SHIFT_SOLONOID_1_PWM = 1;
    private static int GEAR_SHIFT_SOLONOID_2_PWM = 2;
    private static int PRESSURE_SWITCH_SLOT = 1;
    private static int PRESSURE_SWITCH_CHANEL = 1;
    private static int COMPRESSOR_RELAY_SLOT = 1;
    private static int COMPRESSOR_RELAY_CHANNEL = 1;
    private static int ULTRASONIC_PWM = 7;
    private static int CONTROLLER_1 = 1;
    //TODO this gave me a null pointer
//    Integer selectedRobot = (Integer) RobotTemplate.robot.getSelected();

    //TODO move to init
    int sri = selectedRobot.intValue();

    public void step() {
        for (int i = 0; i < Devices.devices.length; i++) {
            //System.out.println(i);
            Devices.devices[i].step();
        }
    }

    public void init() {
        //TODO which robot do these go to
        //TODO should we arrange these by module? 
        if (sri == 1) {
            ENCODER_1_PWM = 2;
            ENCODER_2_PWM = 3;
            ENCODER_3_PWM = 4;
            ENCODER_4_PWM = 5;
            WHEEL_lEFT_PWM = 10;
            WHEEL_RIGHT_PWM = 8;
            GEAR_SHIFT_SOLONOID_1_PWM = 1;
            GEAR_SHIFT_SOLONOID_2_PWM = 2;
            PRESSURE_SWITCH_SLOT = 1;
            PRESSURE_SWITCH_CHANEL = 1;
            COMPRESSOR_RELAY_SLOT = 1;
            COMPRESSOR_RELAY_CHANNEL = 1;
            ULTRASONIC_PWM = 7;
            CONTROLLER_1 = 1;

        }else if(sri == 2){
            ENCODER_1_PWM = 2;
            ENCODER_2_PWM = 3;
            ENCODER_3_PWM = 4;
            ENCODER_4_PWM = 5;
            WHEEL_lEFT_PWM = 10;
            WHEEL_RIGHT_PWM = 8;
            GEAR_SHIFT_SOLONOID_1_PWM = 1;
            GEAR_SHIFT_SOLONOID_2_PWM = 2;
            PRESSURE_SWITCH_SLOT = 1;
            PRESSURE_SWITCH_CHANEL = 1;
            COMPRESSOR_RELAY_SLOT = 1;
            COMPRESSOR_RELAY_CHANNEL = 1;
            ULTRASONIC_PWM = 7;
            CONTROLLER_1 = 1;
        }else if(sri == 3){
                ENCODER_1_PWM = 2;
            ENCODER_2_PWM = 3;
            ENCODER_3_PWM = 4;
            ENCODER_4_PWM = 5;
            WHEEL_lEFT_PWM = 10;
            WHEEL_RIGHT_PWM = 8;
            GEAR_SHIFT_SOLONOID_1_PWM = 1;
            GEAR_SHIFT_SOLONOID_2_PWM = 2;
            PRESSURE_SWITCH_SLOT = 1;
            PRESSURE_SWITCH_CHANEL = 1;
            COMPRESSOR_RELAY_SLOT = 1;
            COMPRESSOR_RELAY_CHANNEL = 1;
            ULTRASONIC_PWM = 7;
            CONTROLLER_1 = 1;
        }
        
        //TODO make these constructions follow a consistent format
        
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
        cameraLED = new CameraLEDController(2, 1);
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
            cameraLED,
            logger
        };
        //don't put anything after here
    }
}
