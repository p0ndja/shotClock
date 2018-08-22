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

	public static int i = 1;

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
		if (minute < 10) {
			mm = "0" + minute;
		}

		if (second < 10) {
			ss = "0" + second;
		}
		return mm + ":" + ss;
	}

	public static void run() {
		int m = 10;
		if (isClockPause == true) {

		} else {
			if (i < m) {

				if (Main.timeLeft == -1) {
					Main.label_milli.setText("0");
				} else {
					Main.label_milli.setText((m - i) + "");
				}
				
				i = i + 1;

			} else if (i == m) {

				DateFormat normalDateFormat = new SimpleDateFormat("yyyy/MM/dd");
				DateFormat normalTimeFormat = new SimpleDateFormat("HH:mm:ss");
				Date date = new Date();
				String Time = normalTimeFormat.format(date);
				String Date = normalDateFormat.format(date);

				/*
				 * if (Time.equalsIgnoreCase("23:59:59")) { Main.announce("DAY PASSED"); }
				 */

				String time_ = "<" + Time + "> ";

				if (Main.timeLeft >= 60) {
					int I = Main.timeLeft - 1;
					Main.label_1.setForeground(Color.WHITE);
					Main.label_1.setText(CalculateTimer(Main.timeLeft));
					Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 600));
					Main.announce(time_ + "[timeLeft] set from " + Main.timeLeft + " -> " + I + " ("
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
					Main.announce(time_ + "[timeLeft] set from " + Main.timeLeft + " -> " + I + " ("
							+ PercentCalculate(Main.timeLeft) + "% complete)");
					Main.timeLeft = I;
					Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
				} else if (Main.timeLeft == 0) {
					Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 600));
					Main.label_1.setText(Main.timeLeft + ".__");
					Main.announce(time_ + "[timeLeft] set from " + Main.timeLeft + " -> " + 0 + " ("
							+ PercentCalculate(Main.timeLeft) + "% complete)");
					Main.timeLeft = -1;
					Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
					Main.announce(time_ + "[timeLeft] set message to 'TIME UP!'");
					Main.playSound("timeOut.wav");
					Main.label_milli.setText("0");

				} else {
					// Do nothing
				}

				Main.label_milli.setText((m - i) + "");
				i = 1;

			} else {
				i = m;
			}
		}
	}
}