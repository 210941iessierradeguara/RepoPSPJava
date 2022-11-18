package ej12_colaProductorConsumidor;

import java.util.concurrent.BlockingDeque;

public class Consumidor implements Runnable {
	BlockingDeque<String> cola;
	
	public Consumidor(BlockingDeque<String> cola) {
		super();
		this.cola = cola;
	}
	
	@Override
	public void run() {
		

	}

}
