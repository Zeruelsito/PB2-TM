package ar.edu.unlam.dominio;

public class MercadoPago extends MetodoPago {

	@Override
	public Double procesarPago(Double monto) {
		return (double) Math.round(monto * 1.12);
	}

}
