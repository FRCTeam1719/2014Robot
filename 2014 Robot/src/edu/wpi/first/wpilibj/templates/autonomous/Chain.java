/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.autonomous;

/**
 *
 * @author Thomas
 */
public class Chain extends Action{
    Action[] actions;
    public Chain(Action[] acts){
        actions=acts;
    }
    int i = 0;
    public boolean doAct(){
        //Step an act. If it has been finished
        if(actions[i].doAct()){
            //Move on to the next act
            i++;
            //If that wasn't the last act
            if(i!=actions.length){
                //Initialize the next act
                actions[i].init();
            }
        }
        return i==actions.length;
    }
}
