package clienteFTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class SubirArchivo {

	public static void main(String[] args) throws SocketException, IOException {
		FTPClient cliente = new FTPClient();
		cliente.connect("127.0.0.1");
		boolean conectado = cliente.login("user", "password");
		cliente.enterLocalPassiveMode();
		cliente.setFileType(FTP.BINARY_FILE_TYPE);
		if (conectado) {
			System.out.println("Login correcto");
			System.out.println("~~~~~~~~/~~~~~~~~");

			File archivoSubida = new File("./Archivos/EjerciciosDB.pdf");
			FileInputStream is = new FileInputStream(archivoSubida);
			OutputStream os = cliente.storeFileStream("EjerciciosDB_Copia.pdf");
			byte[] buffer = new byte[1024];
			int bytesLeidos = 0;
			while ((bytesLeidos = is.read(buffer)) != -1) {
				os.write(buffer, 0, bytesLeidos);
			}
			is.close();
			os.close();
			if (cliente.completePendingCommand()) {
				System.out.println("Archivo subido correctamente.");
			} else {
				System.out.println("Problemas al subir el archivo.");
			}
		} else {
			System.err.println("Error en el login");
		}
		cliente.disconnect();

	}

}
