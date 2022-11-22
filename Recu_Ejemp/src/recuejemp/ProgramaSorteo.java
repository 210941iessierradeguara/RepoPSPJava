package recuejemp;

import java.util.ArrayList;

public class ProgramaSorteo {

	public static void main(String[] args) {
		ResultadoSorteo resultado = new ResultadoSorteo();
		ArrayList<Thread> participantes = new ArrayList<>();
		int nPar = 0;
		
		for (int i = 1; i <= 5; i++) {
			Participante p = new Participante(resultado, i);
			participantes.add(p);
			p.start();
			
			nPar++;
		}
		Thread tSorteo = new Thread(new Sorteo(resultado, nPar));
		//Sorteo sorteo = new Sorteo(resultado, nPar);
		tSorteo.start();
		try {
			tSorteo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (Thread participante : participantes) {
			synchronized (participante) {
				participante.notify();
			}
		}
		
		for (Thread thread : participantes) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("El número premiado es el: " + resultado.consultarNumeroPremiado());
		
	}

}
