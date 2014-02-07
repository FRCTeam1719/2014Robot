/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.templates.testmode.TestMode;



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
    AxisCamera camera = AxisCamera.getInstance();
    static SendableChooser driveMode;
    static SendableChooser robot;
    static SendableChooser autoTransmision;
    static SendableChooser logLevel;
    public static SendableChooser testMode;
    NetworkTable testTable = NetworkTable.getTable("LiveWindow");
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
        logLevel.addDefault("1", Integer.valueOf(1));
        logLevel.addObject("2", Integer.valueOf(2));
        logLevel.addObject("3", Integer.valueOf(3));
        logLevel.addObject("4", Integer.valueOf(4));
        SmartDashboard.putData("logLevel",logLevel);
        SmartDashboard.putString("Log", "");
        //Test
        System.out.println("TestInit");
        GearShiftController.setIsTest(true);
        testMode = new SendableChooser();
        //Menu
        testMode.addDefault("No Test", Integer.valueOf(0));
        testMode.addObject("All", Integer.valueOf(1));
        testMode.addObject("Motors", Integer.valueOf(2));
        testMode.addObject("pneumatics", Integer.valueOf(3));
        //Add more options as we understand more devices
        ITable dataTable = testTable.getSubTable("Ungrouped");
        dataTable.putString("~TYPE", testMode.getSmartDashboardType());
        testMode.initTable(dataTable);
        
        
        
        
        
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
        //HttpWraper.send("http://10.17.19.11/sm/sm.srv?root_ImageSource_I0_Sensor_Contrast=100&action=modify");
        
        SmartDashboard.putBoolean("isAtonomus", false);
         
       // Devices.autonomous.stop();
    }
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //HttpWraper.send("http://10.17.19.11/sm/sm.srv?root_ImageSource_I0_Sensor_Contrast=50&action=modify");
        controller.step();
        devices.step();
    }
    
    /**
     * This function is called periodically during test mode
     */
    
    public void testInit() {
        System.out.println("TestInit");
        GearShiftController.setIsTest(true);
        testMode = new SendableChooser();
        //Menu
        testMode.addDefault("No Test", Integer.valueOf(0));
        testMode.addObject("All", Integer.valueOf(1));
        testMode.addObject("Motors", Integer.valueOf(2));
        testMode.addObject("pneumatics", Integer.valueOf(3));
        //Add more options as we understand more devices
        ITable dataTable = testTable.getSubTable("Ungrouped");
        dataTable.putString("~TYPE", testMode.getSmartDashboardType());
        testMode.initTable(dataTable);
        //tablesToData.put(testMode, "Test Mode Options");
    }
    public void testPeriodic() {
       TestMode test = new TestMode();
       test.init();
        
        
        
        
        
    }
    
    
}
