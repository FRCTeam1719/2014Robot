/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Thomas
 */

public class CameraLEDController implements IStep{
    
    public Relay ledController;
    public CameraLEDController(int slot, int channel){
        ledController = new Relay(slot, channel, Relay.Direction.kForward);
    }
    
    
    
    public void init(){
        SmartDashboard.putBoolean("cameraLEDOn", false);
        SmartDashboard.putBoolean("cameraLED", false);
    }
    
    
    
    public void step() {
        boolean cameraOn = SmartDashboard.getBoolean("cameraLED");
        if(cameraOn){
            ledController.set(Relay.Value.kOn);
            
        }else{
            ledController.set(Relay.Value.kOff);
            
        }
        SmartDashboard.putBoolean("cameraLEDOn", cameraOn);
    }
    
}
