package br.unitins.check_net.application;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public abstract class NetworkPing {
	
	public static String getHostName() {
		try {
			return InetAddress.getLocalHost().getHostName();
			
		} catch (UnknownHostException e) {
			return "\tErro ao processar solicitação: " + e.toString();
		}
	}

	public static String getIpInternal() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
			
		} catch (UnknownHostException e) {
			return "\tErro ao processar solicitação: " + e.toString();
		}
	}
	
	public static String getIpExternal() {
		String ip = null;

		try {
			URL url = new URL("http://checkip.dyndns.org/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.connect();
			
			java.io.BufferedReader page = new java.io.BufferedReader(
					new java.io.InputStreamReader(connection.getInputStream()));
			
			String myIP = page.readLine();
			ip = myIP.substring(myIP.indexOf(": ") + 2, myIP.lastIndexOf("</body>"));
			page.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ip;
	}
	
	// criar verificações de conexão
}