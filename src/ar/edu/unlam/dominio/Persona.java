package ar.edu.unlam.dominio;

import java.util.Objects;

public class Persona implements Comparable<Persona> {

	// Comparable: plantea el ordenamiento natural de una coleccion
	// Comparator: define un ordenamiento especifico posible de aplicar a una coleccion

	private String nombre;
	private Integer edad;

	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public int compareTo(Persona o) {
		//return this.edad - o.getEdad();
		return o.getEdad().compareTo(this.edad);
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(edad, other.edad) && Objects.equals(nombre, other.nombre);
	}

	public Integer getEdad() {
		return this.edad;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return "Soy: " + this.nombre;
	}
	
}
