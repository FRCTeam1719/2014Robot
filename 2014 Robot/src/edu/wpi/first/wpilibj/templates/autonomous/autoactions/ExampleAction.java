package edu.wpi.first.wpilibj.templates.autonomous.autoactions;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
/**
 *
 * @author Thomas
 */
public class ExampleAction extends Action{
    //This will be called during the main RobotTemplate's robotInit().
    public ExampleAction(){
        
    }
    //This will be called once when the action starts.
    public void init(){
        
    }
    //This will be called repeatedly while the action is running, and will
    //continue being called repeatedly until you return "true".
    public boolean doAct(){
        return true;
    }
}
