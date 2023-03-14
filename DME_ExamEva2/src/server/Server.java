package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket servSock = new ServerSocket(4321);
		Socket sock = null;
		
		while (true) {
			sock = servSock.accept();
			new Thread(new HiloConexion(sock)).start();
		}
	}
}
