/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.autonomous.autoactions;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.autonomous.Action;

/**
 *
 * @author Thomas
 */
public class HotGoalWaitAction extends Action{
    public boolean doAct() {
        return SmartDashboard.getBoolean("found");
    }
}
