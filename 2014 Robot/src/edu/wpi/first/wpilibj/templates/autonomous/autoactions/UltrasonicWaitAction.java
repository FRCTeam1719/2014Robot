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
        System.out.println(Devices.uss.getValue());
        if(maxDist){
            toReturn = distance>Devices.uss.getValue();
        }else{
            toReturn = distance<Devices.uss.getValue();
        }
        return toReturn;
    }
}
