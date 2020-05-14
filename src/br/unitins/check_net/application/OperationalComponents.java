package br.unitins.check_net.application;

import java.io.File;
import java.lang.management.ManagementFactory;

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

	// demais verificacoes

	public static String getOperationalSystem() {
		return getMxBean().getName();
	}

	public static OperatingSystemMXBean getMxBean() {
		if (mxBean == null)
			mxBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		return mxBean;
	}

}