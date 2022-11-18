package ej12_colaProductorConsumidor;

import java.util.concurrent.BlockingDeque;

public class Productor implements Runnable {
	BlockingDeque<String> cola;
		
	public Productor(BlockingDeque<String> cola) {
		super();
		this.cola = cola;
	}

	@Override
	public void run() {		
		for (int j = 0; j < 40; j++) {
			cola.add(Thread.currentThread().getName()+"Mensaje" + j);
			
		}

	}

}
