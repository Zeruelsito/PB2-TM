package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import ar.edu.unlam.dominio.comparadores.OrdenAscendenteDePersonasPorEdad;
import ar.edu.unlam.dominio.comparadores.OrdenDescendenteDePersonasPorNombre;

public class OrdenamientoTest {

	@Test
	public void usosBasicosDeMap() {

		Map<String, Persona> mapa = new HashMap<>();
		mapa.put("c", new Persona("Carlos", 40));
		mapa.put("a", new Persona("Alejandro", 40));
		mapa.put("a", new Persona("Amador", 40));
		mapa.put("m", new Persona("Matias", 30));

		Persona amador = mapa.get("a");

		Map<Integer, List<Persona>> mapaConColeccion = new HashMap<>();

		mapaConColeccion.put(1, new ArrayList<>());
		mapaConColeccion.put(2, new ArrayList<>());
		mapaConColeccion.put(3, new ArrayList<>());

		List<Persona> coleccionUno = mapaConColeccion.get(1);
		coleccionUno.add(amador);
		mapaConColeccion.put(1, coleccionUno);

		mapaConColeccion.get(1).add(new Persona("Oscar", 55));
	}

	@Test
	public void dadoQueTengoPersonasAlAgregarlasAUnaColeccionTreeSetSeEncuentranOrdenadasPorEdadDescendente() {

		Persona carlos = new Persona("Carlos", 40);
		Persona matias = new Persona("Matias", 30);
		Persona alejandro = new Persona("Alejandro", 20);

		Set<Persona> personas = new TreeSet<>();
		personas.add(matias);
		personas.add(alejandro);
		personas.add(carlos);

		Persona primeraPersonaEsperada = new Persona("Carlos", 40);
		Persona segundaPersonaEsperada = new Persona("Matias", 30);
		Persona terceraPersonaEsperada = new Persona("Alejandro", 20);

		int indice = 0;
		for (Persona persona : personas) {

			switch (indice) {
			case 0:
				assertEquals(primeraPersonaEsperada, persona);
				break;
			case 1:
				assertEquals(segundaPersonaEsperada, persona);
				break;
			case 2:
				assertEquals(terceraPersonaEsperada, persona);
				break;
			}

			indice++;
		}
	}

	@Test
	public void dadoQueTengoPersonasAlAgregarlasAUnaColeccionArrayListYOrdenarlasSeEncuentranOrdenadasPorEdadDescendente() {
		Persona carlos = new Persona("Carlos", 40);
		Persona matias = new Persona("Matias", 30);
		Persona alejandro = new Persona("Alejandro", 20);
		Persona alejandroDos = new Persona("Amador", 20);

		List<Persona> personas = new ArrayList<>();
		personas.add(matias);
		personas.add(alejandro);
		personas.add(alejandroDos);
		personas.add(carlos);

		Persona primeraPersonaEsperada = new Persona("Carlos", 40);
		Persona segundaPersonaEsperada = new Persona("Matias", 30);
		Persona terceraPersonaEsperada = new Persona("Alejandro", 20);

		Collections.sort(personas);

		assertEquals(primeraPersonaEsperada, personas.get(0));
		assertEquals(segundaPersonaEsperada, personas.get(1));
		assertEquals(terceraPersonaEsperada, personas.get(2));
	}

	@Test
	public void dadoQueTengoPersonasAlAgregarlasAUnaColeccionTreeSetConUnComparadorPorNombreSeEncuentranOrdenadasPorNombreDescendente() {
		Persona carlos = new Persona("Carlos", 40);
		Persona matias = new Persona("Matias", 30);
		Persona alejandro = new Persona("Alejandro", 20);
		Persona alejandroDos = new Persona("Amador", 20);

		Set<Persona> personasOrdenadasPorNombre = new TreeSet<>(new OrdenDescendenteDePersonasPorNombre());
		personasOrdenadasPorNombre.add(matias);
		personasOrdenadasPorNombre.add(alejandro);
		personasOrdenadasPorNombre.add(alejandroDos);
		personasOrdenadasPorNombre.add(carlos);

		Persona primeraPersonaEsperada = new Persona("Matias", 30);
		Persona segundaPersonaEsperada = new Persona("Carlos", 40);
		Persona terceraPersonaEsperada = new Persona("Amador", 20);
		Persona cuartaPersonaEsperada = new Persona("Alejandro", 20);

		int indice = 0;
		for (Persona persona : personasOrdenadasPorNombre) {

			switch (indice) {
			case 0:
				assertEquals(primeraPersonaEsperada, persona);
				break;
			case 1:
				assertEquals(segundaPersonaEsperada, persona);
				break;
			case 2:
				assertEquals(terceraPersonaEsperada, persona);
				break;
			case 3:
				assertEquals(cuartaPersonaEsperada, persona);
				break;
			}

			indice++;
		}

	}

	@Test
	public void dadoQueTengoPersonasAlAgregarlasAUnaColeccionTreeSetCuandoCombinoDosComparadoresSeEncuentranOrdenadasPorEdadAscendenteyNombreDescendente() {

		Persona carlos = new Persona("Carlos", 40);
		Persona matias = new Persona("Matias", 30);
		Persona alejandro = new Persona("Alejandro", 20);
		Persona alejandroDos = new Persona("Amador", 20);

		OrdenAscendenteDePersonasPorEdad ordenEdad = new OrdenAscendenteDePersonasPorEdad();
		OrdenDescendenteDePersonasPorNombre ordenNombre = new OrdenDescendenteDePersonasPorNombre();

		Comparator<Persona> comparadorPersonas = ordenEdad.thenComparing(ordenNombre);

		Set<Persona> personasOrdenadasPorNombre = new TreeSet<>(comparadorPersonas);
		personasOrdenadasPorNombre.add(matias);
		personasOrdenadasPorNombre.add(alejandro);
		personasOrdenadasPorNombre.add(alejandroDos);
		personasOrdenadasPorNombre.add(carlos);

		Persona primeraPersonaEsperada = new Persona("Amador", 20);
		Persona segundaPersonaEsperada = new Persona("Alejandro", 20);
		Persona terceraPersonaEsperada = new Persona("Matias", 30);
		Persona cuartaPersonaEsperada = new Persona("Carlos", 40);

		int indice = 0;
		for (Persona persona : personasOrdenadasPorNombre) {

			switch (indice) {
			case 0:
				assertEquals(primeraPersonaEsperada, persona);
				break;
			case 1:
				assertEquals(segundaPersonaEsperada, persona);
				break;
			case 2:
				assertEquals(terceraPersonaEsperada, persona);
				break;
			case 3:
				assertEquals(cuartaPersonaEsperada, persona);
				break;
			}

			indice++;
		}

	}
}
