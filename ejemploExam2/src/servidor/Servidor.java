package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket servSock = new ServerSocket(4321); //(port)
		Socket sock = null;
		
		//while para todos los clientes
		while (true) {
			sock = servSock.accept();
			//crear un nuevo hilo al que le pasamos el sock como param
			new Thread(new HiloConexion(sock)).start();
			
		}
	}	
}
