package br.unitins.check_net.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util {
	
	public static void main(String args[]) throws IOException {
		
		
		Runtime runtime = Runtime.getRuntime();

		String cmds[] = {"cmd", "/c", "tasklist"};

		Process proc = runtime.exec(cmds);

		InputStream inputstream = proc.getInputStream();

		InputStreamReader inputstreamreader = new InputStreamReader(inputstream);

		BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

		String line;

		while ((line = bufferedreader.readLine()) != null) {

			System.out.println(line);

		}
		
		System.out.println("\nSistema operacional: " + OperationalComponents.getOperationalSystem());
		System.out.println("Espaço disponível em disco (C:): " + OperationalComponents.getPathFreeSize("C:") + " bytes");
		System.out.println("Porcentagem do disco disponível (D:): " + OperationalComponents.getPathFreePercent("C:") + " %");
		System.out.println("Quantidade de memória RAM utilizada: "+ OperationalComponents.getMemoryUsedSize()  + " bytes");
		System.out.println("Porcentagem de memória RAM livre: " + OperationalComponents.getMemoryFreePercent() + " %");
		
	}
	
}