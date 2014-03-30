package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.Dashboard;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArcadeDriveAction extends Action{
    double xMove;
    double rotate;
    double rotation = 0;
    public ArcadeDriveAction(double moveX, double rotation){
        xMove = moveX;
        
        rotate = rotation;
    }
    public void init(){
        Devices.gyro.reset();
    }
    public boolean doAct(){
        rotation = SmartDashboard.getNumber("rotationlessen");
        if(SmartDashboard.getBoolean("resetGyro")== true){
            Devices.gyro.reset();
            SmartDashboard.putBoolean("resetGyro", false);
        }
        Devices.logChecker.sendLog("Autonomous Drive: speed="+xMove+",rotation="+rotate, LogLevelCheck.physical);
        //Devices.drive.moveArcade(-xMove, rotation);
        Devices.drive.moveArcade(-xMove, Devices.gyro.getAngle()/rotation);
        //Devices.drive.moveArcade(-xMove, 0);
        System.out.println("rotation" + rotation);
        System.out.println(Devices.gyro.getAngle());
        SmartDashboard.putNumber("gyro", Devices.gyro.getAngle());
        return false;
    }
}
