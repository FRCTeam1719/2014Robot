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

public class InfraredSensor implements IStep{
    
    
    
    public void step() {
        SmartDashboard.putNumber("infrared", infrared.getAverageValue());
        String tempValueForLog;
        tempValueForLog = "Infared value: "+infrared.getAverageValue();
        Devices.logChecker.sendLog(tempValueForLog, LogLevelCheck.sensor);
    }
    
    AnalogChannel infrared;
    
    public void init(int slot){
        infrared = new AnalogChannel(slot);
    }
    
    
    
    //Gets the value of the infared sensor
    public int getValue(){
        return infrared.getAverageValue();
    }
    
    
    
}
