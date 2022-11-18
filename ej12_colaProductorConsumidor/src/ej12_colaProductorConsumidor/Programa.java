package ej12_colaProductorConsumidor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Programa {

	public static void main(String[] args) {
		BlockingDeque<String> cola = new LinkedBlockingDeque<>(50);
	}
}
