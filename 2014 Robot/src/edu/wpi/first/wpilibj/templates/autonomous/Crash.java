/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.autonomous;

/**
 *
 * @author Zach
 */
public class Crash extends Action{

    public boolean doAct() {
        throw new RuntimeException("Crashing on purpose.");
    }
    
    
    
}
