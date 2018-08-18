package me.palapon2545.SMD.SchoolProject.basketballLeague.shortClock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Clock implements Runnable {

	private boolean isRunning = true;

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
		long minute = c / 60;
		long second = c % 60;
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
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			DateFormat normalDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			DateFormat normalTimeFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			String Time = normalTimeFormat.format(date);
			String Date = normalDateFormat.format(date);

			/*
			 * if (Time.equalsIgnoreCase("23:59:59")) { Main.announce("DAY PASSED"); }
			 */

			String time_ = "<" + Time + "> ";

			if (Main.timeAddon > 0) {
				Main.label_2.setText(Main.timeAddon + "");
				int I = Main.timeAddon - 1;
				Main.announce(time_ + "[timeAddOn] set from " + Main.timeAddon + " -> " + I);
				Main.timeAddon = I;
			} else if (Main.timeAddon == 0) {
				Main.label_2.setText("**");
				Main.announce(time_ + "[timeAddOn] set from " + Main.timeAddon + " -> " + 0);
				Main.timeAddon = -1;
			} else {
				// Do nothing
			}

			if (Main.timeLeft > 0) {
				int I = Main.timeLeft - 1;
				Main.label_1.setForeground(Color.WHITE);
				Main.label_1.setText(CalculateTimer(Main.timeLeft));
				Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 400));
				Main.announce(time_ + "[timeLeft] set from " + Main.timeLeft + " -> " + I + " ("
						+ PercentCalculate(Main.timeLeft) + "% complete)");
				Main.timeLeft = I;
				Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
			} else if (Main.timeLeft == 0) {
				Toolkit.getDefaultToolkit().beep();
				Main.label_1.setForeground(Color.ORANGE);
				Main.label_1.setFont(new Font("Cordia New", Font.BOLD, 250));
				Main.label_1.setText("TIME UP!");
				Main.announce(time_ + "[timeLeft] set from " + Main.timeLeft + " -> " + 0 + " ("
						+ PercentCalculate(Main.timeLeft) + "% complete)");
				Main.timeLeft = -1;
				Main.progressBar.setValue(PercentCalculate(Main.timeLeft));
				Main.announce(time_ + "[timeLeft] set message to 'TIME UP!'");
			} else {
				// Do nothing
			}

		}

	}

}