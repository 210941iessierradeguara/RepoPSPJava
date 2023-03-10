package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HiloConexion implements Runnable{
	Socket sock;
	
	public HiloConexion(Socket sock) {
		this.sock = sock;
	}

	@Override
	public void run()
	{
		try {
			//leer un texto
			DataInputStream entrada = new DataInputStream(sock.getInputStream());
			//Lo que será pasado a hash
			String texto = entrada.readUTF();
			
			entrada.close();
			//Imprimir sin hashear y la IP del cliente.
			System.out.println("Texto recibido: " + texto);
			System.out.println("IP del cliente: " + sock.getInetAddress());
			
			//Espera 2 secs. 
			Thread.sleep(2000);
			
			//Message Digest usa singleton
			MessageDigest hashCreator = MessageDigest.getInstance("SHA-256");
			//Se cargan los datos en el  crador. NO SE HA CREADO EL HASH AÚN
			hashCreator.update(texto.getBytes());
			//ahora se ha creado el hash
			byte[] hash = hashCreator.digest();
			
			
			String hasHexTxt = "";
			//bucle para pasarlo a texto Hex
			for (byte b : hash) {
				//guarda
				hasHexTxt += Integer.toHexString(b & 0xFF); //cada byte operado por 0xFF
			}
			//Imprime
			System.out.println(hasHexTxt);
			
			DataOutputStream salida = new DataOutputStream(sock.getOutputStream());
			salida.writeUTF(hasHexTxt);
			salida.close();
			sock.close();
			
		} catch (IOException e) {
			System.err.println("Error IOException");
			//e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Error en el creador de hashes");
			//e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("Error en el sleep");
			//e.printStackTrace();
		}
	}

}
