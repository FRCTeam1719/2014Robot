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
    
    int pressureSwitchSlot;
    int pressureSwitchChannel;
    int compresssorRelaySlot; 
    int compressorRelayChannel; 
    
    Compressor compressor; 
    
    /*
     * Creates and starts a new Compressor
     */
    public void init() {
       compressor = new Compressor(pressureSwitchSlot,pressureSwitchChannel,compresssorRelaySlot,compressorRelayChannel);
       compressor.start();
    }
    public CompressorController setPressureSwitchSlot(int psl){
        pressureSwitchSlot = psl;
        return this;
    }
     public CompressorController setPressureSwitchChannel(int psc){
        pressureSwitchChannel = psc;
        return this;
    }
      public CompressorController setCompressorRelaySlot(int crs){
        compresssorRelaySlot = crs;
        return this;
        
    }
       public CompressorController setCompressorRelayChannel(int crc){
        compressorRelayChannel = crc;
        return this;
        
    }
    
}
