// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ArmMotorSubsystem extends SubsystemBase {
  /** Creates a new ArmMotorSubsystem. */
  
  // Creates a talonfx arm motor
   private static TalonFX armMotor; 

  public ArmMotorSubsystem() {
    armMotor = new TalonFX(Constants.ARM_MOTOR_CHANNEL);
  }
  
  // Sets arm motor speed to pick up a cone
  public static void setArmToCone() {
    armMotor.set(ControlMode.PercentOutput, 0.2);
  }

  // Sets arm motor speed to pick up a cube
  public static void setArmToCube() {
    armMotor.set(ControlMode.PercentOutput, 0.2);
  }

  public static void setArmToIdle () {
    armMotor.set(ControlMode.PercentOutput, 0.2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // Joystick hatJoystickArmRotation = (Constants.HAT_JOYSTICK_TRIM_ROTATION_ARM == Constants.LEFT_JOYSTICK_CHANNEL) // If the arm hat joystick is binded to the left joystick...
    //   ? RobotContainer.leftJoystick // Then it is set to the left joystick
    //   : RobotContainer.rightJoystick; // If it isn't equal, then the hatjoystick is set to the right joystick
  }
}
