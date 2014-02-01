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

    String logMessage;
    
    public void sendMessage(String message){
        
        //apends message to the queue of log messages
        logMessage += ", "+message;
        System.out.println(message);
        
    }
    
     public void send() {
        
        //tests to see if the queue is empty, and then sends the next queue of logs to the Dashboard
        if(!logMessage.equals("")) {
            SmartDashboard.putString("Log",logMessage);
            System.out.println("Log sent");
        }else{
            
        }
    }
     
     public void step(){
             send();
     }
    
}
    

