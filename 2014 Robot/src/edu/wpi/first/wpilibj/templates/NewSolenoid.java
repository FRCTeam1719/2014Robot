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
   Solenoid solenoid;
   private boolean isOn = true;
    public void step(){
       solenoid.set(isOn);
   }
    public void init(){
        solenoid = new Solenoid(1, 1);
        
    }
    public void set(boolean isOn){
        this.isOn = isOn;
    }
}
