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
        //Constructor accepts array of Actions; class variable "actions" becomes
        //that array.
        actions=acts;
    }
    public void init(){
        i=0;
    }
    int i = 0;
    //doAct is called in Autonomous' step() method and returns false if not done
    //all acts.
    public boolean doAct(){
        //If the current act has been finished... (steps current act, too)
        if(actions[i].doAct()){
            //...move on to the next act.
            i++;
            //If that wasn't the last act...
            if(i!=actions.length){
                //...initialize the next act.
                actions[i].init();
            }
        }
        //Return if we have moved on past the final act. (If true, stop stepping
        //all acts.)
        return i==actions.length;
    }
}
