package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.excepciones.CantidadIvalidaDeCirculosException;
import ar.edu.unlam.dominio.excepciones.CantidadIvalidaDeTriangulosException;

public class ClaseDeTest {

	private CajaDeFiguras cajaDeFiguras;
	
	@Before
	public void init() {
		this.cajaDeFiguras = new CajaDeFiguras();
	}
	
	@Test
	public void metodoParaExplicarClaseAbstractaEInterfaz() {
		Figura rectangulo = new Rectangulo("Azul");
		Figura circulo = new Circulo("");
		Figura triangulo = new Triangulo("");
		rectangulo.obtenerColor();
		rectangulo.calcularArea();
		rectangulo.calcularPerimetro();

		Rectangulo rectanguloDos = new Rectangulo("Rojo");
		rectanguloDos.obtenerColor();
		rectanguloDos.calcularArea();
		rectanguloDos.calcularPerimetro();
		List<Figura> figuras;
		List<Arte> artes = new ArrayList<>();

		Arte circuloDos = new Circulo("");
		artes.add(circuloDos);
		artes.add(circulo);
		int numero = 2;
		
		if (numero == 1) {
			figuras = new ArrayList<>();
			figuras.size();
		} else {
			figuras = new LinkedList<>();
		}

		figuras.add(rectangulo);
		figuras.add(rectanguloDos);
		figuras.add(triangulo);
		figuras.add(circulo);
//		figuras.add((Figura) circuloDos);

		List<Rectangulo> rectangulos = new ArrayList<>();
		rectangulos.add((Rectangulo) rectangulo);
		rectangulos.add(rectanguloDos);
//		rectangulos.add((Rectangulo) circulo);

	}

	@Test(expected = CantidadIvalidaDeCirculosException.class)
	public void dadoQueExisten2CirculosCuandoAgregoUnTercerCirculoObtengoUnaCantidadIvalidaDeCirculosException()
			throws CantidadIvalidaDeCirculosException, CantidadIvalidaDeTriangulosException {

		Arte circulo = new Circulo("Verde");
		Figura circuloDos = new Circulo("Rojo");
		Circulo circuloTres = new Circulo("Azul");

		this.cajaDeFiguras.agregar((Figura) circulo);
		this.cajaDeFiguras.agregar(circuloDos);
		this.cajaDeFiguras.agregar(circuloTres);

		// Para manejar excepciones
//		try {
//
//			cajaDeFiguras.agregar((Figura) circulo);
//
//		} catch (CantidadIvalidaDeCirculosException e) {
//			// log.error(e);
//			System.out.println(e.getMessage());
//		} catch (RuntimeException re) {
//			System.out.println(re.getMessage());
//		} catch (Exception e) {
//
//		}

	}

	@Test(expected = CantidadIvalidaDeTriangulosException.class)
	public void dadoQueExisten3TriangulosCuandoAgregoUnTercerTrianguloObtengoUnaCantidadIvalidaDeTriangulosException()
			throws CantidadIvalidaDeCirculosException, CantidadIvalidaDeTriangulosException {

		Arte triangulo = new Triangulo("Verde");
		Figura trianguloDos = new Triangulo("Rojo");
		Triangulo trianguloTres = new Triangulo("Azul");

		this.cajaDeFiguras.agregar((Figura) triangulo);
		this.cajaDeFiguras.agregar(trianguloDos);
		this.cajaDeFiguras.agregar(trianguloTres);
		this.cajaDeFiguras.agregar(trianguloTres);
	}
}
