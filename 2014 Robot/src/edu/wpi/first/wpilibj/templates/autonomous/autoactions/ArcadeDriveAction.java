package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.*;

public class ArcadeDriveAction extends Action{
    double xMove;
    double rotate;
    public ArcadeDriveAction(double moveX, double rotation){
        xMove = moveX;
        rotate = rotation;
    }
    public boolean doAct(){
        Devices.logChecker.sendLog("Autonomous Drive: speed="+xMove+",rotation="+rotate, LogLevelCheck.physical);
        Devices.drive.moveArcade(-xMove, rotate);
        return true;
    }
}
