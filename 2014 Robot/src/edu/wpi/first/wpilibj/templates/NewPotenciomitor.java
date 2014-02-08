/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

/**
 *
 * @author Chance
 */
public class NewPotenciomitor implements IStep {

    int port;
    AnalogPotentiometer p;
    public void step() {
    }

    public NewPotenciomitor init() {
        p = new AnalogPotentiometer(port);
        return this;
    }

    public NewPotenciomitor setPort(int port) {
        this.port = port;
        return this;
    }
    public double get(){
        return p.get();
    }
}
