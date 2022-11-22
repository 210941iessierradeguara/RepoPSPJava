package recuejemp;

public class Sorteo implements Runnable {
	private ResultadoSorteo resultado;
	private int nParticipantes;
	
	public Sorteo(ResultadoSorteo resultado, int nParticipantes) {
		super();
		this.resultado = resultado;
		this.nParticipantes = nParticipantes;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			int numPremiado = (int) (Math.random()*(nParticipantes - 1) + 1);
			resultado.establecerNumeroPremiado(numPremiado);
			System.out.println("Premiado: " + numPremiado);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
