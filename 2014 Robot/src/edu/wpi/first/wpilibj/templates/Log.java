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

    String logMessage;
    
    public void sendMessage(String message){
        
        logMessage += ", "+message;
        
    }
    
     public void send() {
        
        if(!logMessage.equals("")) {
            SmartDashboard.putString("Log",logMessage);
            System.out.println("Log sent");
        }else{
            
        }
    }
     
     public void refresh(){
         
         while(true) {
             
             Devices.logger.send();
             
         }
         
     }
    
}
    

