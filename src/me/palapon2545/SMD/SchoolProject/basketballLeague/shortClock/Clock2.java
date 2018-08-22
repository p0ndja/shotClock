package me.palapon2545.SMD.SchoolProject.basketballLeague.shortClock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Clock2 {

	public static int i = 1;

	public static void run() {
		if (i < 10) {
			i++;
			return;
		} else if(i == 10){
			i = 1;
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
		} else {
			i = 1;
		}
	}
}