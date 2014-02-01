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
public class ShooterController implements IStep {

    private Victor victor;
    private int motorPort;
    private Solenoid solonoid;
    private AnalogPotentiometer potentiometer;
    private int potentiometerPort;
    private int solonoidPort;
    private static final double ALL_THE_WAY_BACK = .5;
    private boolean isReleased = false;

    public void step() {
        System.out.println(potentiometer.get());
        if (potentiometer.get() < ALL_THE_WAY_BACK) {
            victor.set(.5);
            
            
        } else {
            victor.set(0);
        }
            solonoid.set(isReleased);
        


    }

    public void init() {
        victor = new Victor(motorPort);
        potentiometer = new AnalogPotentiometer(potentiometerPort);
        solonoid = new Solenoid(solonoidPort);
    }

    public void setMotorPort(int motorPort) {
        this.motorPort = motorPort;
    }

    public void setPotentiometerPort(int potentiometerPort) {
        this.potentiometerPort = potentiometerPort;
    }

    public void setSolonoidPort(int solonoidPort) {
        this.solonoidPort = solonoidPort;
    }

    public void setReleased(boolean value ) {
        isReleased = value;
    }
   
}
