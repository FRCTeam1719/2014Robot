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

    public void bPressed() {
        Devices.intakeArm.reverseIntake();
    }

    public void yPressed() {
        Devices.shooterController.setDistanceBack(ShooterController.DISTANCE_LONG);
    }

    public void aPressed() {
       
    }

    public void xPressed() {
        Devices.shooterController.setDistanceBack(ShooterController.DISTANCE_SHORT);
    }

    public void leftBumperPressed() {
        System.out.println("left bumper pressed");
        Devices.intakeArm.setArmUp(false);
        Devices.intakeArm.runIntake();
    }

    public void rightBumperPressed() {
        System.out.println("right bumber pressed");
        Devices.intakeArm.setArmUp(true);
        Devices.intakeArm.stopIntake();
    }
}
