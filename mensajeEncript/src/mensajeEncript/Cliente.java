package mensajeEncript;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Cliente {
	public static void main(String[] args) {
		Socket sock = new Socket();
		try {
			Socket sockAddr = new Socket("192.168.101.10", 3000);
			Key key = new SecretKeySpec("1234567812345678".getBytes(),  0, 16, "AES");
			//sock.connect(sockAddr, 600);
			String txt = "Ejemplo";
			
			Cipher aes = Cipher.getInstance("AES");
			
			aes.init(Cipher.DECRYPT_MODE, key);
			byte[] encriptado = aes.doFinal(txt.getBytes());
			
			ObjectOutputStream salida = new ObjectOutputStream(sock.getOutputStream());
			salida.writeObject(encriptado);
			
			salida.close();
			sock.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
