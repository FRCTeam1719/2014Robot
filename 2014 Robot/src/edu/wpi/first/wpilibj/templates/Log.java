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

public class Log implements IStep{

    StringBuffer logMessage = new StringBuffer();
    
    
    public void sendMessage(String message){
        //Apends message to the queue of log messages
        logMessage.append(", ").append("[").append(System.currentTimeMillis()/3600000).append(":").append(System.currentTimeMillis()/600000).append("]").append(" ") .append(message).append("\r\n");
    }
    

    
    public void send() {
        //Tests to see if the queue is empty, and then sends the next queue of logs to the Dashboard
        if(SmartDashboardReader.getString("Log").equals("")) {
            SmartDashboardReader.putString("Log",logMessage.toString());
            logMessage = new StringBuffer();
        }
    }
     
    
    
    public void step(){
        send();
     }
}
    

