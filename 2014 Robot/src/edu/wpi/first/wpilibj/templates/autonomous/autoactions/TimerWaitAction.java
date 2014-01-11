/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.autonomous.autoactions;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

/**
 *
 * @author Thomas
 */
public class TimerWaitAction extends Action{
    public TimerWaitAction(double timeAmt){
        timer = new Timer();
        waitTime = timeAmt;
    }
    double waitTime;
    Timer timer;
    public void init(){
        timer.reset();
        timer.start();
    }
    public boolean doAct(){
        System.out.println(timer.get());
        return timer.get()>=waitTime;
    }
}
