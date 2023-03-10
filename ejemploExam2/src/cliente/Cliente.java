package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

//CLIENTE = OUTPUT
public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException, NoSuchAlgorithmException {
		Scanner s = new Scanner(System.in);
		String textoIntroducido = s.nextLine();
		
		Socket sock = new Socket("localhost", 4321);
		DataOutputStream salida = new DataOutputStream(sock.getOutputStream());
		salida.writeUTF(textoIntroducido);
		salida.close();
		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		String hashRecibido = entrada.readUTF();
		
		entrada.close();
		//EL CLIENTE TAMBIÉN CREA EL HASH PARA COMPROBAR
		MessageDigest hashCreator;
		hashCreator = MessageDigest.getInstance("SHA-256");
		hashCreator.update(textoIntroducido.getBytes());
		byte[] hash = hashCreator.digest();			
		String hasHexTxt = "";
		for (byte b : hash) {
			hasHexTxt += Integer.toHexString(b & 0xFF); //cada byte operado por 0xFF
		}
		
		//Imprimimos los dos hashes para comprobar que son iguales.
		System.out.println("Hash Calculado: " + hasHexTxt);
		System.out.println("Hash Recibido: " + hashRecibido);
		
		if (hasHexTxt.equals(hashRecibido)) {
			System.out.println("Los hashes son iguales");
		}
		else
		{
			System.out.println("Los hashes no coinciden");
		}
	}
}
