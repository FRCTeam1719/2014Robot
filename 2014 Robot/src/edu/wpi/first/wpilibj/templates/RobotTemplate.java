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
    
    
    Devices devices = new Devices();
    static Controller controller = new Controller();;
    public static boolean shouldLiveWindow = false;
    public void robotInit() {
       SmartDashboard.putNumber("gyro", 0);
        SmartDashboard.putBoolean("KickerTestMode", false);
        SmartDashboard.putBoolean("resetGyro",false);
        SmartDashboard.putNumber("rotationlessen", 180);
        //Create new SendableChooser, with two options.
        
        
        
        //Test Mode boolean
        
        
        
        
        //TODO magic numbers
        controller.set(1).init();
        devices.init();
    }
    
    
    public void autonomousInit(){      
       SmartDashboard.putBoolean("isAtonomus", true);
       Devices.autonomous.init();
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Devices.autonomous.step();
        devices.step();
        
//        double speed=SmartDashboard.getNumber("TargetSpeed");
//        devices.drive.DriveStraight(speed);
    }
    public void teleopInit(){
        SmartDashboard.putBoolean("isAtonomus", false);
         
       
    }
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        controller.step();
        Devices.operatorController.step();
        devices.step();
        //TODO: magic numbers
//        devices.drive.DriveStraight(400);
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
        if(!SmartDashboardReader.getBoolean("shouldLiveWindow", false)){
        SmartDashboardReader.putBoolean("~STATUS~/LW Enabled", false, false);
        }
        
        
        
    }
    
    
}
