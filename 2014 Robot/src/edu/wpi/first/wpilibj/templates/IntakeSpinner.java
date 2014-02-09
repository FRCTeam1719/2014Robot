/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author aaroneline
 */

public class IntakeSpinner implements IStep{

    
    
    private int relayPort1;
    private int relayPort2;
    private int function;
    private final int STOP_RELAYS = 0;
    private final int FORWARD_RELAYS = 1;
    private final int BACKWARDS_RELAYS = 2;
    Relay relay1;
    Relay relay2;
    
    
    
    public void step(){
        if(function == STOP_RELAYS){
            //Stop relays
            relay1.set(Relay.Value.kOff);
            relay2.set(Relay.Value.kOff);
        }else if(function == FORWARD_RELAYS){
            //Move forwards
            relay1.set(Relay.Value.kForward);
            relay2.set(Relay.Value.kReverse);
        }else if(function == BACKWARDS_RELAYS){
            //Move backwards
            relay1.set(Relay.Value.kReverse);
            relay2.set(Relay.Value.kForward);
        }    
    }
    
    
    
    public void init(){
        //Open relays, set them all as bidirectional, then tell them to stop
        relay1 = new Relay(relayPort1);
        relay2 = new Relay(relayPort2);
        relay1.setDirection(Relay.Direction.kBoth);
        relay2.setDirection(Relay.Direction.kBoth);
        function = STOP_RELAYS;
    }
    
    
    
    public void setRelayPorts(int port1, int port2){
        relayPort1 = port1;
        relayPort2 = port2;
    }
    
    
    
    public void setDirection(int function){
        this.function = function;
    }
    
    
    
}
