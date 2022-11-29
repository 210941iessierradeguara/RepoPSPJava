package ej13_Socket01;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		Socket sock = null;
		try {
			sock = new Socket("localhost",3000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Drección local
		System.out.println("[Client-LocalAdress]: "+sock.getLocalAddress());
		//Puerto local
		System.out.println("[Client-LocalPort]: "+sock.getLocalPort());
		//Dirección remota:
		System.out.println("[Client-InetAdress]: "+sock.getInetAddress());
		//Puerto remoto:
		System.out.println("[Client-Port]: "+sock.getPort());
		try {
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
