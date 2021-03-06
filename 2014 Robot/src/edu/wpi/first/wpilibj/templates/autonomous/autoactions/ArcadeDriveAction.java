package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.Dashboard;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArcadeDriveAction extends Action{
    double xMove;
    double rotate;
    double rotation = 0;
    double origTime = 0;
    public boolean exit = false;
    public double time =0;
    double correctionValue;
    double gyroAngle;
    public ArcadeDriveAction(double moveX, double rotation, double time){
        this.time = time;
        
        xMove = moveX;
        
        rotate = rotation;
    }
    public void init(){
        Devices.gyro.reset();
        origTime = System.currentTimeMillis();
        System.out.println("origTime: " + origTime);
       
        
    }
    
    public boolean doAct(){
        Devices.gearShiftController.setFast(true);
        
        
        rotation = SmartDashboard.getNumber("rotationlessen");
        if(SmartDashboard.getBoolean("resetGyro")== true){
            Devices.gyro.reset();
            SmartDashboard.putBoolean("resetGyro", false);
        }
        Devices.logChecker.sendLog("Autonomous Drive: speed="+xMove+",rotation="+rotate, LogLevelCheck.physical);
        //Devices.drive.moveArcade(-xMove, rotation);
        //Old semi-working code
        //Devices.drive.moveArcade(-xMove, Devices.gyro.getAngle()/rotation);
        //New semi-working code
        
        gyroAngle = Devices.gyro.getAngle();
        correctionValue = -(gyroAngle/SmartDashboard.getNumber("Correction Value"));
        Devices.drive.moveArcade(-xMove, correctionValue);
        SmartDashboard.putNumber("Angle", correctionValue);
        System.out.println("Gryo, Correction: " + gyroAngle + "," + correctionValue);
        //Devices.drive.moveArcade(-xMove, 0);
        
        SmartDashboard.putNumber("gyro", Devices.gyro.getAngle());
        if((origTime + time)< System.currentTimeMillis()){
            //System.out.println("Time elapsed: " + (System.currentTimeMillis() - (origTime + time)));
            exit = true;
        }
        else {
            //System.out.println("Time not elapsed.");
        }
        return exit;
        
    }
}
