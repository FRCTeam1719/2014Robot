package edu.wpi.first.wpilibj.templates.autonomous;

import edu.wpi.first.wpilibj.templates.IStep;
import edu.wpi.first.wpilibj.templates.autonomous.autoactions.*;

public class Autonomous implements IStep {
    //ssssshhh
    public Autonomous() {

    }
    private Chain run;
    private boolean doneAllActs;
    private final boolean ARM_DOWN = false;
    private final boolean ARM_UP = true;
    private final boolean KICK_BACK = false;
    private final boolean KICK_FORWARD = true;
    private final double SPEED = 1.0;
    private final double ROTATION = -1.0;
    private final double TIME_2S = 2000.0;  //in milis
    private final int TIME_1S = 1000;
    private final double ARM_DOWN_WAIT_TIME = 2.5;

    public void init() {
        run = new Chain(new Action[]{
          //  new TimerWaitAction(2.5),   // wait for the ball to drop
            new IntakeArmAction(ARM_UP), // lift the intake arm
            new ArcadeDriveAction(SPEED, ROTATION, TIME_2S), // drive forward for a period of time
            new ArcadeDriveAction(0.0, 0.0, 0), // stop driving
            new IntakeArmAction(ARM_DOWN), // lower the intake arm
            new TimerWaitAction(ARM_DOWN_WAIT_TIME),   // wait to allow the arm to get out of the way
            new HotGoalWaitAction(),
            new ShooterAction(KICK_BACK, (int) TIME_2S), // raise the kicker
            //Out of time in auton mode
            new ShooterAction(KICK_FORWARD, TIME_1S) // kick
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
