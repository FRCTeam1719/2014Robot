package edu.wpi.first.wpilibj.templates.autonomous;

/**
 * This class represents an action that should be done over time
 * 
 */
public abstract class Action{
    /**
     * Called repeatedly until the action is finished
     * @return Returns true when the action is finished
     */
    abstract public boolean doAct();
    public void init(){};
}