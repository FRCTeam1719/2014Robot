/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Chance
 */
public class NewEncoder implements IStep {

    NewEncoder() {
    }
    Encoder encoder;
   DigitalInput di1;
    DigitalInput di2; 
    int num1 = 0;
    int num2 = 0;
    //Counter counter;
    public void step() {
        //send robot speed to dashboard
       // SmartDashboard.putNumber("speed",Math.abs(encoder.getRate()));
      
      

    }

    public void init() {
      di1 = new DigitalInput(1, num1);
      di2 = new DigitalInput(1, num2);
      encoder = new Encoder(di2, di1);
      encoder.setSamplesToAverage(50);
      encoder.start();
        

    }
    public double get(){
        
        return Math.abs(encoder.getRate());
    }
    //sets the port for the first encoder
    public void setEncoder1(int encoderNumber){
        num1 = encoderNumber;
    }
    //sets the port for the second encoder
     public void setEncoder2(int encoderNumber){
        num2 = encoderNumber;
    }
}
