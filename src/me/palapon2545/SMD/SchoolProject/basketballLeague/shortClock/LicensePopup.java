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

public class LicensePopup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LicensePopup frame = new LicensePopup();
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
	public LicensePopup() {
		
		MAC_ADDRESS.main();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblSorryButYou = new JLabel("Sorry but you don't have permission to run this program!");
		lblSorryButYou.setFont(new Font("Cordia New", Font.BOLD, 25));
		lblSorryButYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblSorryButYou.setBounds(0, 35, 440, 20);
		contentPane.add(lblSorryButYou);
		
		JLabel lblPleasecontact = new JLabel("Please contact at palapon2545@gmail.com");
		lblPleasecontact.setFont(new Font("Cordia New", Font.BOLD, 30));
		lblPleasecontact.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPleasecontact);
		
		JLabel lblMacAddress = new JLabel("MAC Address: " + MAC_ADDRESS.mac_address_this_user);
		lblMacAddress.setFont(new Font("Cordia New", Font.PLAIN, 25));
		lblMacAddress.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMacAddress, BorderLayout.SOUTH);
	}

}
