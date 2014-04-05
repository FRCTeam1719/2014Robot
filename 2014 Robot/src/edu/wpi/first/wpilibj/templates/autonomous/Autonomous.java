package edu.wpi.first.wpilibj.templates.autonomous;

import edu.wpi.first.wpilibj.templates.IStep;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.*;

public class Autonomous implements IStep {

    public Autonomous() {

    }
    private Chain run;
    private boolean doneAllActs;

    public void init() {
        run = new Chain(new Action[]{
            new TimerWaitAction(3),   // wait for the ball to drop
            new IntakeArmAction(true), // lift the intake arm
            new ArcadeDriveAction(0.75, 0.0, 1600.0), // drive forward for a period of time
            new ArcadeDriveAction(0.0, 0.0, 0), // stop driving
            new IntakeArmAction(false), // lower the intake arm
            new TimerWaitAction(3),   // wait to allow the arm to get out of the way
            new ShooterAction(false, 2500), // raise the kicker
     
            new ShooterAction(true, 1000) // kick
        });
        doneAllActs = false;
        run.init();
    }

    public void stop() {
        doneAllActs = true;
    }

    public void step() {
        if (!doneAllActs) {
            doneAllActs = run.doAct();
        }
    }
}
