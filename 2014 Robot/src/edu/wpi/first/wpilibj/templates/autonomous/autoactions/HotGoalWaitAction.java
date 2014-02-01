/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.autonomous.autoactions;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

/**
 *
 * @author Thomas
 */
public class HotGoalWaitAction extends Action{
    Timer timer;
    public HotGoalWaitAction(){
        timer = new Timer();
        timer.reset();
        timer.start();
    }
    public boolean doAct() {
        boolean toReturn = false;
        //Returns true if we've found the target or it's 9 seconds into 
        //autonomous and we should shoot no matter what.
        toReturn = (SmartDashboard.getBoolean("found"))||(timer.get()>=9);
        return toReturn;
    }
}
