package ar.edu.unlam.dominio;

public class TransferenciaBancaria extends MetodoPago {

	private static final double PORCENTAJE_AGREGADO = 1.01;

	@Override
	public Double procesarPago(Double monto) {
		Double montoFinal = monto;

		if(monto > 100000d) {
			montoFinal = monto * PORCENTAJE_AGREGADO;
		}
		
		return montoFinal;
	}

}
