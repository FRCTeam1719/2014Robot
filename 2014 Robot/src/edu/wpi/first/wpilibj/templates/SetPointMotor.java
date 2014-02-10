/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 * @author Chance
 */
public class SetPointMotor implements IStep {

    private Victor victor;
    private int motorPort;
  
    private AnalogPotentiometer potentiometer;
    private int potentiometerPort;
    private int solonoidPort;
   
    private double point;
    private double speed = .5;
    private boolean isAtPoint;
    public void step() {
        if (potentiometer.get() < point) {
            isAtPoint = false;
            victor.set(speed);


        } else if (potentiometer.get() > point) {
            isAtPoint = false;
            victor.set(-speed);
        }else{
            isAtPoint = true;
            victor.set(0);
        }

        



    }

    public void init() {
        victor = new Victor(motorPort);
        potentiometer = new AnalogPotentiometer(potentiometerPort);
        
    }

    public void setMotorPort(int motorPort) {
        this.motorPort = motorPort;
    }

    public void setPotentiometerPort(int potentiometerPort) {
        this.potentiometerPort = potentiometerPort;
    }

   

    
    public void setPoint(double point) {
        this.point = point;
    }

    public void setSpeed(double speed) {
        this.speed = speed;

    }
    public boolean getIsAtPoint(){
        return isAtPoint;
    }
    
}
