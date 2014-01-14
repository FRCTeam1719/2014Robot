/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Zach
 */
public class Log {

    public String logMessage;
    
    public void sendLog() {
        
        SmartDashboard.putString("Log",logMessage);
        System.out.println("Log transfered");
        
    }
    
}
