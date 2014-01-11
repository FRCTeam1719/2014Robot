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
    NewEncoder(){
       
    }
    Encoder encoder;
    //DigitalInput di1;
    //DigitalInput di2;
    
    public void step() {
        
        SmartDashboard.putNumber("speed swag", encoder.get());
        //System.out.println("speed swag " + encoder.getDistance());
        
    }
 public void init(){
     //di1 = new DigitalInput(1, 7);
        
     //di2 = new DigitalInput(1, 8);
   encoder = new Encoder(7,8);
     
    
 }   
}
