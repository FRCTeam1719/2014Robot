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
    Victor speedController;
    AnalogPotentiometer potent;
    public void step(){
        if(height > potent.get()){
            speedController.set(5);
        }else{
            speedController.set(0);
        }
    }
    
    public IntakeArm init(){
        speedController = new Victor(motorPort);
        AnalogPotentiometer potent = new AnalogPotentiometer(potentiometerPort);
        
        return this;
    }
    
    public void setMotorPort(int motorPort){
        this.motorPort = motorPort;
    }
    
    public void setPotentiometerPort(int PotPort){
        this.potentiometerPort = PotPort;
    }
    public void setLevel(int height){
        this.height = height;
        
    
    
    
    }

}

