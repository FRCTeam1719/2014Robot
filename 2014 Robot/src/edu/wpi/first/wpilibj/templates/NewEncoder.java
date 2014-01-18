/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Chance
 */
public class NewEncoder implements IStep {

    NewEncoder() {
    }
    Encoder encoder;
   DigitalInput di1;
    DigitalInput di2; 
    //Counter counter;
    public void step() {
        //send robot speed to dashboard
        SmartDashboard.putNumber("speed",encoder.getRate());
      
      

    }

    public void init() {
      di1 = new DigitalInput(1, 3);
      di2 = new DigitalInput(1, 4);
      encoder = new Encoder(di2, di1);
      encoder.setSamplesToAverage(50);
      encoder.start();
      Devices.logger.sendMessage("Encoder started");
        

    }
}
