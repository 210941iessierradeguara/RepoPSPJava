package clienteFTP;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Programa {
	public static void mostrarContenido(FTPClient cliente, String carpeta, String prefijo) throws IOException
	{
		//LISTAR ARCHIVOS/directorios (recursivo)
		cliente.cwd(carpeta);
		FTPFile[] archivos = cliente.listFiles();
		for (FTPFile ftpFile : archivos) {
			if (ftpFile.isFile())
			{
				System.out.println(prefijo + ftpFile.getName());					
			}
			else 
			{
				System.out.println(prefijo + ftpFile.getName() + "/");
				mostrarContenido(cliente, ftpFile.getName(), prefijo + "\t");
				cliente.changeToParentDirectory();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		FTPClient cliente = new FTPClient();
		cliente.connect("127.0.0.1");
		boolean conectado = cliente.login("user", "password");
		if(conectado)
		{
			System.out.println("Login correcto");
			//CAMBIAR DIRECTORIO
			//cliente.changeWorkingDirectory("img"); // se puede abreviar a cliente.cwd
			System.out.println("~~~~~~~~/~~~~~~~~");
			mostrarContenido(cliente, "/", "");
		}
		else
		{
			System.err.println("Error en el login");
		}
		cliente.disconnect();
	}
}
