/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.autonomous.*;
import edu.wpi.first.wpilibj.templates.testmode.TestMode;

/**
 *
 * @author Chance
 */

public class Devices {

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
    static Log logger = new Log();
    public static LogLevelCheck logChecker = new LogLevelCheck();
    private static int PRESSURE_SWITCH_SLOT = 1;
    private static int PRESSURE_SWITCH_DIO = 1;
    private static int RIGHT_ENCODER_A_DIO = 2;
    private static int RIGHT_ENCODER_B_DIO = 3;
    private static int LEFT_ENCODER_A_DIO = 4;
    private static int LEFT_ENCODER_B_DIO = 5;
    private static int INTAKE_ARM_MOTOR_PORT = 4;
    private static int INTAKE_POTENTIOMETER_PORT = 2;
    private static int WHEEL_lEFT_PWM = 10;
    private static int WHEEL_RIGHT_PWM = 8;
    private static int GEAR_SHIFT_SOLONOID_A_SOL = 1;
    private static int GEAR_SHIFT_SOLONOID_B_SOL = 2;
    private static int COMPRESSOR_RELAY_SLOT = 1;
    private static int COMPRESSOR_REL = 1;
    private static int ULTRASONIC_ANG = 7;
    private static int CONTROLLER_1 = 1;

    int foo = 0;
    private static int SHOOTER_MOTOR_PORT = 2;
    private static int SHOOTER_SOLONOID_PORT = 4;
    private static int SHOOTER_POTENTIOMETER_PORT = 3;

    
    
    public void step() {
        for (int i = 0; i < Devices.devices.length; i++) {
            Devices.devices[i].step();
        }

    }

    
    
    public void init() {
        testMode = new TestMode();

        
        
        shooterController = new ShooterController();
        shooterController.setMotorPort(SHOOTER_MOTOR_PORT);
        shooterController.setPotentiometerPort(SHOOTER_POTENTIOMETER_PORT);
        shooterController.setSolonoidPort(SHOOTER_SOLONOID_PORT);
        shooterController.init();

        
        intakeArm = new IntakeArm();
        intakeArm.setMotorPort(INTAKE_ARM_MOTOR_PORT);
        intakeArm.setPotentiometerPort(INTAKE_POTENTIOMETER_PORT);
        

        
        Integer selectedRobot = (Integer) RobotTemplate.robot.getSelected();
        
        int sri = selectedRobot.intValue();
        
        if (sri == 1) {
            RIGHT_ENCODER_A_DIO = 2;
            RIGHT_ENCODER_B_DIO = 3;
            LEFT_ENCODER_A_DIO = 4;
            LEFT_ENCODER_B_DIO = 5;
            WHEEL_lEFT_PWM = 10;
            WHEEL_RIGHT_PWM = 8;
            GEAR_SHIFT_SOLONOID_A_SOL = 1;
            GEAR_SHIFT_SOLONOID_B_SOL = 2;
            PRESSURE_SWITCH_SLOT = 1;
            PRESSURE_SWITCH_DIO = 1;
            COMPRESSOR_RELAY_SLOT = 1;
            COMPRESSOR_REL = 1;
            ULTRASONIC_ANG = 7;
            CONTROLLER_1 = 1;
        } else if (sri == 2) {
            RIGHT_ENCODER_A_DIO = 2;
            RIGHT_ENCODER_B_DIO = 3;
            LEFT_ENCODER_A_DIO = 4;
            LEFT_ENCODER_B_DIO = 5;
            WHEEL_lEFT_PWM = 10;
            WHEEL_RIGHT_PWM = 8;
            GEAR_SHIFT_SOLONOID_A_SOL = 1;
            GEAR_SHIFT_SOLONOID_B_SOL = 2;
            PRESSURE_SWITCH_SLOT = 1;
            PRESSURE_SWITCH_DIO = 1;
            COMPRESSOR_RELAY_SLOT = 1;
            COMPRESSOR_REL = 1;
            ULTRASONIC_ANG = 7;
            CONTROLLER_1 = 1;
        } else if (sri == 3) {
            RIGHT_ENCODER_A_DIO = 2;
            RIGHT_ENCODER_B_DIO = 3;
            LEFT_ENCODER_A_DIO = 4;
            LEFT_ENCODER_B_DIO = 5;
            WHEEL_lEFT_PWM = 10;
            WHEEL_RIGHT_PWM = 8;
            GEAR_SHIFT_SOLONOID_A_SOL = 1;
            GEAR_SHIFT_SOLONOID_B_SOL = 2;
            PRESSURE_SWITCH_SLOT = 1;
            PRESSURE_SWITCH_DIO = 1;
            COMPRESSOR_RELAY_SLOT = 1;
            COMPRESSOR_REL = 1;
            ULTRASONIC_ANG = 7;
            CONTROLLER_1 = 1;
        }

        
        
        gearShiftSolonoid = new NewSolenoid()
                .setPort(GEAR_SHIFT_SOLONOID_A_SOL)
                .setSecondaryPort(GEAR_SHIFT_SOLONOID_B_SOL)
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
                SetBackLeft(new Victor(WHEEL_lEFT_PWM))
                .SetBackRight(new Victor(WHEEL_RIGHT_PWM))
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
            compressorController,
            wheelEncoder1,
            wheelEncoder2,
            gearShiftSolonoid,
            ultraSonicSensor1,
            cameraLED,
            logger,
            shooterController,
            gearShiftController,
        };
        //Don't put anything after here
    }
}
