package ej02_Hilos;

public class Hilo1 extends Thread {
	int segundos;

	public Hilo1(int segundos) {
		super();
		this.segundos = segundos;
	}

	public Hilo1() {
		super();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hola soy el hilo " + this.getId());
		super.run();
	}
}
