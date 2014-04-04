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
    private boolean isRatchet = false;
    private double point;
    private double speed = 1;
    private boolean isAtPoint;
    private boolean enabled=false;
    public boolean isGoingBack = false;
    public final double IDLE_SPEED = .1;
    

    public void step() {
        if(!enabled){
            victor.set(IDLE_SPEED);
            System.out.println("!enabled return println");
            return;
        }
        if (potentiometer.get() < point && isGoingBack) {
            isAtPoint = false;
            victor.set(speed);

        } else if ((potentiometer.get() > point) && !isRatchet && !isGoingBack) {
            isAtPoint = false;
            victor.set(-speed);
        } else {
            isAtPoint = true;
            victor.set(0);
            System.out.println("Else print");
        }
    }

    public SetPointMotor init() {
        victor = new Victor(motorPort);
        potentiometer = new AnalogPotentiometer(potentiometerPort);
        return this;
    }

    public SetPointMotor setMotorPort(int motorPort) {
        this.motorPort = motorPort;
        return this;
    }

    public SetPointMotor setPotentiometerPort(int potentiometerPort) {
        this.potentiometerPort = potentiometerPort;
        return this;
    }

    public void setPoint(double point) {
        this.point = point;
    }
    
    public SetPointMotor setSpeed(double speed) {
        this.speed = speed;
        return this;

    }

    public boolean getIsAtPoint() {
        
        return isAtPoint;
    }

    public SetPointMotor setIsRatchet(boolean isRatchet) {
        this.isRatchet = isRatchet;
        return this;
    }

    public double getPotVal(){
        return potentiometer.get();
    }
    
    public void enable(){
        this.enabled=true;
    }
    public void disable(){
        this.enabled=false;
    }
}
