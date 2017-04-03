package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CreditosTests {
	
	private CreditosDomain creditos;
	private double delta = 0.1;
	private double noDelta = 0.0;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Before
	public void setUp() throws Exception {
		List<MovimientosCreditosDomain> movimientos = new ArrayList<MovimientosCreditosDomain>();
		movimientos.add(new MovimientosCreditosDomain("1", 55000, sdf.parse("2016-07-10")));
		movimientos.add(new MovimientosCreditosDomain("2", -10000, sdf.parse("2016-07-20")));
		movimientos.add(new MovimientosCreditosDomain("3", -46080, sdf.parse("2016-07-28")));
		
		creditos = new CreditosDomain(60000, sdf.parse("2016-07-01"), sdf.parse("2016-07-31"), 
				6, 21, 0, 1.5, movimientos);
		
		creditos.incluirComsionAperturaYCorretaje(10, 3);
	}
	
	@Test
	public void testSetAndGetLimiteCredito() {
		assertEquals(60000, creditos.getLimiteCredito(), noDelta);
		creditos.setLimiteCredito(50000);
		assertEquals(50000, creditos.getLimiteCredito(), noDelta);
	}
	
	@Test
	public void testSetAndGetFechaApertura() throws ParseException {
		assertEquals(sdf.parse("2016-07-01"), creditos.getFechaApertura());
		creditos.setFechaApertura(sdf.parse("2016-07-02"));
		assertEquals(sdf.parse("2016-07-02"), creditos.getFechaApertura());
	}
	
	@Test
	public void testSetAndGetFechaVencimiento() throws ParseException {
		assertEquals(sdf.parse("2016-07-31"), creditos.getFechaVencimiento());
		creditos.setFechaVencimiento(sdf.parse("2016-07-30"));
		assertEquals(sdf.parse("2016-07-30"), creditos.getFechaVencimiento());
	}
	
	@Test
	public void testSetAndGetInteresDeudor() {
		assertEquals(0.06, creditos.getInteresDeudor(), noDelta);
		creditos.setInteresDeudor(7);
		assertEquals(0.07, creditos.getInteresDeudor(), noDelta);
	}
	
	@Test
	public void testSetAndGetInteresExcedido() {
		assertEquals(0.21, creditos.getInteresExcedido(), noDelta);
		creditos.setInteresExcedido(17);
		assertEquals(0.17, creditos.getInteresExcedido(), noDelta);
	}
	
	@Test
	public void testSetAndGetInteresAcreedor() {
		assertEquals(0.0, creditos.getInteresAcreedor(), noDelta);
		creditos.setInteresAcreedor(5);
		assertEquals(0.05, creditos.getInteresAcreedor(), noDelta);
	}
	
	@Test
	public void testSetAndGetComisionSMND() {
		assertEquals(0.0015, creditos.getComisionSMND(), noDelta);
		creditos.setComisionSMND(2.1);
		assertEquals(0.0021, creditos.getComisionSMND(), delta);
	}
	
	@Test
	public void testSetAndGetMovimientos() throws ParseException {
		assertEquals(5, creditos.getMovimientos().size());
		
		List<MovimientosCreditosDomain> newMovimientos = new ArrayList<MovimientosCreditosDomain>();
		newMovimientos.add(new MovimientosCreditosDomain("1", 55000, sdf.parse("2016-07-10")));
		
		creditos.setMovimientos(newMovimientos);
		
		assertEquals(1, creditos.getMovimientos().size());
	}

	@Test
	public void testCalcular() {
		assertEquals(-300.0, Double.parseDouble(creditos.calcular().get(4).get(0)), delta);
	}
}
