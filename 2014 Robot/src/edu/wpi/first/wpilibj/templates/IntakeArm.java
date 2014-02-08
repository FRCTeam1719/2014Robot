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
//TODO: Not implemented anywhere in code
public class IntakeArm implements IStep{

    private int motorPort;
    private int potentiometerPort;
    private int height;
    private final double VICTOR_ON = 5;
    private final double VICTOR_OFF = 0;
    Victor victor;
    AnalogPotentiometer potent;
    //Check if the current reading from the potentiometer is equal to what we 
    // want it to be
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
    //How high should the arm go
    public void setLevel(int height){
        this.height = height;
        
    
    
    
    }

}

