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


public class ArmPneumaticSubsystem extends SubsystemBase {

  public DoubleSolenoid doubleSolenoid;
  public boolean isExtended;

  /** Creates a new ArmPneumaticSubsystem. */
  public ArmPneumaticSubsystem() {
    //NOTE: IF WE CHANGE THE PNEUMATICS MODULE TYPE THEN WE HAVE TO ALSO CHANGE THE VALUE HERE TO THE ACCORDING MODULE TYPE
    doubleSolenoid = new DoubleSolenoid(
      Constants.PNEUMATIC_HUB_CANID, // CAN ID for the pneumatics (Used in order for the roborio to know where to interact with the pneumatics)
      PneumaticsModuleType.CTREPCM, // The Pneumatics control module type (CTRE pneumatics control module)
      Constants.ARM_EXTEND_CHANNEL, // Extend channel value
      Constants.ARM_RETRACT_CHANNEL); // Retract channel value

      isExtended = doubleSolenoid.get() == Value.kForward; // isExtended is true or false depending if the current doubleSolenoid value is the same as the kForward value
  }

  // Returns getIsExtended
  public boolean getIsExtended () {
    return isExtended;
  }

  // Retracts the arm pneumatics 
  public void retract () {
    // commands solenoid to the reverse position of the solenoid actuator
    // Note: Forward Solenoid position is the same as the retracted position for robot design
    doubleSolenoid.set(Value.kReverse);
    isExtended = false; // Sets isExtended to false
    
  }

  // Extends the arm pneiumatics
  public void extend () {
    // commands solenoid to the forward position of the solenoid actuator
    // Note: Forward Solenoid position is the same as the extended position for robot design
    doubleSolenoid.set(Value.kForward);
    isExtended = true; // Sets isExtended to true
  }

  // Switches current position of the arm to opposite (if we are extended, we retract and vice versa)
  public void toggle () {
    doubleSolenoid.toggle(); // Sets the solenoid to the opposite value
    isExtended = !isExtended; // Sets is extended to the opposite value
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
