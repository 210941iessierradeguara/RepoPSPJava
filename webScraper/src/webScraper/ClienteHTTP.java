package webScraper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClienteHTTP {

	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient cliente = HttpClient.newHttpClient();;
		HttpRequest req = HttpRequest.newBuilder()
							.uri(URI.create("https://www.meteoclimatic.net/perfil/ESARA2200000022002A"))
							.GET()
							.build();
		//Recibo la respuesta como String
		HttpResponse<String> res = cliente.send(req, HttpResponse.BodyHandlers.ofString(
				Charset.forName("ISO-8859-15")));
		//Recibo la respuesta como fichero descargado
		//HttpResponse<Path> resPath = cliente.send(req, HttpResponse.BodyHandlers.ofFile(Paths.get("descargado.html")));
		//Recibo la respuesta mediante un stream
		//HttpResponse<InputStream> resStream = cliente.send(req, HttpResponse.BodyHandlers.ofInputStream());
		//Hacer directamente la coneción
		Document doc = Jsoup.parse(res.body());
		
		Elements elementos = doc.select("td.dadesactuals:nth-child(1), td.dadesactuals:nth-child(3),"
				+ " td.dadesactuals:nth-child(9)");
		
		for (Element element : elementos) {
			System.out.println(element.text());
		}
		
		System.out.println(res);
		//System.out.println(res.body());
	}
}