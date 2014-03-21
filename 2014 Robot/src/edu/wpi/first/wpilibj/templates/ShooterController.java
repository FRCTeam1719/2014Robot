/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Chance
 */
public class ShooterController implements IStep {

    private double distanceBack = 0;
    private NewSolenoid solonoid;
    private int solonoidPort;
    private int motorPort;
    private long timeToReEngage = 0;
    private SetPointMotor motor;
    private int firingMode = 0;
    private int potentiometerPort=0;
    
    private final boolean SHIFTER_ENGAGED = true; //Signal to the solenoid for the motor to engage the gear

    private long timeToFire = 1000;
    
    public final int MODE_IDLE = 0;
    public final int MODE_COCKING = 1;
    public final int MODE_FIRING = 2;

    public final static double DISTANCE_SHORT=2.5;
    public final static double DISTANCE_MEDIUM=2.5;
    public final static double DISTANCE_LONG=2.5;
    public final static double ALL_THE_WAY_FORWARD = 1.25;
    public final static double DISTANCE_IDLE=2.0;
    public void step() {
        switch (firingMode) {
            case (MODE_IDLE):
                motor.isGoingBack=true;
                motor.setPoint(DISTANCE_IDLE);
                break;
            case (MODE_COCKING):
                motor.enable();
                solonoid.set(SHIFTER_ENGAGED);
                
                if (motor.getIsAtPoint()) {
                    firingMode = MODE_FIRING;
                    timeToReEngage = System.currentTimeMillis() + timeToFire;
                }
                break;
            case (MODE_FIRING):
                System.out.println("fireing");
                solonoid.set(!SHIFTER_ENGAGED);
                motor.isGoingBack = false;
                motor.setPoint(ALL_THE_WAY_FORWARD);
                motor.step();
                if (motor.getIsAtPoint()) {
                    firingMode = MODE_IDLE;
                }
                
        }
        motor.step();
        solonoid.step();
        
        distanceBack=SmartDashboard.getNumber("Kicker Target");
        SmartDashboard.putNumber("Kicker Potentiometer: ", motor.getPotVal());
    }

    public void init() {
        SmartDashboard.putNumber("Kicker Target",2.5);
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
        motor.isGoingBack = true;
        motor.setPoint(distanceBack);
        firingMode=MODE_COCKING;
    }

    public void setDistanceBack(double value) {
        distanceBack = value;
    }
    public boolean isIdle(){
        return firingMode==MODE_IDLE;
    }
}
