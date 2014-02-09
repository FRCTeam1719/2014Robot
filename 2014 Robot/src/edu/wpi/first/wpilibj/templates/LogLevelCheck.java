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
    

    
    public static Integer none=new Integer(1);
    public static Integer sensor=new Integer(2);
    public static Integer physical=new Integer(3);
    public static Integer all=new Integer(4);
    
    
    
    public void sendLog(String loggingMessage,Integer logLevel) {
            Integer logLevelInti = (Integer) RobotTemplate.logLevel.getSelected();
            Integer userLogLevel = logLevelInti;
            if(logLevel.intValue() <= userLogLevel.intValue()){
                Devices.logger.sendMessage(loggingMessage);
            }            
    }
    
    
    
}
