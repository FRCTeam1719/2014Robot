/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.testmode.TestMode;

/**
 *
 * @author aaroneline
 */
public class SmartDashboardReader implements IStep{

    
    //Sendable choosers
    public static SendableChooser driveMode;
    public static SendableChooser robot;
    public static SendableChooser autoTransmision;
    public static SendableChooser logLevel;
    public static SendableChooser testMode;
    private static final boolean SMARTDASHBOARD = true;
    private static final boolean LIVEWINDOW = false;
    
    //Grab the LiveWindow networktable, used for test mode
    public static NetworkTable testTable = NetworkTable.getTable("LiveWindow");
    public void step() {
        //Sendable choosers
        Controller.setDriveMode(getSelectedFromChooser(driveMode));
        TestMode.setTestNumber(getSelectedFromChooser(testMode));
        LogLevelCheck.setUserLogLevel(getSelectedFromChooser(logLevel));
        //NewServo.setServoValue(SmartDashboard.getNumber("servoValue"));
    }
    
    public void init(){
        
        startSendableChoosers();
        startVaribles();
        Devices.setSelectedRobot(getSelectedFromChooser(robot));
        
    }
    public int getSelectedFromChooser(SendableChooser chooser){
        int selected;
        Integer integer = (Integer) chooser.getSelected();
        selected = integer.intValue();
        return selected;
    }
    private void startSendableChoosers(){
     
        //Put sendable choosers here
        
        //Tank or arcade drive modes
        driveMode = new SendableChooser();
        driveMode.addDefault("Arcade Mode", Integer.valueOf(1));
        driveMode.addObject("Tank Mode", Integer.valueOf(2));
        SmartDashboard.putData("Drive Mode Options", driveMode);
        
        //Manual or Automatic transmision
        autoTransmision = new SendableChooser();
        autoTransmision.addDefault("Automatic transmition", Integer.valueOf(1));
        autoTransmision.addObject("Manual transmition", Integer.valueOf(2));
        SmartDashboard.putData("Transmition options", autoTransmision);
        
        //Robot port chooser
        robot = new SendableChooser();
        robot.addDefault("compotition robot 1", Integer.valueOf(1));
        robot.addObject("test robot 1", Integer.valueOf(2));
        robot.addObject("test robot 2", Integer.valueOf(3));
        SmartDashboard.putData("robot", robot);
        
        //Log Level
        logLevel = new SendableChooser();
        logLevel.addDefault("1 - Nothing", Integer.valueOf(1));
        logLevel.addObject("2 - Sensor Logs", Integer.valueOf(2));
        logLevel.addObject("3 - Physical Logs", Integer.valueOf(3));
        logLevel.addObject("4 - Everything", Integer.valueOf(4));
        SmartDashboard.putData("logLevel",logLevel);
        SmartDashboard.putString("Log", "");
        
        //Test Mode Selected
        testMode = new SendableChooser();
        testMode.addDefault("All Tests", Integer.valueOf(1));
        testMode.addObject("Drive Test", Integer.valueOf(2));
        SmartDashboard.putData("testMode", testMode);
    }
    
    private void startVaribles(){
        //Put smartdashboard varibles here
        //Weather or not to switch to the LiveWindow networktable during test mode
        SmartDashboard.putBoolean("shouldLiveWindow", RobotTemplate.shouldLiveWindow);
        
    }
    
    static public void putBoolean(String name, boolean value, boolean networktable){
        if(SMARTDASHBOARD){
            SmartDashboard.putBoolean(name, value);
        }else if(LIVEWINDOW){
            testTable.putBoolean(name, value);
        }
    }
    public static boolean getBoolean(String name, boolean networktable){
        boolean result;
        if(SMARTDASHBOARD){
            result = SmartDashboard.getBoolean(name);
        }
        else if(LIVEWINDOW){
            result = testTable.getBoolean(name);
        }
        return result;
    }
    public static void putString(String name, String value){
        SmartDashboard.putString(name, value);
    }
    public static void putDouble(String name, double value){
        SmartDashboard.putNumber(name, value);
    }
    
}
