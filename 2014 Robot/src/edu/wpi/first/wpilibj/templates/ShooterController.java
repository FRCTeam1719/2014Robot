/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author Chance
 */
public class ShooterController implements IStep {

    NewSolenoid solonoid;
    int solonoidPort;
    int motorPort;
    int potentiometerPort;
    private boolean isOn = true;
    long timeToFire = 10000;
    long timeToReEngage = 0;

    public void step() {
        if (timeToReEngage < System.currentTimeMillis() && (timeToReEngage != 0)) {
            timeToReEngage = 0;
            isOn = true;
        }
        solonoid.set(isOn);


    }

    public void init() {
        solonoid = new NewSolenoid();
        solonoid.setPort(solonoidPort);


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
        if (!isOn) {
            isOn = false;

            timeToReEngage = System.currentTimeMillis() + timeToFire;
        }



    }

    public void setTimeToFire(int timeToFire) {
        this.timeToFire = timeToFire;
    }
}
