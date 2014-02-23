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
    public boolean isFiring = false;
    SetPointMotor motor;
    private boolean motorOn;
    boolean fire = false;
    public int firingMode = 0;

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
        if(firingMode == 1 && motor.getIsAtPoint()){
            firingMode = 2;
        }
        if(firingMode == 2){
            fire = true;
            firingMode = 3;
            timeToReEngage = System.currentTimeMillis() + timeToFire;
            
        }
        if((firingMode ==3)&&(timeToReEngage < System.currentTimeMillis() && (timeToReEngage != 0))){
            firingMode = 0;
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
        motor.setIsRatchet(true);
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
        isFiring = true;
        firingMode = 1;
        
        
        
        
        
        
        
        
       


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
