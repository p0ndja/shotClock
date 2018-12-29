package me.palapon2545.SMD.SchoolProject.basketballLeague.shortClock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {

	public static boolean isClockPause = true;
	public static boolean isTimeOutClockPause = true;
	public static boolean isSubClockPause = true;

	public static int i = 1;

	public static int timeOutStartI = 1;
	public static int subClockStartI = 1;

	public static int PercentCalculate(int second) {
		return 100 - ((second * 100) / Main.timeStart);
	}

	public static String CalculateTimer(int timeInSecond) {
		int c = timeInSecond;
		int minute = c / (60);
		int second = c % (60);
		String mm = minute + "";
		String ss = second + "";

		if (minute < 10)
			mm = "0" + minute;
		if (second < 10)
			ss = "0" + second;

		return mm + ":" + ss;
	}

	public static void run() {

		String Time = "<" + (new SimpleDateFormat("HH:mm:ss").format(new Date())) + "> ";
		int m = 10;

		// This part for TimeOut Clock
		// =====================================================================\\
		if (isTimeOutClockPause == false) {
			if (isClockPause == true && i != m) {
				i++;
				Main.announce(i + "");
			} else if (isClockPause == true && i == m)
				i = 1;
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
				}
			}
		}
		// =====================================================================\\

		if (isClockPause != true) {
			// This part for millisecond
			// =====================================================================\\
			if (Main.timeLeft < 59 && Main.timeLeft > -1) {
				
				Main.label_milli.setVisible(true);
				
				if (Main.timeLeft == -1)
					Main.label_milli.setText("0");
				else
					Main.label_milli.setText((m - i) + "");
			} else
				Main.label_milli.setVisible(false);

			// =====================================================================\\

			// This part for Sub Clock
			// =====================================================================\\
			if (i == subClockStartI) {
				if (isSubClockPause != true) {
					int I = Main.subClock - 1;
					if (Main.subClock > 0) {
						Main.label_2.setText(Main.subClock + "");
						Main.subClock--;
					} else if (Main.subClock == 0) {
						Main.label_2.setText("**");
						Main.subClock--;
						Main.playSound("timeOut.wav");
						I = 0;
					}
					Main.announce(Time + "subClock set from " + Main.subClock + " -> " + I);
				}
			}
			// =====================================================================\\

			// This part for Main Clock
			// =====================================================================\\
			if (i == m) {
				if (Main.timeLeft >= 60) {
					Main.label_1.setText(CalculateTimer(Main.timeLeft));
					Main.announce(Time + "[timeLeft] " + Main.timeLeft + " -> " + (Main.timeLeft - 1) + " ("
							+ PercentCalculate(Main.timeLeft) + "% complete)");
					Main.timeLeft--;
					Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
				} else if (Main.timeLeft < 60 && Main.timeLeft > 0) {
					Main.label_1.setText(Main.timeLeft + ".__");
					Main.announce(Time + "[timeLeft] " + Main.timeLeft + " -> " + (Main.timeLeft - 1) + " ("
							+ PercentCalculate(Main.timeLeft) + "%)");
					Main.timeLeft--;
					Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
				} else if (Main.timeLeft == 0) {
					Main.label_1.setText("0. 0");
					Main.announce(
							Time + "[timeLeft] " + Main.timeLeft + " -> 0 (" + PercentCalculate(Main.timeLeft) + "%)");
					Main.timeLeft--;
					Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
					Main.announce(Time + "[timeLeft] TIME UP!");
					Main.playSound("timeOut.wav");
				}
			}
			if (i < m)
				i++;
			else
				i = 1;
			// =====================================================================\\
		}
	}
}