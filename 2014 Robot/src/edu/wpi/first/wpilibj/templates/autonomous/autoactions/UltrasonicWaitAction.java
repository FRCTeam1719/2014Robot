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
public class UltrasonicWaitAction extends Action{
    public UltrasonicWaitAction(boolean waitForLessThan, int dist){
        distance = dist;
        maxDist = waitForLessThan;
    }
    private int distance;
    private boolean maxDist;
    public boolean doAct() {
        boolean toReturn = false;
        //If you're waiting for the value to be less than something
        if(maxDist){
            //Return if the value is less than that something
            toReturn = Devices.uss.getValue()<distance;
        //If you're waiting for the value to be greater than something
        }else{
            //Return if the value is greater than that something
            toReturn = Devices.uss.getValue()>distance;
        }
        return toReturn;
    }
}
