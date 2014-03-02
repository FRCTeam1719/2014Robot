/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 *
 * @author Thomas
 */
public class Intake2 {
    private Victor victor;
    private DigitalInput topLimitSwitch;
    private DigitalInput bottomLimitSwitch;
    private double currentSpeed;
    public static double speed = 1;
    
    public void step(){
        if(topLimitSwitch.get()||bottomLimitSwitch.get()){
            currentSpeed = 0;
        }
        victor.set(currentSpeed);
    }
    public void setIntakeUp(){
        if(!topLimitSwitch.get()){
            currentSpeed = speed;
        }
    }
    public void setIntakeDown(){
        if(!bottomLimitSwitch.get()){
            currentSpeed = -speed;
        }
    }
}
