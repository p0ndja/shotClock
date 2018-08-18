package me.palapon2545.SMD.SchoolProject.basketballLeague.shortClock;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sun.audio.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.management.timer.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Main extends JFrame implements ActionListener {
	private static final long serialVersionUID = 561811103320831759L;
	private JPanel contentPane;

	// Panel Width and Height set here
	public final int width = 800;
	public final int height = 600;
	public final String title = "me.palapon2545.SMD.SchoolProject.basketballLeague.shortClock.Main.java.setDisplayTitle('SATIT SHORTCLOCK by PALAPON2545')";

	// Don't change this int zone
	// ******************************\\
	public static int timeLeft = -1;
	public static int timeStart = -1;
	public static int timeAddon = -1;
	public static int left = 0;
	public static int right = 0;
	// ******************************\\

	public static JProgressBar progressBar = new JProgressBar();

	public static Clock Clock = null;
	public static Thread Clock_Thread = null;

	private final JButton btnMinute_1 = new JButton("12 MINUTE");
	private final JButton btnMinute_2 = new JButton("5 MINUTE");
	private final JButton btnMinute_3 = new JButton("3 MINUTE");
	private final JButton btnMinute_4 = new JButton("1 MINUTE");
	private final JButton btnSecond = new JButton("24 SECOND");
	private final JButton btnSecond_1 = new JButton("14 SECOND");
	public static JLabel label_1 = new JLabel("--:--");
	public static JLabel label_2 = new JLabel("**");
	public static JLabel label_left = new JLabel(left + "");
	public static JLabel label_right = new JLabel(right + "");
	private final JButton button = new JButton("+");
	private final JButton button_1 = new JButton("-");
	private final JButton button_2 = new JButton("+");
	private final JButton button_3 = new JButton("-");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MAC_ADDRESS.main();
					
					if (MAC_ADDRESS.mac_address_strict_mode == true) {
						if (!MAC_ADDRESS.mac_address_list.contains(MAC_ADDRESS.mac_address_this_user)) {
							LicensePopup popup = new LicensePopup();
							popup.setVisible(true);
						} else {
							Main frame = new Main();
							frame.setVisible(true);
						}
					} else {
						announce("MAC_ADDRESS_STRICT = false");
						Main frame = new Main();
						frame.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Function for debugging to console log
	public static void announce(String m) {
		System.out.print(m + String.format("%n"));
	}

	public Main() {

		announce("----------------------------------------------------");
		announce("DEBUGGER");
		MAC_ADDRESS.main();

		announce("----------------------------------------------------");
		announce(" ");
		announce(" WELCOME TO MY PROGRAM");
		announce(" THANKS FOR USING IT!");
		announce(" ");
		announce(" FEEL FREE TO GET SOURCE-CODE ON MY GITHUB");
		announce("   \"https://github.com/p0ndja\"");
		announce(" ");
		announce(" ALSO MY FACEBOOK");
		announce("   \"https://fb.me/p0ndja\"");
		announce(" ");
		announce("----------------------------------------------------");

		announce("running program . . .");

		setTitle(title);
		announce("set title = " + title);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		announce("set default close operation = EXIT");

		setBounds(69, 69, width, height);
		announce("set gui border");
		announce(" * width = " + width);
		announce(" * height = " + height);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.decode("#333333"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		announce("config contentPane");

		JButton btnMinute = new JButton("8 MINUTE");
		btnMinute.setBackground(Color.WHITE);
		btnMinute.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMinute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeLeft = 480;
				timeStart = timeLeft;
			}
		});
		btnMinute.setBounds(184, 11, 131, 20);
		contentPane.add(btnMinute);
		announce("add 8minute button");

		btnMinute_1.setBackground(Color.WHITE);
		btnMinute_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMinute_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeLeft = 720;
				timeStart = timeLeft;
			}
		});
		btnMinute_1.setBounds(43, 11, 131, 20);
		contentPane.add(btnMinute_1);
		announce("add 12minute button");

		btnMinute_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeLeft = 300;
				timeStart = timeLeft;
			}
		});
		btnMinute_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMinute_2.setBounds(325, 11, 131, 20);
		btnMinute_2.setBackground(Color.WHITE);
		contentPane.add(btnMinute_2);
		announce("add 5minute button");

		btnMinute_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeLeft = 180;
				timeStart = timeLeft;
			}
		});
		btnMinute_3.setBackground(Color.WHITE);
		btnMinute_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMinute_3.setBounds(466, 11, 131, 20);
		contentPane.add(btnMinute_3);
		announce("add 3minute button");

		btnMinute_4.setBackground(Color.WHITE);
		btnMinute_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeLeft = 60;
				timeStart = timeLeft;
			}
		});
		btnMinute_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMinute_4.setBounds(607, 11, 131, 20);
		contentPane.add(btnMinute_4);
		announce("add 1minute button");

		btnSecond.setBackground(Color.WHITE);
		btnSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeAddon = 24;
			}
		});
		btnSecond.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSecond.setBounds(253, 530, 131, 20);
		contentPane.add(btnSecond);
		announce("add 24second button");

		btnSecond_1.setBackground(Color.WHITE);
		btnSecond_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeAddon = 14;
			}
		});
		btnSecond_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSecond_1.setBounds(394, 530, 131, 20);
		contentPane.add(btnSecond_1);
		announce("add 14second button");

		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.RED);
		progressBar.setBounds(85, 290, 610, 14);
		contentPane.add(progressBar);
		announce("add progress bar");

		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Cordia New", Font.BOLD, 400));
		label_1.setBackground(SystemColor.windowBorder);
		label_1.setBounds(0, 34, 784, 248);
		contentPane.add(label_1);
		announce("add label_1");

		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.GREEN);
		label_2.setFont(new Font("Cordia New", Font.BOLD, 200));
		label_2.setBackground(SystemColor.windowBorder);
		label_2.setBounds(253, 340, 270, 126);
		contentPane.add(label_2);
		announce("add label_2");

		label_left.setForeground(Color.RED);
		label_left.setFont(new Font("Angsana New", Font.BOLD, 250));
		label_left.setBackground(Color.WHITE);
		label_left.setHorizontalAlignment(SwingConstants.CENTER);
		label_left.setBounds(0, 250, 277, 241);
		contentPane.add(label_left);
		announce("add label_left");

		label_right.setHorizontalAlignment(SwingConstants.CENTER);
		label_right.setForeground(Color.BLUE);
		label_right.setFont(new Font("Angsana New", Font.BOLD, 250));
		label_right.setBackground(Color.WHITE);
		label_right.setBounds(507, 250, 277, 241);
		contentPane.add(label_right);
		announce("add label_right");

		button.setBackground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_left.setText((left + 1) + "");
				left = left + 1;
			}
		});
		button.setBounds(85, 491, 47, 42);
		announce("add left-side '+' button");

		contentPane.add(button);
		button_1.setBackground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (left > 0) {
					label_left.setText((left - 1) + "");
					left = left - 1;
				}
			}
		});
		button_1.setBounds(143, 491, 47, 42);
		contentPane.add(button_1);
		announce("add left-side '-' button");

		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_right.setText((right + 1) + "");
				right = right + 1;
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(593, 491, 47, 42);
		contentPane.add(button_2);
		announce("add right-side '+' button");

		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (right > 0) {
					label_right.setText((right - 1) + "");
					right = right - 1;
				}
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(651, 491, 47, 42);
		contentPane.add(button_3);
		announce("add right-side '-' button");

		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.decode("#333333"));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeLeft = -1;
				label_1.setText("MAKE BY PALAPON");
				label_1.setForeground(Color.YELLOW);
				label_1.setFont(new Font("Cordia New", Font.BOLD, 120));
			}
		});
		btnNewButton.setBounds(772, 0, 12, 8);
		contentPane.add(btnNewButton);
		announce("add ??? button");

		Clock = new Clock();
		Clock_Thread = new Thread(Clock);
		Clock_Thread.start();
		announce("START delayLoadConfig_Thread");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	public static synchronized void playSound(String url) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem
							.getAudioInputStream(Main.class.getResourceAsStream("/" + url));
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}
}