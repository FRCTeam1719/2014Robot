/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author Zach
 */
public class LogLevelCheck {
    
    
    
    public void sendLog(String loggingMessage,int logLevel) {
        
            Integer logLevelInti = (Integer) RobotTemplate.logLevel.getSelected();
            int userLogLevel = logLevelInti.intValue();
        
            if(logLevel >= 4 && userLogLevel == 4){
                Devices.logger.sendMessage(loggingMessage);
            }
            if(logLevel >= 3 && userLogLevel == 3){
                Devices.logger.sendMessage(loggingMessage);
            }
            if(logLevel >= 2 && userLogLevel == 2){
                Devices.logger.sendMessage(loggingMessage);
            }
            if(logLevel >= 1 && userLogLevel == 1){
               
            }
            
    }
    
    
    
}
