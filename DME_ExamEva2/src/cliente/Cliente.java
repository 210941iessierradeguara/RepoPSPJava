package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		
		//https://www.meteoclimatic.net/perfil/ESARA2200000022002A
		
		//#content > table:nth-child(3) > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(1), #content > table:nth-child(3) > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(3)
		
		Scanner s = new Scanner(System.in);
		
		Socket sock = null;
		DataOutputStream salida = null;
		DataInputStream entrada = null;
		
		//Conectar con server
		
		try {			
			sock = new Socket("localhost", 4321);
		} catch (UnknownHostException e) {
			System.err.println("Error en el new socket");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error en el new socket");
			e.printStackTrace();
		}
		
		//Salida, enviar Textos de URL y selector
		
		try {
			salida = new DataOutputStream(sock.getOutputStream());
			
			System.out.println("Introduzca URL: ");
			String url = s.nextLine();
			
			System.out.println("Introduzca selector JSOUP: ");
			String selector = s.nextLine();
			
			salida.writeUTF(url);
			salida.writeUTF(selector);
			
			
		} catch (IOException e) {
			System.err.println("Error en el Data output stream");
			e.printStackTrace();
		}
		
		//Entrada InputStream recibir obj respuesta
				
		try {
			entrada = new DataInputStream(sock.getInputStream());
			
			String response = entrada.readUTF();
			System.out.println(response);
			
			System.out.println("");
		} catch (IOException e) {
			System.err.println("Error en el Data Input stream");
			e.printStackTrace();
		}
		
		
		//Cerramientos
		
		try {
			entrada.close();
		} catch (IOException e2) {
			System.out.println("Error al cerrar la entrada");
			e2.printStackTrace();
		}
		
		try {
			salida.close();
		} catch (IOException e1) {
			System.err.println("Error al cerrar salida");
			e1.printStackTrace();
		}
		
		try {
			sock.close();
		} catch (IOException e) {
			System.err.println("Error al cerrar el sock");
			e.printStackTrace();
		}
	}
}
