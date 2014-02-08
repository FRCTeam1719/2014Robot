/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.templates.testmode.TestMode;

//TODO: what is the thingy printline

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    //TODO clean up, move portions into their own class
    static SendableChooser driveMode;
    static SendableChooser robot;
    static SendableChooser autoTransmision;
    static SendableChooser logLevel;
    public NetworkTable testTable = NetworkTable.getTable("LiveWindow");
    Devices devices = new Devices();
    static Controller controller = new Controller();;
    
    public void robotInit() {
       
        
        //Create new SendableChooser, with two options.
        driveMode = new SendableChooser();
        driveMode.addDefault("Arcade Mode", Integer.valueOf(1));
        driveMode.addObject("Tank Mode", Integer.valueOf(2));
        SmartDashboard.putData("Drive Mode Options", driveMode);
        
        autoTransmision = new SendableChooser();
        autoTransmision.addDefault("Automatic transmition", Integer.valueOf(1));
        autoTransmision.addObject("Manual transmition", Integer.valueOf(2));
        SmartDashboard.putData("Transmition options", autoTransmision);
        
        robot = new SendableChooser();
        robot.addDefault("compotition robot 1", Integer.valueOf(1));
        robot.addObject("test robot 1", Integer.valueOf(2));
        robot.addObject("test robot 2", Integer.valueOf(3));
        SmartDashboard.putData("robot", robot);
        

        //Leg Level
        logLevel = new SendableChooser();
        logLevel.addDefault("1 - Nothing", Integer.valueOf(1));
        logLevel.addObject("2 - Sensor Logs", Integer.valueOf(2));
        logLevel.addObject("3 - Physical Logs", Integer.valueOf(3));
        logLevel.addObject("4 - Everything", Integer.valueOf(4));
        SmartDashboard.putData("logLevel",logLevel);
        SmartDashboard.putString("Log", "");
        //Test
        
        //Test Mode boolean
        boolean shouldLiveWindow = false;
        SmartDashboard.putBoolean("shouldLiveWindow", shouldLiveWindow);
        
        
        
      controller.set(1).init();
        devices.init();
    }
    
    
    public void autonomousInit(){      
       SmartDashboard.putBoolean("isAtonomus", true);
        //Devices.autonomous.init();
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        devices.step();
       // Devices.autonomous.step();
    }
    public void teleopInit(){
        SmartDashboard.putBoolean("isAtonomus", false);
         
       // Devices.autonomous.stop();
    }
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        controller.step();
        devices.step();
    }
    
    /**
     * This function is called periodically during test mode
     */
    
    public void testInit() {
        Devices.testMode.init();
    }
    public void testPeriodic() {
        Devices.testMode.step();
        devices.step();
        if(!SmartDashboard.getBoolean("shouldLiveWindow")){
        testTable.putBoolean("~STATUS~/LW Enabled", false);
        }
        
        
        
    }
    
    
}
