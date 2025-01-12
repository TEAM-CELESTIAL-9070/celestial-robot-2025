package com.celestial.robot.subsystem;

import edu.wpi.first.wpilibj2.command.Subsystem;

public abstract class CelestialSubsystem implements Subsystem {
    @Override
    public final void periodic() {
        loop(); // todo: add coherence utilities
    }

    abstract void loop();

    abstract void onCreate();

    abstract void onDestroy();
}