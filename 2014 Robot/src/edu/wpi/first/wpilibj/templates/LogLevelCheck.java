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
    public static Integer physical=new Integer(2);
    public static Integer sensor=new Integer(3);
    public static Integer all=new Integer(4);
    private static int userLogLevel;
    
    
    public void sendLog(String loggingMessage,Integer logLevel) {
            //TODO: This needs to be tested, some logic was modified.
            //In its previous state, this if was always triggered
            
            if(logLevel.intValue() <= userLogLevel){
                Devices.logger.sendMessage(loggingMessage);
            }            
    }
    public static void setUserLogLevel(int level){
        userLogLevel = level;
    }
    
    
}
