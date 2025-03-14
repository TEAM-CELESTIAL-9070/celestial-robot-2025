package com.celestial.robot;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import static java.lang.Math.abs;

public class Robot extends TimedRobot {
    private final SparkMax leftRearMotor = new SparkMax(3, SparkLowLevel.MotorType.kBrushless);
    private final SparkMax leftFrontMotor = new SparkMax(1, SparkLowLevel.MotorType.kBrushless);

    private final SparkMax rightRearMotor = new SparkMax(2, SparkLowLevel.MotorType.kBrushless);
    private final SparkMax rightFrontMotor = new SparkMax(4, SparkLowLevel.MotorType.kBrushless);

    private final DifferentialDrive differentialDrive = new DifferentialDrive(value -> {
        leftRearMotor.set(value * -1.0);
        leftFrontMotor.set(value * -1.0);
    }, value -> {
        rightRearMotor.set(value);
        rightFrontMotor.set(value);
    });

    private final Joystick joystick = new Joystick(0);

    @Override
    public void teleopPeriodic() {
        double x = joystick.getX() * -1.0;
        double y = joystick.getY() * -1.0;

        double steer = x;
        if (x < 0) {
            steer -= (abs(y) * 0.2);
        } else {
            steer += abs(y) * 0.2;
        }

        //noinspection SuspiciousNameCombination
        differentialDrive.arcadeDrive(y, steer);
    }
}
