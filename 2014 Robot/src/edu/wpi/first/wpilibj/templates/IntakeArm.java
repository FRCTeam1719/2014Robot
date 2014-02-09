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
    private int potentiometerPort;
    private int height;
    private final double VICTOR_ON = 5;
    private final double VICTOR_OFF = 0;
    Victor victor;
    AnalogPotentiometer potent;

    
    
    public void step(){
        if(height > potent.get()){
            victor.set(VICTOR_ON);
        }else{
            victor.set(VICTOR_OFF);
        }
    }
    
    
    
    
    public IntakeArm init(){
        //Setup devices
        victor = new Victor(motorPort);
        AnalogPotentiometer potent = new AnalogPotentiometer(potentiometerPort);
        return this;
    }
    
    
    
    //Seters for ports
    public void setMotorPort(int motorPort){
        this.motorPort = motorPort;
    }
    
    
    
    public void setPotentiometerPort(int PotPort){
        this.potentiometerPort = PotPort;
    }
    
    
    
    //How high the arm should go
    public void setLevel(int height){
        this.height = height;
    }
    
    

}

