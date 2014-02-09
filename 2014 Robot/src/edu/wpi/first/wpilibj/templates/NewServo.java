/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author Thomas
 */
public class NewServo implements IStep{
    Servo servo;
    int port;
    public void init() {
        servo = new Servo(port);
        SmartDashboard.putNumber("servoValue", 0);
    }
    public void step() {
        servo.set(SmartDashboard.getNumber("servoValue"));
    }
    public NewServo setPort(int slot){
        port = slot;
        return this;
    }
    
}
