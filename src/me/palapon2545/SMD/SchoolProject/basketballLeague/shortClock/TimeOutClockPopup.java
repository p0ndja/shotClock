package me.palapon2545.SMD.SchoolProject.basketballLeague.shortClock;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimeOutClockPopup extends JFrame {
	
	public static JLabel main = new JLabel("--:--");

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeOutClockPopup frame = new TimeOutClockPopup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TimeOutClockPopup() {
		
		//This code below block user to resize windows
		//===========================================\\
		setPreferredSize(new Dimension(800, 400));
		setResizable(false);
		//===========================================\\
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		main.setFont(new Font("Cordia New", Font.BOLD, 400));
		main.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(main);
	
	}

}
