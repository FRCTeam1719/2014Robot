/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



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
    public static SendableChooser testMode;
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
        
        
        
      controller.set(1).init();
        devices.init();
    }
    
    
    public void autonomousInit(){
        Devices.autonomous.init();
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
       // Devices.autonomous.step();
    }
    public void teleopInit(){
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
        GearShiftController.setIsTest(true);
        
    }
    public void testPeriodic() {
            
        testMode = new SendableChooser();
        //Menu
        testMode.addDefault("No Test", Integer.valueOf(0));
        testMode.addObject("All", Integer.valueOf(1));
        testMode.addObject("Motors", Integer.valueOf(2));
        testMode.addObject("pneumatics", Integer.valueOf(3));
        //Add more options as we understand more devices
        Devices.autonomous.step();
        
        
        
    }
    
    
}
