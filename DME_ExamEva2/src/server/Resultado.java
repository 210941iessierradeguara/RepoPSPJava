package server;

import java.util.Date;

import org.jsoup.nodes.Element;

public class Resultado {	
	String url;
	String selector;
	Date creacion;
	String ipClient;
	String atributo;
	
	
	public Resultado(String url, String selector, String ipClient, String atributo) {
		super();
		this.url = url;
		this.selector = selector;
		this.creacion = new Date();
		this.ipClient = ipClient;
		this.atributo = atributo;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSelector() {
		return selector;
	}
	public void setSelector(String selector) {
		this.selector = selector;
	}
	public Date getCreacion() {
		return creacion;
	}
	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}
	public String getIpClient() {
		return ipClient;
	}
	public void setIpClient(String ipClient) {
		this.ipClient = ipClient;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	@Override
	public String toString() {
		return "Resultado [url=" + url + ", selector=" + selector + ", creacion=" + creacion + ", ipClient=" + ipClient
				+ ", atributo=" + atributo + "]";
	}
}
