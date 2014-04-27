/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Chance
 */
public class Drive implements IStep {

    private double moveX, rotation = 0;
    private double leftWheelSpeed, rightWheelSpeed = 0;
    private boolean isTankDrive = false;
    private SpeedController leftMotor, rightMotor;
    private RobotDrive robotDrive;
    private boolean isEnabled = true;
    private double time = 0;
    private int steer = 0;
    private PIDController pid;
    private PIDController pid2;

    private final int MODE_TANK=1, MODE_ARCADE=2, MODE_STRAIGHT=3;
    private int mode=MODE_TANK;
    Drive() {

    }

    public void step() {
        if (isEnabled) {
            if (mode==MODE_TANK) {
                robotDrive.tankDrive(leftWheelSpeed, rightWheelSpeed);
            }
            if (mode==MODE_ARCADE) {
                robotDrive.arcadeDrive(moveX, rotation);
            }
            if(mode==MODE_STRAIGHT){
                robotDrive.setSafetyEnabled(false);
            }
        } else {
            checkTime();
        }
        SmartDashboardReader.putDouble("Enc1", Devices.wheelEncoder1.get());
        SmartDashboardReader.putDouble("Enc2", Devices.wheelEncoder2.get());
    }

    //Sets the back left motor
    public Drive SetBackLeft(SpeedController leftMotor) {
        this.leftMotor = leftMotor;
        return this;
    }

    //Sets the back right motor
    public Drive SetBackRight(SpeedController rightMotor) {
        this.rightMotor = rightMotor;
        return this;
    }

    public Drive init() {
        robotDrive = new RobotDrive(leftMotor, rightMotor);
        pid = new PIDController(0, 0, 0, Devices.wheelEncoder1.encoder, leftMotor);
        pid2 = new PIDController(0, 0, 0, Devices.wheelEncoder2.encoder, rightMotor);
        pid.disable();
        pid2.disable();

        // robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        return this;
    }

    public Drive moveArcade(double moveX, double rotation) {
        pid.disable();
        pid2.disable();

        this.moveX = moveX;
        this.rotation = rotation;
        mode=MODE_ARCADE;
        return this;
    }

    public Drive moveTank(double leftWheelSpeed, double rightWheelSpeed) {
        pid.disable();
        pid2.disable();

        this.leftWheelSpeed = leftWheelSpeed;
        this.rightWheelSpeed = rightWheelSpeed;
        mode=MODE_TANK;
        return this;

    }

    public void checkTime() {
        if (System.currentTimeMillis() >= time) {
            isEnabled = true;
        }
    }

    public void stop(double sTime) {
        time = System.currentTimeMillis() + sTime;
    }

    public void driveStrightD(double speed) {
        moveArcade(speed, steer);
        if (Devices.wheelEncoder1.get() > Devices.wheelEncoder2.get()) {
            steer += .1;

        } else if (Devices.wheelEncoder2.get() > Devices.wheelEncoder1.get()) {
            steer -= .1;
        }

    }

    public void DriveStraight(double speed) {
        mode=MODE_STRAIGHT;
        double p = SmartDashboardReader.getDouble("P");
        double i = SmartDashboardReader.getDouble("I");
        double d = SmartDashboardReader.getDouble("D");
        pid.setPID(p, i, d);
        pid2.setPID(p, i, d);
       
        
        pid.setOutputRange(-1, 1);
        pid2.setOutputRange(-1,1);
        pid.setSetpoint(-speed);
        pid2.setSetpoint(speed);
         pid.enable();
         pid2.enable();
        
    }
}
