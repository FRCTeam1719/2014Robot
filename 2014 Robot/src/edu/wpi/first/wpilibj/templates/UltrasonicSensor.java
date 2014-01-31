/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Chance
 */
public class UltrasonicSensor implements IStep{
    int slot;
    AnalogChannel ultrasonic;
    public void step() {
        
        //SmartDashboard.putNumber("ultrasonic", ultrasonic.getAverageValue());
    }
    public void init(){
        ultrasonic = new AnalogChannel(slot);
    }
    public int getValue(){
        return ultrasonic.getAverageValue();
    }
    public UltrasonicSensor setSlot(int slot){
        this.slot = slot;
        return this;
    }
}
