package recuejemp;

public class ResultadoSorteo {
	private int premiado;

	public synchronized int consultarNumeroPremiado() {
			return premiado;
	}

	public synchronized void establecerNumeroPremiado(int premiado) {
		this.premiado = premiado;
	}
	
}
