// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
// Docs: shttps://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/wpilibj/DoubleSolenoid.html
import edu.wpi.first.wpilibj.PneumaticsModuleType;
// Docs: https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/wpilibj/DoubleSolenoid.Value.html
// possible Values:
//    Value.kForward
//    Value.kOff
//    Value.kReverse
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;

public class ClawPneumaticSubsystem extends SubsystemBase {
  /** Creates a new ClawPneumaticSubsystem. */

  public DoubleSolenoid doubleSolenoid;
  

  public ClawPneumaticSubsystem() {
    //NOTE: IF WE CHANGE THE PNEUMATICS MODULE TYPE THEN WE HAVE TO ALSO CHANGE THE VALUE HERE TO THE ACCORDING MODULE TYPE
    doubleSolenoid = new DoubleSolenoid(
          Constants.PNEUMATIC_HUB_CANID,  // CAN ID for the pneumatics (Used in order for the roborio to know where to interact with the pneumatics)
          PneumaticsModuleType.CTREPCM, // The Pneumatics control module type (CTRE pneumatics control module)
          Constants.CLAW_CLOSE_CHANNEL, // Close channel value
          Constants.CLAW_OPEN_CHANNEL); // Open channel value 
  }

  // Opens Claw
  public void setOpen () {
    doubleSolenoid.set(Value.kForward); // Sets the double solenoid to open the claw
    
  }
  
  // Closes claw 
  public void setClosed () {
    doubleSolenoid.set(Value.kReverse); // Sets the double solenoid to close the claw
  }

  // Switches the current position of the claw (If we are open, then we close and vice versa)
  public void toggle() {
    doubleSolenoid.toggle(); // changes current double solenoid value to the opposite value
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
