/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author Chance
 */
public class Drive implements IStep {

    private double moveX,rotation = 0;
    private double leftWheelSpeed, rightWheelSpeed = 0;
    private boolean isTankDrive = false;
    private SpeedController leftMotor, rightMotor;
    private RobotDrive robotDrive;

    Drive() {
    }

    public void step() {
        
        if(isTankDrive){
        robotDrive.tankDrive(leftWheelSpeed, rightWheelSpeed);
        }if(!isTankDrive){
            robotDrive.arcadeDrive(moveX, -rotation);
        }

    }

    public Drive SetBackLeft(SpeedController leftMotor) {
        this.leftMotor = leftMotor;
        return this;
    }

    public Drive SetBackRight(SpeedController rightMotor) {
        this.rightMotor = rightMotor;

        return this;
    }

    public Drive init() {
        robotDrive = new RobotDrive(leftMotor, rightMotor);

        // robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        return this;
    }

   

    public Drive moveArcade(double moveX, double rotaton) {
       this.moveX = moveX;
       this.rotation = rotaton;
       isTankDrive = false;


        return this;
    }
    public Drive moveTank(double leftWheelSpeed, double rightWheelSpeed){
        this.leftWheelSpeed = leftWheelSpeed;
        this.rightWheelSpeed = rightWheelSpeed;
        isTankDrive = true;
        
        return this;
    
    }
}
