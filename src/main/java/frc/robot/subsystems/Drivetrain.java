/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMaster);
	WPI_TalonSRX leftSlave1 = new WPI_TalonSRX(RobotMap.leftSlave1);
	WPI_TalonSRX leftSlave2 = new WPI_TalonSRX(RobotMap.leftSlave2);
	WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMaster);
	WPI_TalonSRX rightSlave1 = new WPI_TalonSRX(RobotMap.rightSlave1);
  WPI_TalonSRX rightSlave2 = new WPI_TalonSRX(RobotMap.rightSlave2);
  
  DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  public Drivetrain(){
    leftSlave1.follow(leftMaster);
    leftSlave2.follow(leftMaster);
    rightSlave1.follow(rightMaster);
		rightSlave2.follow(rightMaster);
  }

  public void teleopDrive(double move, double turn){
    drive.arcadeDrive(move, turn);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Drive());
  }
}
