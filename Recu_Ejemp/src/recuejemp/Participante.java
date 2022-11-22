package recuejemp;

public class Participante extends Thread {
	private ResultadoSorteo resultado;
	private int numeroBoleto;
	
	public Participante(ResultadoSorteo resultado, int numeroBoleto) {
		super();
		this.resultado = resultado;
		this.numeroBoleto = numeroBoleto;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (numeroBoleto == resultado.consultarNumeroPremiado())
			{
				System.out.println("V");
			} 
			else 
			{
				System.out.println("D");
			}
		}
		super.run();
	}
}
