package ej01_LanzarPrograma;

import java.io.IOException;

public class LanzarFirefox {
	
	public static void main(String[] args) {
		try {
			Process proc = new ProcessBuilder("/usr/bin/firefox", 
											  "https://educa.aragon.es").start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
