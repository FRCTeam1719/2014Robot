/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.autonomous.*;
import edu.wpi.first.wpilibj.templates.testmode.TestMode;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author Chance
 */

public class Devices {
    public static OperatorController operatorController;
    public static IStep[] devices;
    public static Drive drive;
    public static Autonomous autonomous;
    public static TestMode testMode;
    public static NewSolenoid gearShiftSolonoid;
    public static NewEncoder wheelEncoder1;
    public static NewEncoder wheelEncoder2;
    public static GearShiftController gearShiftController;
    public static UltrasonicSensor ultraSonicSensor1;
    public static CameraLEDController cameraLED;
    public static ShooterController shooterController;
    public static IntakeArm intakeArm;
    public static SmartDashboardReader smartDashboardReader;
    public static Gyro gyro;
    static Log logger = new Log();
    public static LogLevelCheck logChecker = new LogLevelCheck();
    public static int PRESSURE_SWITCH_SLOT = 1;
    public static int PRESSURE_SWITCH_DIO = 1;
    public static int RIGHT_ENCODER_A_DIO = 4;
    public static int RIGHT_ENCODER_B_DIO = 5;
    public static int LEFT_ENCODER_A_DIO = 2;
    public static int LEFT_ENCODER_B_DIO = 3;
    public static int INTAKE_ARM_MOTOR_PORT = 4;
    public static int INTAKE_SOLENOID_PORT = 2;
    public static int WHEEL_lEFT_PWM = 2;
    public static int WHEEL_RIGHT_PWM = 5;
    public static int GEAR_SHIFT_SOLONOID_A_SOL = 1;
    public static int GEAR_SHIFT_SOLONOID_B_SOL = 8;//TODO we do not use this
    public static int COMPRESSOR_RELAY_SLOT = 1;
    public static int COMPRESSOR_REL = 1;
    public static int ULTRASONIC_ANG = 7;
    public static int CONTROLLER_1 = 1;
    public static int SELECTED_ROBOT;
    public static int SHOOTER_MOTOR_PORT = 3;
    public static int SHOOTER_SOLONOID_PORT = 3;
    public static int SHOOTER_POTENTIOMETER_PORT = 1;
    public static int GYRO_SLOT = 1;
    public static int GYRO_CHANNEL = 2;
    
    
    public void step() {
        for (int i = 0; i < Devices.devices.length; i++) {
            Devices.devices[i].step();
        }

    }

    
    
    public void init() {
        gyro = new Gyro(GYRO_SLOT, GYRO_CHANNEL);
        operatorController = new OperatorController();
        operatorController.setNumber(2);
        operatorController.init();
        testMode = new TestMode();
        autonomous = new Autonomous();
        
        smartDashboardReader = new SmartDashboardReader();
        smartDashboardReader.init();
        
        shooterController = new ShooterController();
        shooterController.setPort(SHOOTER_MOTOR_PORT);
       
         shooterController.init();

        
        intakeArm = new IntakeArm();
        intakeArm.setMotorPort(INTAKE_ARM_MOTOR_PORT);
        intakeArm.setSolenoidPort(INTAKE_SOLENOID_PORT);
        intakeArm.init();
        
        
        
        
        
     
        
        gearShiftSolonoid = new NewSolenoid()
                .setPort(GEAR_SHIFT_SOLONOID_A_SOL)
                //.setSecondaryPort(GEAR_SHIFT_SOLONOID_B_SOL)
                .init();

        
        
        wheelEncoder1 = new NewEncoder()
                .setEncoderAChannelPort(LEFT_ENCODER_A_DIO)
                .setEncoderBChannelPort(LEFT_ENCODER_B_DIO)
                .init();
        


        
        wheelEncoder2 = new NewEncoder()
                .setEncoderAChannelPort(RIGHT_ENCODER_A_DIO)
                .setEncoderBChannelPort(RIGHT_ENCODER_B_DIO)
                .init();

        
        
        gearShiftController = new GearShiftController()
                .setLeftEncoder(wheelEncoder1)
                .setRightEncoder(wheelEncoder2)
                .setSolenoid(gearShiftSolonoid)
                .init();

        
        
        //Make camera
        cameraLED = new CameraLEDController(2, 1);
        cameraLED.init();

        
        
        //Make drive
        drive = new Drive().
                SetBackLeft(new Talon(WHEEL_lEFT_PWM))
                .SetBackRight(new Talon(WHEEL_RIGHT_PWM))
                .init();
        
        
        
        //Make ultrasonic sensor
        ultraSonicSensor1 = new UltrasonicSensor();
        ultraSonicSensor1
                .setSlot(ULTRASONIC_ANG)
                .init();

        
        
        //Make compressor
        CompressorController compressorController = new CompressorController();
        compressorController
                .setCompressorRelayChannel(COMPRESSOR_REL)
                .setCompressorRelaySlot(COMPRESSOR_RELAY_SLOT)
                .setPressureSwitchChannel(PRESSURE_SWITCH_DIO)
                .setPressureSwitchSlot(PRESSURE_SWITCH_SLOT)
                .init();

        
        
        //Devices array
        devices = new IStep[]{
            drive,
            smartDashboardReader,
            compressorController,
            wheelEncoder1,
            wheelEncoder2,
            gearShiftSolonoid,
            ultraSonicSensor1,
            cameraLED,
            logger,
            shooterController,
            gearShiftController,
//            operatorController,
            intakeArm
        };
        //Don't put anything after here
    }
    public static void setSelectedRobot(int selectedRobot){
        SELECTED_ROBOT = selectedRobot;
    }
}
