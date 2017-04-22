package es.unileon.ulebankoffice.repository;
/**
 * @author Razvan Raducu
 *
 */

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;

import es.unileon.ulebankoffice.configuration.MongoTestConfig;
import es.unileon.ulebankoffice.domain.ClienteDomain;
import es.unileon.ulebankoffice.domain.CuentaCorrienteDomain;
import es.unileon.ulebankoffice.domain.DNIException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class CuentaCorrienteRepositoryTest {
	
	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	@Autowired
	private CuentaCorrienteRepository repo;
	
	@After
	public void afterEachMethod(){
		repo.deleteAll();
	}
	
	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/cuentaCorrienteRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindAll() throws ParseException, DNIException {
		
		assertEquals(3, repo.findAll().size());
		CuentaCorrienteDomain cuenta = new CuentaCorrienteDomain("x5526828c", "abierta", 20.0, 5.0, 7.0, 3.0);
		repo.save(cuenta);
		cuenta = new CuentaCorrienteDomain("x5526828c", "abierta", 20500.0, 5.0, 7.0, 3.0);
		repo.save(cuenta);
		assertEquals(5, repo.findAll().size());
//		System.out.println(mongo.toString() + "\n" + mongo.getServerAddressList());
//		List <ClienteDomain> clientes = clienteRepository.findAll();
//		System.out.println("[");
//		for (ClienteDomain clienteDomain : clientes) {
//			System.out.println(clienteDomain);
//		}
//		System.out.println("]");
		
//		List<ClienteDomain> clientes = clienteRepository.findAll();
//		System.out.println(clientes.size());
//		fail("Not yet implemented");
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/cuentaCorrienteRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByDni() {
		List<CuentaCorrienteDomain> cuentasR = repo.findByDni("X5526828C");
		List<CuentaCorrienteDomain> cuentasO = repo.findByDni("X4975127C");
		List<CuentaCorrienteDomain> cuentasW = repo.findByDni("X5526828D");
		
		//Hamcrest notation
		assertThat(cuentasR.size(), is(2));
		assertThat(cuentasO.size(), is(1));
		assertThat(cuentasW.size(), is(0));

		
	}
	
	@Test
	public void testFindByDniNonExistent(){
		List<CuentaCorrienteDomain> cuentas = repo.findByDni("X5526828D");
		assertThat(cuentas.size(), is(0));
		cuentas = repo.findAll();
		assertThat(cuentas.size(), is(0));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/cuentaCorrienteRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDeleteByDni() {
		
		
		assertThat(repo.findAll().size(), is(3));
		
		repo.deleteByDni("X5526828C");
		assertThat(repo.findAll().size(), is(1));

	}
	
	@Test
	@UsingDataSet(locations = { "/testing/cuentaCorrienteRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDelete() {
		
		List<CuentaCorrienteDomain> cuentas = repo.findAll();
		assertThat(cuentas.size(), is(3));
		
		assertThat(cuentas.get(0).getDni().toString(), is("X5526828C"));
		assertThat(repo.findByDni("X5526828C").size(), is(2));
		
		repo.delete(cuentas.get(0));
		assertThat(repo.findByDni("X5526828C").size(), is(1));
		repo.deleteByDni("X5526828C");
		
		cuentas = repo.findAll();
		assertThat(cuentas.size(), is(1));
		

	}
	
	@Test
	@UsingDataSet(locations = { "/testing/cuentaCorrienteRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testSave() {
		
		List<CuentaCorrienteDomain> cuentasR = repo.findByDni("X5526828C");
		
		CuentaCorrienteDomain cuenta = cuentasR.get(0);
		
		cuenta.ingresarSaldo(500.00);
		
		repo.save(cuenta);
		
		cuenta = repo.findById(cuenta.getId());
		
		
		assertThat(cuenta.getSaldo(), is(600.00));
		
		List<CuentaCorrienteDomain> cuentas = repo.findByDni("X4975127C");
		assertThat(cuentas.get(0).getEstado(), is("abierta"));
		
		cuentas.get(0).setEstado("cerrada");
		repo.save(cuentas.get(0));
		cuentas = repo.findByDni("X4975127C");
		assertThat(cuentas.get(0).getEstado(), is("cerrada"));
		
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/cuentaCorrienteRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void tesInsert() throws DNIException, ParseException {
		List<CuentaCorrienteDomain> cuentasR = repo.findByDni("X5526828C");
		
		//Hamcrest notation
		assertThat(cuentasR.size(), is(2));
	
		CuentaCorrienteDomain nuevaCuenta = new CuentaCorrienteDomain("X5526828C", "abierta", 200.00, 300.00, 150.0, 2.0);
		repo.save(nuevaCuenta);
		
		cuentasR = repo.findByDni("X5526828C");
		assertThat(cuentasR.size(), is(3));
		
	}
}
