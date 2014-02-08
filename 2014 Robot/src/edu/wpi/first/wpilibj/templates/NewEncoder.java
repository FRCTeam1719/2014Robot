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
    //TODO rename class
    NewEncoder() {
    }
    Encoder encoder;
   DigitalInput di1;
    DigitalInput di2; 
    //TODO what are num1, num2?
    int encoderAChannelPort = 0;
    int encoderAChannelSlot = 1;
    int encoderBChannelPort = 0;
    int encoderBChannelSlot = 1;

    //Counter counter;
    public void step() {
        //send robot speed to dashboard
       // SmartDashboard.putNumber("speed",Math.abs(encoder.getRate()));     

    }

    public NewEncoder init() {
      di1 = new DigitalInput(encoderAChannelSlot, encoderAChannelPort);
      di2 = new DigitalInput(encoderBChannelSlot, encoderBChannelPort);
      encoder = new Encoder(di2, di1);
      encoder.setSamplesToAverage(50);
      encoder.start();
      
      Devices.logChecker.sendLog("Encoder started", 3);
        return this;

    }
    public double get(){
        
        return Math.abs(encoder.getRate());
    }
    //sets the port for the first encoder
    public NewEncoder setEncoderAChannelPort(int portNumber){
        encoderAChannelPort = portNumber;
        return this;
    }
    //sets the port for the second encoder
     public NewEncoder setEncoderBChannelPort(int portNumber){
        encoderBChannelPort = portNumber;
        return this;
    }
}
