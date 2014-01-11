/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.autonomous.autoactions;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
/**
 *
 * @author Thomas
 */
public class ExampleAction extends Action{
    //Use this to initialize anything that needs initialization.
    public void init(){
        count = 0;
    }
    private int count;
    //All actions MUST override the abstract method doAct().
    //It should return "true" when done with its act.
    public boolean doAct(){
        //This example act must be stepped 5 times before it is done.
        System.out.println("Doing an example act");
        count++;
        boolean toReturn = false;
        if(count>=5){
            toReturn = true;
        }
        return toReturn;
    }
}
