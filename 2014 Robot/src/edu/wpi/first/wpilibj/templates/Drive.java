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

    private double moveX = 0;
    private double moveY = 0;
    private double moveRotation = 0;
    private double moveGyro = 0;
    private SpeedController frontLeft, frontRight, backLeft, backRight;
    private RobotDrive robotDrive;

    Drive() {
    }

    public void step() {
        robotDrive.mecanumDrive_Cartesian(moveX, moveY, moveRotation, moveGyro);
    }

    public Drive SetFrontLeft(SpeedController frontLeft) {
        this.frontLeft = frontLeft;
        return this;
    }

    public Drive SetFrontRight(SpeedController frontRight) {
        this.frontRight = frontRight;
        return this;
    }

    public Drive SetBackLeft(SpeedController BackLeft) {
        this.backLeft = backLeft;
        return this;
    }

    public Drive SetBackRight(SpeedController BackRight) {
        this.backRight = backRight;
        return this;
    }

    public Drive init() {
        robotDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
        return this;
    }

    public Drive move(double x, double y, double rotation, double gyro) {
        moveX = x;
        moveY = y;
        moveRotation = rotation;
        moveGyro = gyro;


        return this;
    }
}
