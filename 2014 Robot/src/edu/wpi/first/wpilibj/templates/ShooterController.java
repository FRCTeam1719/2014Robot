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

    NewSolenoid solonoid;
    int solonoidPort;
    int motorPort;
    int potentiometerPort;
    private boolean isOn = true;
    long timeToFire = 10000;
    long timeToReEngage = 0;
    public boolean isReadyToShoot = false;
    public boolean isDoneShooting = false;
    SpeedController motor;
    private boolean motorOn;
    boolean fire=false;

    public void step() {
        if (timeToReEngage < System.currentTimeMillis() && (timeToReEngage != 0)) {
            timeToReEngage = 0;
            isOn = true;
            isReadyToShoot = false;
            isDoneShooting = true;
        }else{
            isOn = false;
            isReadyToShoot = true;
        }
        
        solonoid.set(fire);
        if(motorOn){
            motor.set(1);
        }else{
            motor.set(0);
        }
        solonoid.step();
    }

    public void setMotorOn(boolean b){
        this.motorOn=b;
    }
    
    
    public void init() {
        solonoid = new NewSolenoid();
        solonoid.setPort(solonoidPort);
        motor= new Victor(motorPort);


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
            isReadyToShoot = false;
            timeToReEngage = System.currentTimeMillis() + timeToFire;
        }
        fire=true;


    }
    public void unfire(){
        fire=false;
    }
    public void setTimeToFire(int timeToFire) {
        this.timeToFire = timeToFire;
        isDoneShooting = false;
    }
}
