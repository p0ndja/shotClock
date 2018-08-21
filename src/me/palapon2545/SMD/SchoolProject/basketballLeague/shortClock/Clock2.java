package me.palapon2545.SMD.SchoolProject.basketballLeague.shortClock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Clock2 implements Runnable {

	private boolean isRunning = true;

	public static int i = 0;

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
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

			if (Clock.isClockPause == true) {

			} else {
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

			}
		}

	}

}