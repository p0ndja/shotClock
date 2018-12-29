package me.palapon2545.SMD.SchoolProject.basketballLeague.shortClock;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class Main extends JFrame implements ActionListener {
	private static final long serialVersionUID = 561811103320831759L;
	private JPanel contentPane;

	// Panel Width and Height set here
	public final int width = 1330;
	public final int height = 700;
	public final String title = "ShotClock";

	// Don't change this int zone
	// ==============================\\
	public static int timeLeft = -1;
	public static int timeStart = -1;
	public static int subClock = -1;
	public static int timeTimeOut = -1;
	public static int left = 0;
	public static int right = 0;
	// ==============================\\

	public static JProgressBar progressBar = new JProgressBar();
	public static JLabel label_1 = new JLabel("--:--");
	public static JLabel label_2 = new JLabel("**");
	public static JLabel label_left = new JLabel(left + "");
	public static JLabel label_right = new JLabel(right + "");
	public static JLabel label_milli = new JLabel(" ");

	private final JButton btnMinute_1 = new JButton("12m");
	private final JButton btnMinute_2 = new JButton("5m");
	private final JButton btnMinute_3 = new JButton("3m");
	private final JButton btnMinute_4 = new JButton("1m");
	private final JButton btnSecond = new JButton("24s");
	private final JButton btnSecond_1 = new JButton("14s");
	private final JButton button = new JButton("+");
	private final JButton button_1 = new JButton("-");
	private final JButton button_2 = new JButton("+");
	private final JButton button_3 = new JButton("-");
	private final JButton button_10 = new JButton("-1m");
	private final JButton button_5 = new JButton("SOUND");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
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

		announce("====================================================");
		announce(" ");
		announce(" WELCOME TO MY PROGRAM");
		announce(" THANKS FOR USING IT!");
		announce(" ");
		announce(" FEEL FREE TO GET SOURCE-CODE ON MY GITHUB");
		announce("   \"https://github.com/palapon2545\"");
		announce(" ");
		announce(" ALSO MY FACEBOOK");
		announce("   \"https://fb.me/p0ndja\"");
		announce(" ");
		announce("====================================================");

		announce("running program . . .");

		setTitle(title);
		announce("set title = " + title);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		announce("set default close operation = EXIT");

		setBounds(69, 69, width, height);
		announce("set gui border");
		announce(" * width = " + width);
		announce(" * height = " + height);

		// This code below block user to resize windows
		// ===========================================\\
		setPreferredSize(new Dimension(width, height));
		setResizable(false);
		// ===========================================\\

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.decode("#333333"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		announce("config contentPane");

		JButton btnMinute = new JButton("8m");
		btnMinute.setBackground(Color.WHITE);
		btnMinute.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMinute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeLeft = 480;
				timeStart = timeLeft;
				runClock();
			}
		});
		btnMinute.setBounds(470, 0, 64, 31);
		contentPane.add(btnMinute);
		announce("add 8minute button");

		btnMinute_1.setBackground(Color.WHITE);
		btnMinute_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMinute_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeLeft = 720;
				timeStart = timeLeft;
				runClock();
			}
		});
		btnMinute_1.setBounds(355, 0, 64, 31);
		contentPane.add(btnMinute_1);
		announce("add 12minute button");

		btnMinute_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeLeft = 3;
				timeStart = timeLeft;
				runClock();
			}
		});
		btnMinute_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMinute_2.setBounds(634, 0, 64, 31);
		btnMinute_2.setBackground(Color.WHITE);
		contentPane.add(btnMinute_2);
		announce("add 5minute button");

		btnMinute_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeTimeOut = 180;
				runClockTimeOut();
				Clock.timeOutStartI = Clock.i;
				Clock.isTimeOutClockPause = false;
			}
		});
		btnMinute_3.setBackground(Color.PINK);
		btnMinute_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMinute_3.setBounds(787, 0, 64, 31);
		contentPane.add(btnMinute_3);
		announce("add 3minute button");

		btnMinute_4.setBackground(Color.PINK);
		btnMinute_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeTimeOut = 60;
				runClockTimeOut();
				Clock.isTimeOutClockPause = false;
			}
		});
		btnMinute_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMinute_4.setBounds(878, 0, 64, 31);
		contentPane.add(btnMinute_4);
		announce("add 1minute button");

		btnSecond.setBackground(Color.WHITE);
		btnSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subClock = 24;
				runClockForAddon();
				Clock.subClockStartI = Clock.i;
			}
		});
		btnSecond.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSecond.setBounds(522, 641, 131, 31);
		contentPane.add(btnSecond);
		announce("add 24second button");

		btnSecond_1.setBackground(Color.WHITE);
		btnSecond_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subClock = 14;
				runClockForAddon();
				Clock.subClockStartI = Clock.i;
			}
		});
		btnSecond_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSecond_1.setBounds(663, 641, 131, 31);
		contentPane.add(btnSecond_1);
		announce("add 14second button");

		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.RED);
		progressBar.setBounds(128, 432, 1077, 14);
		contentPane.add(progressBar);
		announce("add progress bar");
		announce("add label_1");
		announce("add label_2");
		announce("add label_left");
		announce("add label_right");

		button.setBackground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_left.setText((left + 1) + "");
				left = left + 1;
			}
		});
		button.setBounds(200, 630, 47, 42);
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
		button_1.setBounds(258, 630, 47, 42);
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
		button_2.setBounds(1027, 630, 47, 42);
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
		button_3.setBounds(1085, 630, 47, 42);
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
				label_milli.setVisible(false);
				label_1.setForeground(Color.YELLOW);
				label_1.setFont(new Font("Cordia New", Font.BOLD, 120));
			}
		});
		btnNewButton.setBounds(1305, 0, 20, 14);
		contentPane.add(btnNewButton);
		announce("add ??? button");

		JButton btnPause_1 = new JButton("PAUSE");
		btnPause_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPause_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switcher();
			}
		});
		btnPause_1.setBackground(Color.PINK);
		btnPause_1.setBounds(1215, 394, 99, 42);
		contentPane.add(btnPause_1);

		JButton btnSound = new JButton("SOUND");
		btnSound.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playSound("timeOut.wav");
			}
		});
		btnSound.setBackground(Color.PINK);
		btnSound.setBounds(10, 439, 99, 42);
		contentPane.add(btnSound);

		JButton btnPause = new JButton("PAUSE");
		btnPause.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switcher();
			}
		});
		btnPause.setBackground(Color.PINK);
		btnPause.setBounds(804, 630, 92, 42);
		contentPane.add(btnPause);

		JButton btnShotclock = new JButton("Pause ShotClock");
		btnShotclock.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShotclock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Clock.isSubClockPause == false)
					Clock.isSubClockPause = true;
				else
					Clock.isSubClockPause = false;
			}
		});
		btnShotclock.setBackground(Color.YELLOW);
		btnShotclock.setBounds(386, 628, 126, 42);
		contentPane.add(btnShotclock);

		JButton btnm = new JButton("+1m");
		btnm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeLeft += 60;
				timeStart = timeLeft;
				if (Clock.isClockPause == true) {
					if (timeLeft < 60) timeLeft++;
					runClock();
				}
				label_1.setText(Clock.CalculateTimer(timeLeft));
			}
		});
		btnm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnm.setBackground(Color.WHITE);
		btnm.setBounds(147, 0, 67, 31);
		contentPane.add(btnm);
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (timeLeft > 60) {
					timeLeft -= 60;
					timeStart = timeLeft;
					label_1.setText(Clock.CalculateTimer(timeLeft));
				}
				runClock();
			}
		});
		button_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_10.setBackground(Color.WHITE);
		button_10.setBounds(223, 0, 67, 31);

		contentPane.add(button_10);

		JButton button_4 = new JButton("PAUSE");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switcher();
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_4.setBackground(Color.PINK);
		button_4.setBounds(10, 394, 99, 42);
		contentPane.add(button_4);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playSound("timeOut.wav");
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_5.setBackground(Color.PINK);
		button_5.setBounds(1215, 439, 99, 42);

		contentPane.add(button_5);

		JLabel lblTimeout = new JLabel("TIMEOUT / BREAK");
		lblTimeout.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTimeout.setForeground(Color.PINK);
		lblTimeout.setBounds(787, 42, 155, 14);
		contentPane.add(lblTimeout);

		JLabel lblMatch = new JLabel("Match");
		lblMatch.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatch.setForeground(Color.GREEN);
		lblMatch.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMatch.setBounds(355, 42, 179, 14);
		contentPane.add(lblMatch);

		JLabel label = new JLabel("Draw Match");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.CYAN);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(583, 42, 179, 14);
		contentPane.add(label);

		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Cordia New", Font.BOLD, 600));
		label_1.setBackground(SystemColor.windowBorder);
		label_1.setBounds(0, 34, 1324, 387);
		contentPane.add(label_1);

		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.GREEN);
		label_2.setFont(new Font("Cordia New", Font.BOLD, 300));
		label_2.setBackground(SystemColor.windowBorder);
		label_2.setBounds(435, 432, 448, 185);
		contentPane.add(label_2);

		label_left.setForeground(Color.RED);
		label_left.setFont(new Font("Angsana New", Font.BOLD, 350));
		label_left.setBackground(Color.WHITE);
		label_left.setHorizontalAlignment(SwingConstants.CENTER);
		label_left.setBounds(77, 394, 348, 236);
		contentPane.add(label_left);

		label_right.setHorizontalAlignment(SwingConstants.CENTER);
		label_right.setForeground(Color.CYAN);
		label_right.setFont(new Font("Angsana New", Font.BOLD, 350));
		label_right.setBackground(Color.WHITE);
		label_right.setBounds(893, 394, 369, 233);
		contentPane.add(label_right);

		label_milli.setVisible(false);
		label_milli.setHorizontalAlignment(SwingConstants.CENTER);
		label_milli.setForeground(Color.WHITE);
		label_milli.setFont(new Font("Cordia New", Font.BOLD, 400));
		label_milli.setBounds(690, 42, 398, 366);
		contentPane.add(label_milli);

		runRunRun();
		announce("START Main clock timer");
		announce("START Addon-clock timer");
	}

	public void runClockForAddon() {
		Clock.isClockPause = false;
		Clock.isSubClockPause = false;
	}

	public void runClock() {
		if (timeLeft == -1)
			Clock.i = 10;
		Clock.isClockPause = false;
	}

	public void runRunRun() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
				Clock.run();
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, new Date(), 100);
	}

	public void switcher() {
		if (Clock.isClockPause == false)
			Clock.isClockPause = true;
		else
			Clock.isClockPause = false;
	}

	public void runClockTimeOut() {
		TimeOutClockPopup popup = new TimeOutClockPopup();
		popup.setVisible(true);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}