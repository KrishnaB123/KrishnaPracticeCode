// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmMotorSubsystem;

public class ArmMotorCommand extends CommandBase {

  private ArmMotorSubsystem armMotorSubsystem;
  private Timer timer;
  private double startTime;
  private double endTime;
  private double delay = 0.5; // Delay time before trying to do another command

  /** Creates a new ArmMotorCommand. */
  public ArmMotorCommand(ArmMotorSubsystem armMotorSubsystem) {
    this.armMotorSubsystem = armMotorSubsystem;
    addRequirements(this.armMotorSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
    startTime = timer.get();
    armMotorSubsystem.setArmToIdle();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    endTime = timer.get();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (endTime - startTime > delay) {
      return true;
    }
    return false;
  }
}
