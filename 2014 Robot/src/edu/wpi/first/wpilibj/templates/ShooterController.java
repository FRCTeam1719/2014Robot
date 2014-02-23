/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Chance
 */
public class ShooterController implements IStep {

    private double distanceBack = 0;
    NewSolenoid solonoid;
    int solonoidPort;
    int motorPort;
    int potentiometerPort;
    private boolean isOn = true;
    long timeToFire = 10000;
    long timeToReEngage = 0;
    public boolean isReadyToShoot = false;
    public boolean isDoneShooting = true;
    ;
    SetPointMotor motor;
    private boolean motorOn;
    boolean fire = false;

    public void step() {
        if (timeToReEngage < System.currentTimeMillis() && (timeToReEngage != 0)) {
            timeToReEngage = 0;
            isOn = true;
            isReadyToShoot = false;
            isDoneShooting = true;
        } else {
            isOn = false;
            isReadyToShoot = true;
        }
        if (isDoneShooting) {
            motor.setPoint(0);
        }

        solonoid.set(fire);
        motor.step();
        solonoid.step();
    }

    public void setMotorOn(boolean b) {
        this.motorOn = b;
    }

    public void init() {
        solonoid = new NewSolenoid();
        solonoid.setPort(solonoidPort);
        motor = new SetPointMotor();
        motor.setMotorPort(motorPort);
        motor.setSpeed(1);
        motor.init();


    }

    public void setSolonoidPort(int solonoidPort) {
        this.solonoidPort = solonoidPort;
    }

    public void setMotorPort(int motorPort) {
        this.motorPort = motorPort;
    }

    public void setPotentiometerPort(int potentiometerPort) {
        this.potentiometerPort = potentiometerPort;
    }

    public void fire() {
        motor.setPoint(distanceBack);
        if (motor.getIsAtPoint()) {
            if (!isOn) {
                isOn = false;
                isReadyToShoot = false;
                timeToReEngage = System.currentTimeMillis() + timeToFire;
                motor.setPoint(0);
            }
        }else{
            fire();
        }
        fire = true;


    }

    public void unfire() {
        fire = false;
    }

    public void setTimeToFire(int timeToFire) {
        this.timeToFire = timeToFire;
        isDoneShooting = false;
    }

    public void setDistanceBack(double value) {
        distanceBack = value;
    }
}
