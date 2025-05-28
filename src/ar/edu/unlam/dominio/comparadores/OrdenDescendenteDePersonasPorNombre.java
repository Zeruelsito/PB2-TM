package ar.edu.unlam.dominio.comparadores;

import java.util.Comparator;

import ar.edu.unlam.dominio.Persona;

public class OrdenDescendenteDePersonasPorNombre implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		return o2.getNombre().compareTo(o1.getNombre());
	}

}
