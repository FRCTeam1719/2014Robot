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

    public void step() {
        
    }
    
    int pressureSwitchSlot = 2;
    int pressureSwitchChannel = 7;
    int compresssorRelaySlot = 2;
    int compressorRelayChannel = 2;
    
    Compressor compressor; 
    
    public void init() {
       compressor = new Compressor(pressureSwitchSlot,pressureSwitchChannel,compresssorRelaySlot,compressorRelayChannel);
       compressor.start();
    }
}
