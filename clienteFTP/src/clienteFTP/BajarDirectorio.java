package clienteFTP;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class BajarDirectorio {
	public static void main(String[] args) throws SocketException, IOException {
		FTPClient cliente = new FTPClient();
		cliente.connect("127.0.0.1");
		boolean conectado = cliente.login("user", "password");
		cliente.setFileType(FTP.BINARY_FILE_TYPE);
		String directorio = "/carpeta";
		if(conectado)
		{
			cliente.cwd(directorio);
			FTPFile[] archivos = cliente.listFiles();
			for (FTPFile file : archivos) {
				if (file.isFile())
				{
					File archivoLocal = new File("./" + file.getName());
					BufferedOutputStream streamLocal = new BufferedOutputStream(
													   new FileOutputStream(archivoLocal));
					if(cliente.retrieveFile(file.getName(), streamLocal))
					{
						System.out.println("Descargado " + file.getName());
					}
					else
					{
						System.out.println("Error durante la descarga");
					}
					streamLocal.close();
				}
			}
		}
		else
		{
			System.err.println("Error en el login");
		}
		cliente.disconnect();
	}
}
