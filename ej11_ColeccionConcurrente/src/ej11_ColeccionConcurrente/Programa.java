package ej11_ColeccionConcurrente;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Programa {
	public static void main(String[] args) {
		ConcurrentHashMap<String , String> mapa = new ConcurrentHashMap<>();
		
		Hilo hilo;
		ArrayList<Hilo> hijos = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			hilo = new Hilo(mapa);
			hilo.start();
			hijos.add(hilo);
		}
		for (Hilo hilo2 : hijos) {
			try {
				hilo2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(mapa);
	}
}
