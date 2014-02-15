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
    private int position;
    private final int UP_POSITION = 1;
    private final double VICTOR_ON = 1;
    private final double VICTOR_OFF = 0;
    Victor victor;
    NewSolenoid solenoid;

    
    
    public void step(){
        if(position==UP_POSITION){
            victor.set(VICTOR_OFF);
            solenoid.set(true);
        }else{
            victor.set(VICTOR_ON);
            solenoid.set(false);
        }
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
    
    public void setPosition(int position){
        this.position = position;
    }

}

