/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Chance
 */
public class ShooterController implements IStep {

    private int solonoidPort;
    private int motorPort;
    private Jaguar motor;
    private int firingMode = 0;

    private DigitalInput forwardLimitSwitch;
    private int forwardLimitSwitchPort;
    private DigitalInput backwardLimitSwitch;
    private int backwardLimitSwitchPort;

    public final int MODE_IDLE = 0;
    public final int MODE_COCKING = 1;
    public final int MODE_FIRING = 2;

    public final static double DISTANCE_SHORT = 10;
    public final static double DISTANCE_MEDIUM = 20;
    public final static double DISTANCE_LONG = 30;

    public void step() {
        switch (firingMode) {
            case (MODE_IDLE):
                motor.set(0);
                break;
            case (MODE_FIRING):
                motor.set(1);
                if (forwardLimitSwitch.get()) {
                    firingMode = MODE_COCKING;
                }
                break;
            case (MODE_COCKING):
                motor.set(-1);
                if (backwardLimitSwitch.get()) {
                    firingMode = MODE_IDLE;
                }
                break;
        }
    }

    public ShooterController init() {
        motor = new Jaguar(motorPort);
        forwardLimitSwitch = new DigitalInput(forwardLimitSwitchPort);
        backwardLimitSwitch = new DigitalInput(backwardLimitSwitchPort);
        return this;
    }

    public ShooterController setMotorPort(int motorPort) {
        this.motorPort = motorPort;
        return this;
    }

    public void fire() {
        firingMode = MODE_FIRING;
    }

    public ShooterController setForwardLimitSwitch(int port) {
        this.forwardLimitSwitchPort = port;
        return this;
    }

    public ShooterController setBackwardLimitSwitch(int port) {
        this.backwardLimitSwitchPort = port;
        return this;
    }

    public boolean isIdle() {
        return firingMode == MODE_IDLE;
    }
}
