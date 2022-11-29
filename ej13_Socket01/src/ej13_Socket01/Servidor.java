package ej13_Socket01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		try {
			//Crear el socket pasando un puerto.
			ServerSocket servSock = new ServerSocket(3000);
			System.out.println("Esperando conexión...");
			//Quedarse a la espera a una conexión.
			Socket sock = servSock.accept();
			System.out.println("Conectado");
			
			//Drección local
			System.out.println("[Server-LocalAdress]: "+sock.getLocalAddress());
			//Puerto local
			System.out.println("[Server-LocalPort]: "+sock.getLocalPort());
			//Dirección remota:
			System.out.println("[Server-InetAdress]: "+sock.getInetAddress());
			//Puerto remoto:
			System.out.println("[Server-Port]: "+sock.getPort());
			
			sock.close();
			servSock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
