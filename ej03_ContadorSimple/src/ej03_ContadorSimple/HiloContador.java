package ej03_ContadorSimple;

public class HiloContador implements Runnable {
	private int vueltas;
	private Contador contador;
	
	
	public HiloContador(int vueltas, Contador contador) {
		super();
		this.vueltas = vueltas;
		this.contador = contador;
	}

	@Override
	public void run() {
		//Sección crítica. Cambia la variable compartida
		for (int i = 0; i < vueltas; i++) {			
			//Evita que otros puedan acceder al valor antes de tiempo.
			//Ayuda para convertir un programa en "Thread safe"
		//	synchronized (contador) { 
				contador.contar();
		//	}		
		}
	}
}
