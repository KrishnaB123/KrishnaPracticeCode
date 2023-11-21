// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmPneumaticSubsystem;

public class ArmPneumaticCommand extends CommandBase {
  
  private ArmPneumaticSubsystem armPneumaticSubsystem;
  private Timer timer;  
  private double startTime;
  private double currentTime;
  private double delay = 0.5; // How much time has to pass in order to call this command again
  
  /** Creates a new ArmPneumaticCommand. */
  public ArmPneumaticCommand(ArmPneumaticSubsystem armPneumaticSubsystem) {
    this.armPneumaticSubsystem = armPneumaticSubsystem;
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.armPneumaticSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armPneumaticSubsystem.toggle();
    timer.start();
    startTime = timer.get();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentTime = timer.get();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (currentTime-startTime >= delay) {
      return true;
    }
    return false;
  }
}
