/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Chance
 */
public class ShooterController implements IStep {

    private double distanceBack = DISTANCE_SHORT;
    private NewSolenoid solonoid;
    private int solonoidPort;
    private int motorPort;
    private long timeToReEngage = 0;
    private SetPointMotor motor;
    private int firingMode = 0;
    private int potentiometerPort = 0;
    private final boolean SHIFTER_ENGAGED = true; //Signal to the solenoid for the motor to engage the gear
    private long timeToFire = 1000;
    private Timer saftyTimeout = new Timer();
    private double maxTime = 2;
    public final int MODE_IDLE = 0;
    public final int MODE_COCKING = 1;
    public final int MODE_FIRING = 2;
    public final int MODE_LOWERING_ARM = 3;
    public final static double DISTANCE_SHORT = 3.6;
    public final static double DISTANCE_MEDIUM = 3.6;
    public final static double DISTANCE_LONG = 3.6;
    public final static double ALL_THE_WAY_FORWARD = .7;
    public final static double DISTANCE_IDLE = 2.2;
    public final static double BACK_SPEED = 1;
    public final static double FORWARD_SPEED = 1;
    private final double LOWER_ARM_TIME = .75;
    private Timer lowerArmTimer = new Timer();

    public void setBack(boolean isGoingBack) {
        if (isGoingBack) {
            motor.setSpeed(BACK_SPEED);
        } else {
            motor.setSpeed(FORWARD_SPEED);
        }
        motor.isGoingBack = isGoingBack;
    }

    public void step() {
        
        switch (firingMode) {
            case (MODE_IDLE):
                motor.disable();
                setBack(true);
                //motor.setPoint(DISTANCE_IDLE);
                break;
            case (MODE_LOWERING_ARM):
                motor.isGoingBack = false;
                motor.enable();
                motor.setSpeed(.125);
//                motor.setPoint(DISTANCE_IDLE);
                
                motor.setPoint(1);
                if (lowerArmTimer.get() > LOWER_ARM_TIME) {
                  
                    firingMode = MODE_COCKING;
                    
                    saftyTimeout.reset();
                    saftyTimeout.start();
                }
                break;
            case (MODE_COCKING):
                motor.isGoingBack = true;
                motor.setPoint(distanceBack);
                motor.setSpeed(1);
                motor.enable();
                motor.step();
                System.out.println("Is at point: " + motor.getIsAtPoint());
                if (saftyTimeout.get() > maxTime) {
                    firingMode = MODE_IDLE;
                    motor.disable();
                }
                solonoid.set(SHIFTER_ENGAGED);

                if (motor.getIsAtPoint()) {
                    firingMode = MODE_FIRING;
                    timeToReEngage = System.currentTimeMillis() + timeToFire;
                    saftyTimeout.reset();
                    saftyTimeout.start();

                }

                break;
            case (MODE_FIRING):
                if (saftyTimeout.get() > maxTime) {
                    firingMode = MODE_IDLE;
                    motor.disable();
                }
                solonoid.set(!SHIFTER_ENGAGED);
                setBack(false);
                motor.setPoint(ALL_THE_WAY_FORWARD);

                motor.step();
                if (motor.getIsAtPoint()) {
                    firingMode = MODE_IDLE;
                }

        }
        motor.step();
        solonoid.step();
        if (SmartDashboard.getBoolean("KickerTestMode") == true) {
            distanceBack = SmartDashboard.getNumber("Kicker Target");
        }
        SmartDashboard.putNumber("Kicker Potentiometer: ", motor.getPotVal());
    }

    public void init() {
        SmartDashboard.putNumber("Kicker Target", 2.5);
        solonoid = new NewSolenoid()
                .setPort(solonoidPort);
        motor = new SetPointMotor()
                .setMotorPort(motorPort)
                .setPotentiometerPort(potentiometerPort)
                .setSpeed(1)
                .setIsRatchet(false)
                .init();
    }

    public void setSolonoidPort(int solonoidPort) {
        this.solonoidPort = solonoidPort;
    }

    public void setMotorPort(int motorPort) {
        this.motorPort = motorPort;
    }

    public void setPotentiometerPort(int potentiometerPort) {
        this.potentiometerPort = potentiometerPort;
    }

    public void fire() {
        Devices.intakeArm.setArmUp(false);
        motor.isGoingBack = true;
        motor.setPoint(distanceBack);
        System.out.println("distanceBack: " + distanceBack);
        if (firingMode == MODE_IDLE) {
            firingMode = MODE_LOWERING_ARM;
        }
        lowerArmTimer.reset();
        lowerArmTimer.start();
    }

    public void setDistanceBack(double value) {
        //distanceBack = value;
    }

    public boolean isIdle() {
        return firingMode == MODE_IDLE;
    }
}
