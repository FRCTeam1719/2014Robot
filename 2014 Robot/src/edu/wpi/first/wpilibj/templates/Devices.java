/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.autonomous.*;
import edu.wpi.first.wpilibj.templates.testmode.TestMode;

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
    public static CameraLEDController cameraLED;
    public static ShooterController shooterController;
    public static IntakeArm intakeArm;
    public static SmartDashboardReader smartDashboardReader;
    static Log logger = new Log();
    public static LogLevelCheck logChecker = new LogLevelCheck();
    
    private static int SHOOTER_BACKWARD_LIMIT_DIO=6;
    private static int SHOOTER_FORWARD_LIMIT_DIO=7;
    
    private static int GEAR_SHIFT_SOLONOID_A_SOL=1;
    private static int GEAR_SHIFT_SOLONOID_B_SOL=2;
    private static int INTAKE_SOLENOID_SOL=3;
    
    private static int LEFT_ENCODER_A_DIO=2;
    private static int LEFT_ENCODER_B_DIO=3;
    private static int RIGHT_ENCODER_A_DIO=4;
    private static int RIGHT_ENCODER_B_DIO=5;
    
    private static int WHEEL_LEFT_PWM=10;
    private static int WHEEL_RIGHT_PWM=8;
    
    private static int COMPRESSOR_RELAY_SLOT=1;
    private static int PRESSURE_SWITCH_SLOT=1;
    
    private static int COMPRESSOR_REL=1;
    private static int PRESSURE_SWITCH_DIO=1;
    
    private static int SHOOTER_MOTOR_PWM=1;
    private static int INTAKE_MOTOR_A_PWM=2;
    private static int INTAKE_MOTOR_B_PWM=4;
    private static int INTAKE_ARM_MOTOR_PWM=3;
    
    private static int INTAKE_BACKWARD_LIMIT_DIO=8;
    private static int INTAKE_FORWARD_LIMIT_DIO=9;
    
    public void step() {
        for (int i = 0; i < Devices.devices.length; i++) {
            Devices.devices[i].step();
        }

    }

    public void init() {
        operatorController = new OperatorController();
        operatorController.setNumber(2);
        operatorController.init();
        testMode = new TestMode();
        autonomous = new Autonomous();

        smartDashboardReader = new SmartDashboardReader();
        smartDashboardReader.init();

        shooterController = new ShooterController()
                .setMotorPort(SHOOTER_MOTOR_PWM)
                .setBackwardLimitSwitch(SHOOTER_BACKWARD_LIMIT_DIO)
                .setForwardLimitSwitch(SHOOTER_FORWARD_LIMIT_DIO)
                .init();

        intakeArm = new IntakeArm()
            .setSpinner(new MultiMotor()
                .add(new Victor(INTAKE_MOTOR_A_PWM),false)
                .add(new Victor(INTAKE_MOTOR_B_PWM),true)
            )
            .setSolenoidPort(INTAKE_SOLENOID_SOL)
            .setArm(new LimitedMotor()
                    .setBackwardLimit(new DigitalInput(INTAKE_BACKWARD_LIMIT_DIO))
                    .setForwardLimit(new DigitalInput(INTAKE_FORWARD_LIMIT_DIO))
                    .setMotor(new Jaguar(INTAKE_ARM_MOTOR_PWM))
                    .init())
            .init();

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
                SetBackLeft(new Jaguar(WHEEL_LEFT_PWM))
                .SetBackRight(new Jaguar(WHEEL_RIGHT_PWM))
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
            cameraLED,
            logger,
            shooterController,
            gearShiftController,
            operatorController,
            intakeArm
        };
        //Don't put anything after here
    }

}
