package edu.wpi.first.wpilibj.templates.testmode;

import edu.wpi.first.wpilibj.templates.NewEncoder;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
import edu.wpi.first.wpilibj.templates.Constants;

public class TestEncoderAction extends Action {

    NewEncoder encoder;
    double reference;
    int mode;
    String msg;
    TestResults acc;
    /**
     * 
     * @param encoder Encoder to test
     * @param reference Value to compare against
     * @param mode Comparison type. Defined by types.Types
     * @param msg Message for the accumulator
     * @param acc TestResults accumulator
     */
    public TestEncoderAction(NewEncoder encoder, double reference, int mode, String msg, TestResults acc) {
        this.encoder=encoder;
        this.reference=reference;
        this.mode=mode;
        this.msg=msg;
        this.acc=acc;
        
    }
    
    public boolean doAct() {
        boolean ans=false;
        switch (this.mode){
            case Constants.GREATER: ans=encoder.get()>reference; break;
            case Constants.LESSER: ans=encoder.get()<reference; break;
            case Constants.EQUAL: ans=encoder.get()==reference; break;
            default: msg=msg+" Programming error, unknown mode:"+mode; break;
        }
        acc.append(msg, ans);
        return true;
    }
}
