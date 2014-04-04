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
            new ArcadeDriveAction(0.75, 0.0, 1300.0),//ArcadeDriveAction(forwardSpeed, rotationSpeed)
            new ArcadeDriveAction(0.0, 0.0, 0),
            new ShooterAction()

            //forwardSpeed ranges from -1 (backwards) to 1 (forwards)
        //rotationSpeed ranges from -1 (turn left) to 1 (turn right) (might be reversed)
        //new UltrasonicWaitAction(true, 150),//UltrasonicWaitAction(lessThan, distance)
//            new TimerWaitAction(2),
        //lessThan is if you want to wait for the distance to be less than the specified
        //  number as opposed to waiting for the distance to be greater than the
        //  specified number
        //distance is how far away/how close you want the robot to be when you stop moving
//            new ArcadeDriveAction(0.0,0.0),
//           new ShooterAction()
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
