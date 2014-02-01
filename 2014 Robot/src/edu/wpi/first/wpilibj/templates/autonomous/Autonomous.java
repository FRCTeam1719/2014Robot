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
        
    }
    private Chain run;
    private boolean doneAllActs;
    //Called during Device's step() method, which is called in RobotTemplate's
    //autonomousPeriodic method.
    public void init(){
        run = new Chain(new Action[]{
            //ArcadeDriveAction takes 2 ints. The first should be positive if
            //  you want to go forward, negative if you want to go backwards, 0
            //  if you don't want to move. The second should be positive if you
            //  want to turn left, negative if you want to turn right, 0 if you
            //  want to go straight.
            //UltrasonicWaitAction takes a boolean and an int. The boolean
            //  should be true if you want to wait until you are within a
            //  certain distance of an object, and false if you want to wait
            //  until you are a certain distance away from an object. The int is
            //  how far away from the object you want to be, in centimeters (we
            //  think).
            //TimerWaitAction takes a double: how long to wait (in seconds).
            //!!!AS OF NOW, HotGoalWaitAction AND ShooterAction DO NOTHING!!!
            //List actions here in the order in which you want them to happen.
            //Choose from the actions listed above.
            new ArcadeDriveAction(0.75,0.0),//Drive straight forward at 75%
            new UltrasonicWaitAction(true, 300),//Wait until within 3m of object
            new ArcadeDriveAction(0.0,0.0),//Stop driving (drive at 0% speed)
            new HotGoalWaitAction(),//Wait for goal to become hot (NOT WORKING)
            new ShooterAction()//Shoot the ball (NOT WORKING)
        });
        doneAllActs = false;
        run.init();
    }
    public void stop(){
        //This method is called by teleopInit in RobotTemplate to prevent
        //autonomous from being run in teleop. It can also be used to emergency-
        //stop autonomous.
        doneAllActs = true;
    }
    public void step(){
        //If all acts are not done...
        if(!doneAllActs){
            //...step the current act.
            doneAllActs = run.doAct();
            //The doAct method of the Chain "run" returns true when all acts in
            //the chain are done.
        }
    }
}
