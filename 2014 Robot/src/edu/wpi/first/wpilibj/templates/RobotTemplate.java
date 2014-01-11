/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
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
    Devices devices = new Devices();
    public void robotInit() {
        devices.init();
    }
    
  

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        System.out.println("autonomousPeriodic");
        Devices.autonomous.step();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        System.out.println("teleopPeriodic");
        SmartDashboard.putNumber("aaron is stupid", 87); //Smartdashboard test
        step();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    public void step(){
        for(int i = 0; i<Devices.devices.length;i++){
            Devices.devices[i].step();
        }
    }
    
}
