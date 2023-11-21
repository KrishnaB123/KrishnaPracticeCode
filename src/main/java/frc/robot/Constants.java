// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  // joystick channels (Can change depending on what computer you're using)
  public static final int RIGHT_JOYSTICK_CHANNEL = 2; // The channel for the right joystick
  public static final int LEFT_JOYSTICK_CHANNEL = 0; // The channel for the left joystick 

  // Hat joystick 
  public static final int HAT_JOYSTICK_TRIM_POSITION = RIGHT_JOYSTICK_CHANNEL; // Binds the hat joystick used for the drive train to the right joystick (The hatjoystick is Used for precise drive train movements that wouldn't be possible with the regular joystick) 
  public static final int HAT_JOYSTICK_TRIM_ROTATION_ARM = LEFT_JOYSTICK_CHANNEL; // Binds the hat joystick used for the arm onto the left

  // pneumatic constants channels
  public static final int PNEUMATIC_HUB_CANID = 15; // CAN ID for the pneumatics (Used in order for the roborio to know where to interact with the pneumatics)
  public static final int CLAW_OPEN_CHANNEL = 5; // open and close channels for claw pneumatics
  public static final int CLAW_CLOSE_CHANNEL = 1;
  public static final int ARM_EXTEND_CHANNEL = 7; // Extend and retract channels for arm pneumatics
  public static final int ARM_RETRACT_CHANNEL = 0; // (These channels are used to pump air into the pistons to extend/retract the pistons depending on action wanted)

  // motor ID constants
  public static final int ARM_MOTOR_CHANNEL = 21; // TalonFX Arm motor channel ID

  // Left Joystick buttons
  public static final int CLAW_PNEUMATICS_TOGGLE_BUTTON = 1; // The trigger
  // Right Joystick buttons
  public static final int ARM_PNEUMATICS_TOGGLE_BUTTON = 1; // The trigger
  public static final int ARM_MOTOR_BUTTON = 2; 

}
