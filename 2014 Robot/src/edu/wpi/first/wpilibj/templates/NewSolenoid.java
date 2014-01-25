/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Chance
 */
public class NewSolenoid implements IStep{
   Solenoid solenoidA;
   Solenoid solenoidB;
//    Relay solenoid;
   private boolean isOn = false;
    public void step(){
       solenoidA.set(isOn);
       solenoidB.set(!isOn);
        if(isOn){
//            solenoid.set(Relay.Value.kForward);
        }else{
//            solenoid.set(Relay.Value.kReverse);
        }
   }
    public void init(){
        solenoidA = new Solenoid(1, 1);
        solenoidB = new Solenoid(1, 2);
                
//        solenoid = new Relay(1, 2, Relay.Direction.kBoth);
        
    }
    public void set(boolean isOn){
        this.isOn = isOn;
    }
}
