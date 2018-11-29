/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7463.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.NidecBrushless;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends IterativeRobot {
//	private DifferentialDrive m_myRobot; 
	private WPI_VictorSPX leftMotor;
	private WPI_VictorSPX rightMotor;
	private NidecBrushless Brushless;
	private Joystick m_leftStick;
//	private ControlMode leftMotorControlMode;
//	private ControlMode rightMotorControlMode;
//	private Joystick m_rightStick;
//	private Joystick m_rightStickHorizontal;

	@Override
	public void robotInit() {
		leftMotor = new WPI_VictorSPX(0);
		rightMotor = new WPI_VictorSPX(1);
//		m_myRobot = new DifferentialDrive(leftMotor, rightMotor);
		m_leftStick = new Joystick(1);
//		m_rightStick = new Joystick(2);
//		m_rightStickHorizontal = new Joystick(3);
		Brushless = new NidecBrushless(2, 2);
		
		
//		setupVictors(leftMotor);
//		setupVictors(rightMotor);
	}

	@Override
	public void teleopPeriodic() {
//		m_myRobot.tankDrive(m_leftStick.getRawAxis(1), m_leftStick.getRawAxis(2));
//		leftMotor.set(m_leftStick.getRawAxis(1), 1);
//		rightMotor.set(m_leftStick.getRawAxis(2));
		leftMotor.set(m_leftStick.getRawAxis(1));
		rightMotor.set(m_leftStick.getRawAxis(2));
		Brushless.enable();
		Brushless.set(m_leftStick.getRawAxis(3));
	}
	
	public void setupVictors(WPI_VictorSPX victor) {
//		victor.enableDeadbandElimination(true);
		victor.configNeutralDeadband(.1);
		victor.setSafetyEnabled(false);
		victor.setExpiration(0.2f);
		victor.setInverted(false);
	}
}
