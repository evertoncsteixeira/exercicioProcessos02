package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosOs {
	public ProcessosOs(){
		super();
	}
	
	public String retornaOs(){
		String os = System.getProperty("os.name");
		return os ;
		  
	}
	
	public void lerProcessos(String os){
		 try {
			 String processo = "";
			 if (os.contains("Windows")) {
				 processo = "TASKLIST /FO TABLE";
			 } else {
				 processo = "ps -ef";
			 }
	
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream(); 
		    InputStreamReader leitor = new InputStreamReader(fluxo);
		    BufferedReader buffer = new BufferedReader(leitor);
		    String linha = buffer.readLine();
		    	
		    while (linha != null) {
		    	System.out.println(linha);
		    	
		    	linha = buffer.readLine();
		    }
		    buffer.close();
		    leitor.close();
		    fluxo.close();
		   
		 } catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void finalProcessoPID(String processo, String os) {
		String cmdPid = "";
		if (os.contains("Windows")) {
			cmdPid = "TASKKILL /PID";
		 } else {
			cmdPid = "kill -9";
		 }
		
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		try {
			pid =  Integer.parseInt(processo);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public void finalProcessoNome(String processo, String os) {
		String cmdNome = "";
		if (os.contains("Windows")) {
			cmdNome = "TASKKILL /IM";
		 } else {
			 cmdNome = "pkill";
		 }
		
	
		StringBuffer buffer = new StringBuffer();
		
		try {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(processo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
