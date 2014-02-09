/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Chance
 */
public class NewSolenoid implements IStep{
   Solenoid solenoid,secondarySolenoid;
   private boolean isOn = true;
    public void step(){
       solenoid.set(isOn);
       if(secondarySolenoid!=null){
           secondarySolenoid.set(!isOn);
       }
   }
    public NewSolenoid init(){
        return this;
        
    }
    
    public NewSolenoid setPort(int a){
        solenoid = new Solenoid(a);
        return this;
    }
    public NewSolenoid setSecondaryPort(int a){
        secondarySolenoid = new Solenoid(a);
        return this;
    }
    //turns the solonoid on and off
    public void set(boolean isOn){
        this.isOn = isOn;
    }
}
