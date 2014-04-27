/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author aaroneline
 */

public class IntakeArm implements IStep{
    
    
    
    private int motorPort;
    private int solenoidPort;
    private double spinnerSpeed=0;
    private boolean isUp=false;
    private final double VICTOR_FORWARD = 1;
    private final double VICTOR_REVERSE = -1;
    private final double VICTOR_OFF = 0;
    Victor victor;
    NewSolenoid solenoid;

    
    
    public void step(){
        solenoid.set(!isUp);
        victor.set(spinnerSpeed);
        solenoid.step();
    }
    
    
    public void runIntake(){
        this.spinnerSpeed=VICTOR_FORWARD;
    }
    public void reverseIntake(){
        this.spinnerSpeed=VICTOR_REVERSE;
    }
    public void stopIntake(){
        this.spinnerSpeed=VICTOR_OFF;
    }
    
    public IntakeArm init(){
        //Setup devices
        victor = new Victor(motorPort);
        solenoid = new NewSolenoid();
        solenoid.setPort(solenoidPort);
        return this;
    }
    
    //Seters for ports
    public void setMotorPort(int motorPort){
        this.motorPort = motorPort;
    }
    
    public void setSolenoidPort(int solenoidPort){
        this.solenoidPort = solenoidPort;
    }
    
    public void setArmUp(boolean isUp){
        this.isUp = isUp;
        if(isUp){
            spinnerSpeed=VICTOR_OFF;
        }else{
            spinnerSpeed=VICTOR_FORWARD;
        }
    }
    public boolean isUp(){
        return isUp;
    }

}

