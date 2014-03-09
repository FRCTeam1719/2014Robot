/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author Chance
 */
public class OperatorController extends GenericController {

    public void step() {

        super.step();

    }

    public void triggerPressed() {
        Devices.shooterController.fire();
    }

    public void aPressed() {
        Devices.intakeArm.reverseIntake();
    }

    public void bPressed() {
        Devices.intakeArm.runIntake();
    }

    public void xPressed() {
        Devices.intakeArm.setArmUp(true);
    }

    public void yPressed() {
        Devices.intakeArm.setArmUp(false);
    }
}
