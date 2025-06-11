package ar.edu.unlam.dominio.comparadores;

import java.util.Comparator;

import ar.edu.unlam.dominio.Persona;

public class OrdenAscendenteDePersonasPorEdad implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getEdad().compareTo(o2.getEdad());
	}

}
