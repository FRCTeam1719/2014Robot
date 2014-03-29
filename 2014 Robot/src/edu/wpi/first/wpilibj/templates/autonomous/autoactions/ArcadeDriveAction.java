package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArcadeDriveAction extends Action{
    double xMove;
    double rotate;
    public ArcadeDriveAction(double moveX, double rotation){
        xMove = moveX;
        rotate = rotation;
    }
    public void init(){
        Devices.gyro.reset();
    }
    public boolean doAct(){
        Devices.logChecker.sendLog("Autonomous Drive: speed="+xMove+",rotation="+rotate, LogLevelCheck.physical);
        Devices.drive.moveArcade(-xMove, Devices.gyro.getAngle()/180);
        System.out.println(Devices.gyro.getAngle());
        SmartDashboard.putNumber("gyro", Devices.gyro.getAngle());
        return false;
    }
}
