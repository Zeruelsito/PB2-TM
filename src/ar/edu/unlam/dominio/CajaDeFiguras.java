package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.dominio.excepciones.CantidadIvalidaDeCirculosException;
import ar.edu.unlam.dominio.excepciones.CantidadIvalidaDeTriangulosException;

public class CajaDeFiguras {

	private List<Figura> figuras;
	private Integer cantidadDeCirculos;
	private int cantidadDeTriangulos;

	public CajaDeFiguras() {
		this.figuras = new ArrayList<>();
		this.cantidadDeCirculos = 0;
		this.cantidadDeTriangulos = 0;
	}

	public Boolean agregar(Figura figura) throws CantidadIvalidaDeCirculosException, CantidadIvalidaDeTriangulosException {
		// Solo 2 circulos

		if (figura instanceof Circulo) {
			this.cantidadDeCirculos++;
		}
		
		if (figura instanceof Triangulo) {
			this.cantidadDeTriangulos++;
		}
		
		if (this.cantidadDeCirculos > 2) {
			throw new CantidadIvalidaDeCirculosException("Solo pueden existir 2 figuras circulo.");
		}
		
		if (this.cantidadDeTriangulos > 3) {
			throw new CantidadIvalidaDeTriangulosException("Solo pueden existir 3 figuras triangulo.");
		}

		return this.figuras.add(figura);
	}
}
