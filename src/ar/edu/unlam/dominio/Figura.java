package ar.edu.unlam.dominio;

public abstract class Figura extends Vehiculo implements Arte  {

	private Double area;
	private String color;
	
	public Figura(String color) {
		this.color = color;
	}
	
	public abstract Double calcularArea();
	public abstract Double calcularPerimetro();
	
	public String obtenerColor() {
		return this.color;
	}
	
	public void metodoDeSoporte() {
		
		
	}
}
