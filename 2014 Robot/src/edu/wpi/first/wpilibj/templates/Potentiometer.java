/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Thomas
 */
public class Potentiometer implements IStep{
    int slot;
    AnalogChannel potentiometer;
    public void init(){
        potentiometer = new AnalogChannel(slot);
    }
    public void step() {
        SmartDashboard.putNumber("potentiometer", potentiometer.getAverageValue());
    }
    public Potentiometer setSlot(int s){
        slot = s;
        return this;
    }
    public int getValue(){
        return potentiometer.getAverageValue();
    }
    
}
