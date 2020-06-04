package br.unitins.check_net.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.sun.management.OperatingSystemMXBean;

public abstract class OperationalComponents {

	private static OperatingSystemMXBean mxBean;

	public static long getPathTotalSize(String path) {
		try {
			return new File(path).getTotalSpace();
		} catch (Exception e) {
			System.out.println("\tErro ao processar solicitação: " + e.toString());
			return 0;
		}
	}

	public static long getPathFreeSize(String path) {
		try {
			return new File(path).getFreeSpace();
		} catch (Exception e) {
			System.out.println("\tErro ao processar solicitação: " + e.toString());
			return 0;
		}
	}

	public static long getPathUsedSize(String path) {
		try {
			return getPathTotalSize(path) - getPathFreeSize(path);
		} catch (Exception e) {
			System.out.println("\tErro ao processar solicitação: " + e.toString());
			return 0;
		}
	}

	public static long getPathFreePercent(String path) {
		try {
			return 100 * getPathFreeSize(path) / getPathTotalSize(path);
		} catch (Exception e) {
			System.out.println("\tErro ao processar solicitação: " + e.toString());
			return 0;
		}
	}

	public static long getMemoryTotalSize() {
		return getMxBean().getTotalPhysicalMemorySize();
	}

	public static long getMemoryFreeSize() {
		return getMxBean().getFreePhysicalMemorySize();
	}

	public static long getMemoryUsedSize() {
		return getMemoryTotalSize() - getMemoryFreeSize();
	}

	public static long getMemoryFreePercent() {
		return 100 * getMemoryFreeSize() / getMemoryTotalSize();
	}

	public static String getRunningProcess(String path) {
		String result = "";
		try {
			String cmds[] = { "cmd", path, "tasklist" };
			Process proc = Runtime.getRuntime().exec(cmds);

			InputStream inputstream = proc.getInputStream();
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));

			String line;

			while ((line = bufferedreader.readLine()) != null) {
				result += line + "\n";
			} 
		} catch (IOException e) {
			return "\tErro ao processar solicitação: " + e.toString();
		}
		return result;
	}

	// demais verificacoes

	public static String getOperationalSystem() {
		return getMxBean().getName();
	}

	public static OperatingSystemMXBean getMxBean() {
		if (mxBean == null)
			mxBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		return mxBean;
	}

	public static String getMotherBoard() throws UnknownHostException, SocketException {
		InetAddress localHost = InetAddress.getLocalHost();
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
		return networkInterface.getDisplayName();
	}
	
}