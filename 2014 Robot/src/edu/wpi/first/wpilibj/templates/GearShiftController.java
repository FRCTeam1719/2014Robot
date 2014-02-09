/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Chance
 */

public class GearShiftController implements IStep{
    
    
    
    private boolean isFastManual = false;
    private boolean isFastAutomatic = false;
    private boolean isAutomatic=false;
    private NewEncoder leftEncoder, rightEncoder;
    private NewSolenoid transmition;
    private double TRANSMITION_THRESHHOLD_LOW=600;
    private double TRANSMITION_THRESHHOLD_HIGH=800;
    
    
    
    public void step(){
        boolean isFast=isFastManual || checkAutomatic();
        transmition.set(isFast);
    }
    
    
    
    //Returns true if the automatic transmision thinks we should be fast
    public boolean checkAutomatic(){
        if(!isAutomatic){
            return false;
        }
        double speed = (leftEncoder.get()+rightEncoder.get())/2;
        if (speed<TRANSMITION_THRESHHOLD_LOW){
            isFastAutomatic=false;
        }
        if (speed>TRANSMITION_THRESHHOLD_HIGH){
            isFastAutomatic=true;
        }
        return isFastAutomatic;
    }
    
    
    
    
    public void setFast(boolean isFast){
        this.isFastManual=isFast;
    }
    
    
    
    public void setAutomatic(boolean isAutomatic){
        this.isAutomatic=isAutomatic;
    }
    
    
    
    public GearShiftController setLeftEncoder(NewEncoder encoder){
        this.leftEncoder=encoder;
        return this;
    }
    
    
    
    public GearShiftController setRightEncoder(NewEncoder encoder){
        this.rightEncoder=encoder;
        return this;
    }
    
    
    
    public GearShiftController setSolenoid(NewSolenoid solenoid){
        this.transmition=solenoid;
        return this;
    }
    
    
    
    public GearShiftController init(){
        return this;
    }
    
    
    
}
