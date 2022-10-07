package ej02_Hilos;

public class HilosThread {

	public static void main(String[] args) throws InterruptedException {
		Hilo1 h1 = new Hilo1(2000);
		h1.start();
		System.out.println("He lanzado un hilo");
		h1.join();
		System.out.println("El hilo ha acabado");

	}

}
