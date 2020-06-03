package br.unitins.check_net.application;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public abstract class NetworkPing {

	public static boolean isConnected() {
		try {
			URL url = new URL("https://www.google.com.br");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			connection.disconnect();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

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
			connection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ip;
	}

	// criar verificações de conexão
}