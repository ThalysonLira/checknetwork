package br.unitins.check_net.application;

public class Util {
	
	public static void main(String args[]) {
		
		System.out.println("Sistema operacional: " + OperationalComponents.getOperationalSystem());
		System.out.println("Espaço disponível em disco (C:): " + OperationalComponents.getPathFreeSize("C:") + " bytes");
		System.out.println("Porcentagem do disco disponível (D:): " + OperationalComponents.getPathFreePercent("C:") + " %");
		System.out.println("Quantidade de memória RAM utilizada: "+ OperationalComponents.getMemoryUsedSize()  + " bytes");
		System.out.println("Porcentagem de memória RAM livre: " + OperationalComponents.getMemoryFreePercent() + " %");
		
	}
	
}