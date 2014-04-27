package edu.wpi.first.wpilibj.templates.autonomous;

import edu.wpi.first.wpilibj.templates.IStep;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.*;

public class Autonomous implements IStep {

    public Autonomous() {

    }
    private Chain run;
    private boolean doneAllActs;
    private final boolean ARM_DOWN = false;
    private final boolean ARM_UP = true;
    private final boolean KICK_BACK = false;
    private final boolean KICK_FORWARD = true;

    public void init() {
        run = new Chain(new Action[]{
            new TimerWaitAction(2.5),   // wait for the ball to drop
            new IntakeArmAction(ARM_UP), // lift the intake arm
            new ArcadeDriveAction(0.75, 0.0, 1600.0), // drive forward for a period of time
            new ArcadeDriveAction(0.0, 0.0, 0), // stop driving
            new IntakeArmAction(ARM_DOWN), // lower the intake arm
            new TimerWaitAction(2.5),   // wait to allow the arm to get out of the way
            new ShooterAction(KICK_BACK, 2000), // raise the kicker
            //Out of time in auton mode
            new ShooterAction(KICK_FORWARD, 1000) // kick
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
