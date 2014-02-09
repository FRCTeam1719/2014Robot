package edu.wpi.first.wpilibj.templates.autonomous;

public class Crash extends Action{
    public boolean doAct() {
        throw new RuntimeException("Crashing on purpose.");
    }
}
