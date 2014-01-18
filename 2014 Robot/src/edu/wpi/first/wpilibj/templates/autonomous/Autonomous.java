/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.autonomous;

import edu.wpi.first.wpilibj.templates.IStep;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.*;
/**
 *
 * @author Thomas
 */
public class Autonomous implements IStep{
    public Autonomous(){
        run = new Chain(new Action[]{
            //list actions here
            new DriveAction(0.75,0.0),
            new UltrasonicWaitAction(true, 70),
            new DriveAction(0.0,0.0),
        });
        doneAllActs = false;
    }
    private Chain run;
    private boolean doneAllActs;
    public void step(){
        //If all acts are not done
        if(!doneAllActs){
            //Step the current act
            //The doAct method of the Chain "run" returns true when all acts in
            //the chain are done.
            doneAllActs = run.doAct();
        }
    }
}
