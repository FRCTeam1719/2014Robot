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

    //TODO unused variables
    public static IStep[] devices;
    public static Drive drive;
    //TODO why is autonomous a device
    public static Autonomous autonomous;
    public static TestMode testMode;
    public static NewSolenoid gearShiftSolonoid;
    public static NewEncoder leftWheelEncoder;
    public static NewEncoder rightWheelEncoder;
    public static GearShiftController gearShiftController;
    public static UltrasonicSensor ultraSonicSensor1;
    public static CameraLEDController cameraLED;
    public static ShooterController shooterController;
    static Log logger = new Log();
    static LogLevelCheck logChecker = new LogLevelCheck();
    // Integer selectedRobot=1;
    //ports
    
    private static int PRESSURE_SWITCH_SLOT = 1;
    private static int PRESSURE_SWITCH_DIO = 1;
    private static int RIGHT_ENCODER_A_DIO = 2;
    private static int RIGHT_ENCODER_B_DIO = 3;
    private static int LEFT_ENCODER_A_DIO = 4;
    private static int LEFT_ENCODER_B_DIO = 5;
    
    private static int WHEEL_lEFT_PWM = 10;
    private static int WHEEL_RIGHT_PWM = 8;
    
    private static int GEAR_SHIFT_SOLONOID_A_SOL = 1;
    private static int GEAR_SHIFT_SOLONOID_B_SOL = 2;
    
    private static int COMPRESSOR_RELAY_SLOT = 1;
    private static int COMPRESSOR_REL = 1;
    
    private static int ULTRASONIC_ANG = 7;
    
    private static int CONTROLLER_1 = 1;
    //TODO this gave me a null pointer
//    Integer selectedRobot = (Integer) RobotTemplate.robot.getSelected();

    //TODO move to init
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

        //TODO which robot do these go to
        //TODO should we arrange these by module? 
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

        //TODO make these constructions follow a consistent format
        //make gear shift solonoids
        gearShiftSolonoid = new NewSolenoid()
                .setPort(GEAR_SHIFT_SOLONOID_A_SOL)
                .setSecondaryPort(GEAR_SHIFT_SOLONOID_B_SOL)
                .init();
        //other encoders 1-2
        //2- 3
        //make wheel encoders
        leftWheelEncoder = new NewEncoder()
                .setEncoderAChannelPort(LEFT_ENCODER_A_DIO)
                .setEncoderBChannelPort(LEFT_ENCODER_B_DIO)
                .init();

        rightWheelEncoder = new NewEncoder()
                .setEncoderAChannelPort(RIGHT_ENCODER_A_DIO)
                .setEncoderBChannelPort(RIGHT_ENCODER_B_DIO)
                .init();

        gearShiftController = new GearShiftController()
                .setLeftEncoder(leftWheelEncoder)
                .setRightEncoder(rightWheelEncoder)
                .setSolenoid(gearShiftSolonoid)
                .init();

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
                .setSlot(ULTRASONIC_ANG)
                .init();

        //make compressor
        CompressorController compressorController = new CompressorController();
        compressorController
                .setCompressorRelayChannel(COMPRESSOR_REL)
                .setCompressorRelaySlot(COMPRESSOR_RELAY_SLOT)
                .setPressureSwitchChannel(PRESSURE_SWITCH_DIO)
                .setPressureSwitchSlot(PRESSURE_SWITCH_SLOT)
                .init();

        //devices array
        devices = new IStep[]{
            drive,
            compressorController,
            leftWheelEncoder,
            rightWheelEncoder,
            gearShiftSolonoid,
            ultraSonicSensor1,
            cameraLED,
            logger,
            shooterController,
            gearShiftController,
        };
        //don't put anything after here
    }
}
