package ej03_ContadorSimple;

public class Contador {
	private boolean positivo;
	private int numero;

	public Contador(boolean positivo) {
		super();
		this.positivo = positivo;
		this.numero = 0;
	}
	
	// Visibilidad, sincronización, vuelta
	public synchronized void contar() {
		if(positivo)
		{
			this.numero++;
		}
		else
		{
			this.numero--;
		}
	}
	
	public synchronized void descontar() {
		if(!positivo)
		{			
				this.numero++;
		}
		else
		{
				this.numero--;		
		}
	}

	@Override
	public String toString() {
		return "Contador [positivo=" + positivo + ", numero=" + numero + "]";
	}
}
