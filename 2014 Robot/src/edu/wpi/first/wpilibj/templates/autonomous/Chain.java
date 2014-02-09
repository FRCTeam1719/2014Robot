package edu.wpi.first.wpilibj.templates.autonomous;

/**
 * This class provides a basic way to combine actions into more complicated ones,
 * by running them in sequence
 */
public class Chain extends Action{
    Action[] actions;
    boolean done=false;
    int index = 0;
    public Chain(Action[] acts){
        actions=acts;
    }
    public void init(){
        index=0;
    }
    public boolean doAct(){
        if(done){
            return true;
        }
        if(actions[index].doAct()){
            index++;
            if(index!=actions.length){
                actions[index].init();
            }else{
                done=true;
            }
        }
        return done;
    }
}
