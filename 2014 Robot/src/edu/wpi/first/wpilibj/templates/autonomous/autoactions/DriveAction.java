/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.autonomous.autoactions;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.*;

/**
 *
 * @author Thomas
 */
public class DriveAction extends Action{
    public DriveAction(double moveX, double rotation){
        xMove = moveX;
        rotate = rotation;
    }
    public void init(){
        //MY HANDS ARE TYPING WORDS
    }
    double xMove;
    double rotate;
    public boolean doAct(){
        //Drive forward
        Devices.drive.moveArcade(-xMove, rotate);
        return true;
        //HAAAAAAAAAAAAAANDS
    }
}
