package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TarjetaCreditoTest {

	@Test
	public void dadoQueExisteMetodoDePagoTCCuandoProcesoUnPagoConMontoMenorA100000Obtengo100000() {
		Double monto = 100000d;
		TransferenciaBancaria transferenciaBancaria = new TransferenciaBancaria();
		
		Double montoObtenido = transferenciaBancaria.procesarPago(monto);
		
		Double montoEsperado = 100000d;
		assertEquals(montoEsperado, montoObtenido);
	}
	
	@Test
	public void dadoQueExisteMetodoDePagoTCCuandoProcesoUnPagoConMonto200000Obtengo202000() {
		Double monto = 200000d;
		TransferenciaBancaria transferenciaBancaria = new TransferenciaBancaria();
		
		Double montoObtenido = transferenciaBancaria.procesarPago(monto);
		
		Double montoEsperado = 202000d;
		assertEquals(montoEsperado, montoObtenido);
	}
}
