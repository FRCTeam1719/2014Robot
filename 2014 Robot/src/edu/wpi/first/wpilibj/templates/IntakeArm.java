/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author aaroneline
 */
public class IntakeArm implements IStep {

    private int motorPort;
    private int solenoidPort;
    private double spinnerSpeed = 0;
    private boolean isUp = false;
    private final double VICTOR_FORWARD = 1;
    private final double VICTOR_REVERSE = -1;
    private final double VICTOR_OFF = 0;
    SpeedController spinner;
    NewSolenoid solenoid;
    LimitedMotor arm;

    public void step() {
        solenoid.set(!isUp);
        System.out.println(isUp);
        spinner.set(spinnerSpeed);
        solenoid.step();
        arm.step();
    }

    public void runIntake() {
        this.spinnerSpeed = VICTOR_FORWARD;
    }

    public void reverseIntake() {
        this.spinnerSpeed = VICTOR_REVERSE;
    }

    public void stopIntake() {
        this.spinnerSpeed = VICTOR_OFF;
    }

    public IntakeArm init() {
        //Setup devices
        solenoid = new NewSolenoid()
                    .setPort(solenoidPort)
                    .init();
        return this;
    }

    //Seters for ports
    public IntakeArm setSpinner(SpeedController spinner) {
        this.spinner=spinner;
        return this;
    }

    public IntakeArm setSolenoidPort(int solenoidPort) {
        this.solenoidPort = solenoidPort;
        return this;
    }

    public void setArmUp(boolean isUp) {
        this.isUp = isUp;
        if (isUp) {
            spinnerSpeed = VICTOR_OFF;
            arm.set(-.5);
        } else {
            spinnerSpeed = VICTOR_FORWARD;
            arm.set(.5);
        }
    }
    
    public IntakeArm setArm(LimitedMotor arm){
        this.arm=arm;
        return this;
    }

}
