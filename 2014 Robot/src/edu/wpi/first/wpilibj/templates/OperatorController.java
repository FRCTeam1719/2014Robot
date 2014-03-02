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

    private final int SHORT_RANGE = 1;
    private final int MEDIUM_RANGE = 2;
    private final int LONG_RANGE = 3;
    public int fireRange = SHORT_RANGE;
    public boolean isFiring = false;

    public void step() {

        super.step();

        if (fireRange == SHORT_RANGE) {
            Devices.shooterController.setDistanceBack(ShooterController.DISTANCE_SHORT);
        } else if (fireRange == MEDIUM_RANGE) {
            Devices.shooterController.setDistanceBack(ShooterController.DISTANCE_MEDIUM);
        } else if (fireRange == LONG_RANGE) {
            Devices.shooterController.setDistanceBack(ShooterController.DISTANCE_LONG);
        }

    }

    public void triggerPressed() {
        isFiring = true;
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

    public void leftBumperPressed() {
        if (fireRange == MEDIUM_RANGE) {
            fireRange = SHORT_RANGE;
        } else if (fireRange == LONG_RANGE) {
            fireRange = MEDIUM_RANGE;
        }

    }

    public void rightBumperPressed() {
        if (fireRange == SHORT_RANGE) {
            fireRange = MEDIUM_RANGE;
        } else if (fireRange == MEDIUM_RANGE) {
            fireRange = LONG_RANGE;
        }
    }
}
