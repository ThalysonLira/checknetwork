package br.unitins.check_net.application;

public class Util {
	
	public static void main(String args[]) {
		
//		// Componentes operacionais
//		System.out.println("\nSistema operacional: " + OperationalComponents.getOperationalSystem());
//		System.out.println("Espaço disponível em disco (C:): " + OperationalComponents.getPathFreeSize("C:") + " bytes");
//		System.out.println("Porcentagem do disco disponível (D:): " + OperationalComponents.getPathFreePercent("C:") + " %");
//		System.out.println("Quantidade de memória RAM utilizada: "+ OperationalComponents.getMemoryUsedSize()  + " bytes");
//		System.out.println("Porcentagem de memória RAM livre: " + OperationalComponents.getMemoryFreePercent() + " %");
//		System.out.println("\nProcessos em execução: " + OperationalComponents.getRunningProcess("/C"));
		
		// Componentes de rede
		System.out.println("Está conectado: " + NetworkPing.isConnected());
		System.out.println("IP interno: " + NetworkPing.getIpInternal());
		System.out.println("Host: " + NetworkPing.getHostName());
		System.out.println("IP externo: " + NetworkPing.getIpExternal());
		
	}
	
}