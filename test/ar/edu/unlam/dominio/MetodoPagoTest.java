package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MetodoPagoTest {

	private MetodoPago metodoPago;

	@Before
	public void init() {
		this.metodoPago = new MetodoPago();
	}

	@Test
	public void dadoQueExisteMetodoDePagoCuandoProcesoUnPagoConMonto100ObtengoNull() {
		// preparacion
		Double monto = 100d;

		// ejecucion
		Double montoObtenido = this.metodoPago.procesarPago(monto);

		// verificacion
		assertNull(montoObtenido);
	}

	@Test
	public void dadoQueExisteUnMetodoDePagoMercadoPagoCuandoProcesoUnPagoDe100Obtengo112() {
		Double monto = 100d;
		MercadoPago mercadoPago = new MercadoPago();

		Double montoObtenido = mercadoPago.procesarPago(monto);

		Double montoEsperado = 112d;
		assertEquals(montoEsperado, montoObtenido);
	}

	/**
	 * Metodo solo para mostrar el uso de instanceof No se deben usar println en
	 * tests salvo que necesite ver algun dato (usar watch)
	 */
	@Test
	public void metodoParaVerInstanceof() {
		MetodoPago metododoTC = new TransferenciaBancaria();
		MetodoPago metodoMP = new MercadoPago();

		List<MetodoPago> metodosDePago = new ArrayList<>();

		List<MercadoPago> metodosDePagoMP = new ArrayList<>();
		metodosDePagoMP.add((MercadoPago) metodoMP);
		//metodosDePagoMP.add((MercadoPago) metododoTC);

		if (metododoTC instanceof MercadoPago) {
			metodosDePagoMP.add((MercadoPago) metododoTC);
		}

		metodosDePago.add(metodoMP);
		metodosDePago.add(metododoTC);

		boolean encontrado = false;

		for (int i = 0; i < metodosDePago.size() && !encontrado; i++) {

		}

		for (MetodoPago mp : metodosDePago) {

			if (mp instanceof MercadoPago) {
				System.out.println(mp.getClass() + " Es mercado pago");
				break;
			} else {
				System.out.println(mp.getClass() + " NO es mercado pago");
			}
		}

	}

}
