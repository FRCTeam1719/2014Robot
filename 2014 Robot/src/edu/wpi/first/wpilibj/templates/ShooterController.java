/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Chance
 */
public class ShooterController implements IStep {
    private int shooterPort;
    public SpeedController victor;
    public double speed = .6;
    public void step() {
        
    }
    public void init(){
        victor = new Victor(shooterPort);
    }
    public void setPort(int port){
        shooterPort = port;
    }
    public void forward(){
        victor.set(speed);
    }
    public void back(){
        victor.set(-speed);
    } 
    
   public void stop(){
       victor.set(0);
   }
}
