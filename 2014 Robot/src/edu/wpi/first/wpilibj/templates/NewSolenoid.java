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
   //TODO delete SOLONOID_PORT_1
   final static int SOLONOID_PORT_1 = 1;
   private boolean isOn = true;
    public void step(){
       solenoid.set(isOn);
   }
    public void init(){
        
        
    }
    //TODO, rename
    public void set(int a){
        solenoid = new Solenoid(a);
    }
    //turns the solonoid on and off
    public void set(boolean isOn){
        this.isOn = isOn;
    }
}
