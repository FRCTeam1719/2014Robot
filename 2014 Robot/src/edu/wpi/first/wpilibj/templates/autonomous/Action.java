/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.autonomous;

/**
 *
 * @author Thomas
 */
//Ancestor class for all autonomous actions
public abstract class Action{
    //All actions must implement doAct()...
    abstract public boolean doAct();
    //...and may override init() if they wish.
    public void init(){};
}