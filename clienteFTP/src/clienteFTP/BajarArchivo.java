package clienteFTP;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class BajarArchivo {

	public static void main(String[] args) throws SocketException, IOException {
		FTPClient cliente = new FTPClient();
		cliente.connect("127.0.0.1");
		boolean conectado = cliente.login("user", "password");
		if(conectado)
		{
			System.out.println("Login correcto");
			System.out.println("~~~~~~~~/~~~~~~~~");
			cliente.setFileType(FTP.BINARY_FILE_TYPE);
			File archivoLocal = new File("./fichero03.txt");
			BufferedOutputStream streamLocal = new BufferedOutputStream(
											   new FileOutputStream(archivoLocal));
			if(cliente.retrieveFile("/fichero03.txt", streamLocal))
			{
				System.out.println("Fichero descargado");
			}
			else
			{
				System.out.println("Error durante la descarga");
			}
			streamLocal.close();
		}
		else
		{
			System.err.println("Error en el login");
		}
		cliente.disconnect();

	}

}
