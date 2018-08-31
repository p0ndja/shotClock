package me.palapon2545.SMD.SchoolProject.basketballLeague.shortClock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Clock {

	public static boolean isClockPause = true;
	public static boolean isTimeOutClockPause = true;
	public static boolean isSubClockPause = true;

	public static int i = 1;

	public static int timeOutStartI = 1;
	public static int subClockStartI = 1;

	public static int PercentCalculate(int second) {
		int percent = 100 - ((second * 100) / Main.timeStart);
		return percent;
	}

	public static String CalculateTimer(int timeInSecond) {
		long c = timeInSecond;
		long minute = c / (60);
		long second = c % (60);
		String mm = minute + "";
		String ss = second + "";

		if (minute < 10)
			mm = "0" + minute;
		if (second < 10)
			ss = "0" + second;

		return mm + ":" + ss;
	}

	public static void run() {
		DateFormat normalTimeFormat = new SimpleDateFormat("HH:mm:ss");
		String Time = "<" + normalTimeFormat.format(new Date()) + "> ";

		int m = 10;

		// This part for TimeOut Clock
		// =====================================================================\\
		if (isTimeOutClockPause == false) {
			if (isClockPause == true && i != m) {
				i = i + 1;
				Main.announce(i + "");
			} else if (isClockPause == true && i == m) {
				i = 1;
			}

			if (i == timeOutStartI) {
				if (Main.timeTimeOut > 0) {
					TimeOutClockPopup.main.setText(CalculateTimer(Main.timeTimeOut) + "");
					Main.timeTimeOut--;
					Main.announce(Time + "timeOut set from " + Main.timeTimeOut + " -> " + (Main.timeTimeOut - 1));
				} else if (Main.timeTimeOut == 0) {
					TimeOutClockPopup.main.setText(CalculateTimer(Main.timeTimeOut) + "");
					Main.timeTimeOut--;
					Main.announce(Time + "timeOut set from " + Main.timeTimeOut + " -> 0");
					Main.playSound("timeOut.wav");
					// Clock.isTimeOutClockPause = true;
				} else {
					// Do nothing
				}
			}
		}
		// =====================================================================\\

		if (isClockPause != true) {
			// This part for millisecond
			// =====================================================================\\
			if (i < m) {
				if (Main.timeLeft == -1) {
					Main.label_milli.setText("0");
				} else {
					Main.label_milli.setText((m - i) + "");
				}
				i++;
				if (Main.timeLeft > 60) {
					Main.label_1.setForeground(Color.WHITE);
					Main.label_1.setText(CalculateTimer(Main.timeLeft));
					Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 600));
				}
			} else if (i == m) {
				i = 1;
			} else {
				i = m;
			}
			// =====================================================================\\

			// This part for Sub Clock
			// =====================================================================\\
			if (i == subClockStartI) {
				if (isSubClockPause != true) {
					if (Main.subClock > 0) {
						Main.label_2.setText(Main.subClock + "");
						int I = Main.subClock - 1;
						Main.announce(Time + "subClock set from " + Main.subClock + " -> " + I);
						Main.subClock = I;
					} else if (Main.subClock == 0) {
						Main.label_2.setText("**");
						Main.announce(Time + "subClock set from " + Main.subClock + " -> " + 0);
						Main.subClock = -1;
						Main.playSound("timeOut.wav");
					}
				}
			}
			// =====================================================================\\

			// This part for Main Clock
			// =====================================================================\\
			if (i == m) {

				if (Main.timeLeft >= 60) {
					int I = Main.timeLeft - 1;
					Main.label_1.setForeground(Color.WHITE);
					Main.label_1.setText(CalculateTimer(Main.timeLeft));
					Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 600));
					Main.announce(Time + "[timeLeft] set from " + Main.timeLeft + " -> " + I + " ("
							+ PercentCalculate(Main.timeLeft) + "% complete)");
					Main.timeLeft = I;
					Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
					Main.label_milli.setVisible(false);
				} else if (Main.timeLeft < 60 && Main.timeLeft > 0) {
					Main.label_milli.setVisible(true);
					int I = Main.timeLeft - 1;
					Main.label_1.setForeground(Color.WHITE);
					Main.label_1.setText(Main.timeLeft + ".__");
					Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 600));
					Main.announce(Time + "[timeLeft] set from " + Main.timeLeft + " -> " + I + " ("
							+ PercentCalculate(Main.timeLeft) + "% complete)");
					Main.timeLeft = I;
					Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
				} else if (Main.timeLeft == 0) {
					Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 600));
					Main.label_1.setText(Main.timeLeft + ".__");
					Main.announce(Time + "[timeLeft] set from " + Main.timeLeft + " -> " + 0 + " ("
							+ PercentCalculate(Main.timeLeft) + "% complete)");
					Main.timeLeft = -1;
					Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
					Main.announce(Time + "[timeLeft] TIME UP!");
					Main.playSound("timeOut.wav");
					Main.label_milli.setText("0");

				} else {
					// Do nothing
				}

				Main.label_milli.setText((m - i) + "");
				i = 1;
			}
			// =====================================================================\\
		}
	}
}