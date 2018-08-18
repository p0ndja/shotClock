package me.palapon2545.SMD.SchoolProject.basketballLeague.shortClock;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MAC_ADDRESS {
	
	static String[] listname = {"C8-FF-28-44-44-73", "...."};
	
	public static List<String> mac_address_list = new ArrayList<String>();
	
	public static boolean mac_address_strict_mode = false;
	
	public static String mac_address_this_user;

	public static void main() {
		
		for (int i=0;i<listname.length;i++)
		mac_address_list.add(listname[i]);

		InetAddress ip;
		try {

			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());

			NetworkInterface network = NetworkInterface.getByInetAddress(ip);

			byte[] mac = network.getHardwareAddress();

			System.out.print("Current MAC address : ");

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			System.out.println(sb.toString());
			
			mac_address_this_user = sb.toString();

		} catch (UnknownHostException e) {

			e.printStackTrace();

		} catch (SocketException e) {

			e.printStackTrace();

		}

	}

}
