package ej11_ColeccionConcurrente;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Hilo extends Thread {
	ConcurrentHashMap<String, String> mapa;	
	
	public Hilo(ConcurrentHashMap<String, String> mapa) {
		super();
		this.mapa = mapa;
	}
	
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			mapa.put("Barcelona", "España");
			mapa.put("Sevilla", "España");
			mapa.put("Jaén", "España");
			mapa.put("París", "Francia");
			System.out.println("He metido 4 cosas");
		}
	}
	
}
