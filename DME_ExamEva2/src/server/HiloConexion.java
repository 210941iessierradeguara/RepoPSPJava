package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HiloConexion implements Runnable{
	Socket sock;
	String ipClient = "127.0.0.1";
	
	public HiloConexion(Socket sock) {
		this.sock = sock;
	}

	@Override
	public void run() {
		
		DataInputStream entrada = null;
		DataOutputStream salida = null;
		Resultado resultado = null;
		
		//recordar: pasar el string atributo a element antes de mandar????
		
		try {
			entrada = new DataInputStream(sock.getInputStream());
			String url = entrada.readUTF(); //primera lectura URL
			System.out.println("URL recibida: " + url);
			String selector = entrada.readUTF(); //segunda lectura
			System.out.println("selector recibido: " + selector);
			
			//Webscraping
			
			HttpClient cliente = HttpClient.newHttpClient();
			HttpRequest req = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.GET()
					.build();
			
			//Recibo la respuesta como string // codificado con el charset iso-8859-15
			try {
				HttpResponse<String> res = cliente.send(req, 
						HttpResponse.BodyHandlers.ofString(Charset.forName("ISO-8859-15")));
				
				Document doc = Jsoup.parse(res.body());
				
				
				Elements elementos = doc.select(selector);
				for (Element element : elementos) {
					//System.out.println(element.text()); //intento de probar si llega algo
					resultado = new Resultado(url, selector, ipClient, element.toString());
				}
				
			} catch (InterruptedException e) {
				System.err.println("Error en el HTTP Response cliente.send etc...");
				e.printStackTrace();
			}
			//Webscraping
			
			
			salida = new DataOutputStream(sock.getOutputStream());
			salida.writeUTF(resultado.getAtributo().toString());
		} catch (IOException e) {
			System.out.println("Data input/output stream");
			e.printStackTrace();
		}
		
		try {
			salida.close();
			entrada.close();
		} catch (IOException e) {
			System.err.println("cerrar salida");
			e.printStackTrace();
		}
		
	}
}
