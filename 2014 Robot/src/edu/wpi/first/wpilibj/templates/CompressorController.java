/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.parsing.IDevice;
import edu.wpi.first.wpilibj.SensorBase;

/**
 *
 * @author Zach
 */
public class CompressorController implements IStep{

    /*
     * Step doesn't do anything, because the compressor class already does the thredding.
     */
    public void step() {
        
    }
    
    int pressureSwitchSlot = 1;
    int pressureSwitchChannel = 1;
    int compresssorRelaySlot = 1;
    int compressorRelayChannel = 1;
    
    Compressor compressor; 
    
    /*
     * Creates and starts a new Compressor
     */
    public void init() {
       compressor = new Compressor(pressureSwitchSlot,pressureSwitchChannel,compresssorRelaySlot,compressorRelayChannel);
       compressor.start();
    }
}
