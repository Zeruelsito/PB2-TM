package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MercadoPagoTest {

	private MercadoPago mercadoPago;
	
	@Before
	public void init() {
		this.mercadoPago = new MercadoPago();
	}
	
	@Test
	public void dadoQueExisteMercadoPagoCuandoProcesoUnPagoConMonto100Obtengo112() {
		// preparacion
		Double monto = 100d;
		
		// ejecucion
		Double montoObtenido = this.mercadoPago.procesarPago(monto);
		
		// verificacion
		Double montoEsperado = 112d;
		assertEquals(montoEsperado, montoObtenido);
	}
	
	@Test
	public void dadoQueExisteMercadoPagoCuandoProcesoUnPagoConMonto200Obtengo224() {
		// preparacion
		Double monto = 200d;
		
		// ejecucion
		Double montoObtenido = this.mercadoPago.procesarPago(monto);
		
		// verificacion
		Double montoEsperado = 224d;
		assertEquals(montoEsperado, montoObtenido);
	}
}
