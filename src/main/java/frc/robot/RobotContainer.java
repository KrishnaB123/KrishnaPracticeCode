// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmMotorCommand;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ArmMotorSubsystem;
import frc.robot.subsystems.ArmPneumaticSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import commands.ArmPneumaticCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...

  // Subsystems are instantiated here
  public static final ArmMotorSubsystem m_armMotorSubsystem = new ArmMotorSubsytem();
  public static final ArmPneumaticSubsystem m_armPneumaticSubsytem = new ArmPneumaticSubsystem();
  public static final ClawPneumaticSubsystem m_clawPneumaticSubsystem = new ClawPneumaticSubsystem();

  // Commands are instantiated on here
  public static final ArmMotorCommand m_armMotorCommand = new ArmMotorCommand(m_armMotorSubsystem);
  public static final ArmPneumaticCommand m_armPneumaticCommand = new ArmPneumaticsCommand(m_armPneumaticSubsytem);
  public static final ClawPneumaticsCommand m_clawPneumaticsCommand = new ClawPneumaticsCommand(m_clawPneumaticSubsystem);

  // Joysticks
  public static final Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_CHANNEL); // Creates the right joystick
  public static final Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_CHANNEL); // Creates the left joystick

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

    // Left Joystick
    Trigger clawPneumaticToggleButton = new joystickButton(leftJoystick, Constants.CLAW_PNEUMATICS_TOGGLE_BUTTON); // The left trigger

    // Right joystick
    Trigger armPneumaticToggleButton = new joystickButton(rightJoystick, Constants.ARM_PNEUMATICS_TOGGLE_BUTTON); // The right trigger
    Trigger armMotorButton = new joystickButton(rightJoystick, Constants.ARM_MOTOR_BUTTON); // The 2nd button

    clawPneumaticToggleButton.onTrue(m_clawPneumaticsCommand); // Executes the claw pneumatics command when the trigger is pressed once
    armPneumaticToggleButton.onTrue(m_armPneumaticCommand); // Executes the arm pneumatics command when the trigger is pressed once
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
