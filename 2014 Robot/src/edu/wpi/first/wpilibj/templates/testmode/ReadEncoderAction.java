/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.testmode;
import edu.wpi.first.wpilibj.templates.Devices;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
/**
 *
 * @author aaroneline
 */
public class ReadEncoderAction extends Action{
    String outputLabel;
    public ReadEncoderAction(String label){
        outputLabel = label;
    }
    public boolean doAct() {
        boolean toReturn = false;
        //System.out.println(outputLabel + ": " + Devices.wheelEncoder1.get());
        toReturn = true;
        return toReturn;
    }
}
