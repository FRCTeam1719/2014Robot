/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;


/**
 *
 * @author brandon
 */
public class LimitedMotor implements IStep{
    private DigitalInput forwardLimit;
    private DigitalInput backwardLimit;
    private double speed;
    private SpeedController motor;
    
    public void step(){
        boolean atLimit=speed>0?forwardLimit.get():backwardLimit.get();
        if(atLimit){
            motor.set(0);
            this.speed=0;
        }
        else{
            motor.set(speed);
        }
    }
    public void set(double speed){
        this.speed=speed;
    }
    
    public LimitedMotor setForwardLimit(DigitalInput limit){
        this.forwardLimit=limit;
        return this;
    }
    public LimitedMotor setBackwardLimit(DigitalInput limit){
        this.backwardLimit=limit;
        return this;
    }
    public LimitedMotor setMotor(SpeedController motor){
        this.motor=motor;
        return this;
    }
    public LimitedMotor init(){
        return this;
    }
}
