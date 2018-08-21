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

public class Clock implements Runnable {

	private boolean isRunning = true;

	public static boolean isClockPause = true;
	
	public static int i = 0;

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public int PercentCalculate(int second) {
		int percent = 100 - ((second * 100) / Main.timeStart);
		return percent;
	}

	public String CalculateTimer(int timeInSecond) {
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

	@Override
	public void run() {
		while (isRunning == true) {
			
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if (isClockPause == true) {

			} else {
				if (i < 99) {
					
					Main.label_milli.setText((100 - i) + "");
					i = i + 1;
					
				} else if (i == 99) {

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
							Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 400));
							Main.announce(time_ + "[timeLeft] set from " + Main.timeLeft + " -> " + I + " ("
									+ PercentCalculate(Main.timeLeft) + "% complete)");
							Main.timeLeft = I;
							Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
							Main.label_milli.setVisible(false);
						} else if (Main.timeLeft < 60) {
							Main.label_milli.setVisible(true);
							int I = Main.timeLeft - 1;
							Main.label_1.setForeground(Color.WHITE);
							Main.label_1.setText(Main.timeLeft + ".__");
							Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 400));
							Main.announce(time_ + "[timeLeft] set from " + Main.timeLeft + " -> " + I + " ("
									+ PercentCalculate(Main.timeLeft) + "% complete)");
							Main.timeLeft = I;
							Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
						} else if (Main.timeLeft == 0) {
							Main.label_1.setForeground(Color.ORANGE);
							Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 400));
							Main.label_1.setText(Main.timeLeft + ".__");
							Main.announce(time_ + "[timeLeft] set from " + Main.timeLeft + " -> " + 0 + " ("
									+ PercentCalculate(Main.timeLeft) + "% complete)");
							Main.timeLeft = -1;
							Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
							Main.announce(time_ + "[timeLeft] set message to 'TIME UP!'");
							Main.playSound("timeOut.wav");
						} else {
							// Time below timeLeft
							// Do nothing
						}

					Main.label_milli.setText((100 - i) + "");
					i = 0;
					if (Main.timeLeft == -1) {
						Main.label_1.setForeground(Color.ORANGE);
						Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 400));
						Main.label_1.setText("0.__");
						Main.announce(time_ + "[timeLeft] set from " + Main.timeLeft + " -> " + 0 + " ("
								+ PercentCalculate(Main.timeLeft) + "% complete)");
						Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
						Main.announce(time_ + "[timeLeft] set message to 'TIME UP!'");
						Main.label_milli.setText((0) + "0");
						isClockPause = true;
						Main.playSound("timeOut.wav");
					}
				}
			}

			
		}

	}

}