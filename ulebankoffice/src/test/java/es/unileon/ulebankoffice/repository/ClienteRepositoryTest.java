/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.text.ParseException;

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
import es.unileon.ulebankoffice.domain.DNIException;

/**
 * @author Razvan Raducu
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class ClienteRepositoryTest {

	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	@Autowired
	private ClienteRepository clienteRepository;
	
	@After
	public void afterEachMethod(){
		clienteRepository.deleteAll();
	}
	
	@Test
	public void testNoRepeatedDNI() throws ParseException, DNIException {
		try {
			ClienteDomain cliente = new ClienteDomain("razvan", "raducu", "r@r.com", "1994-12-05","x5526828C", null);
			
			
			ClienteDomain cliente2 = new ClienteDomain("razvan", "raducu", "r@r.com", "1994-02-05","x5526828C", null);
			

			clienteRepository.save(cliente);
			clienteRepository.save(cliente2);
			
				
		} catch (Exception e) {
			assertEquals(e.getCause().getClass(), com.mongodb.DuplicateKeyException.class);
			assertEquals(1, clienteRepository.findAll().size());
			assertEquals(e.getClass(), org.springframework.dao.DuplicateKeyException.class);
		}
	}
	
	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}

	@Test
	@UsingDataSet(locations = { "/testing/clienteRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindAll() throws ParseException, DNIException {
		
		assertEquals(1, clienteRepository.findAll().size());
		clienteRepository.save(new ClienteDomain("razvan", "raducu", "r@r.com", "1994-12-05","X7077794G", null));
		clienteRepository.save(new ClienteDomain("razvan", "raducu", "r@r.com", "1994-07-05","08336515G", null));
		assertEquals(3, clienteRepository.findAll().size());
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
	@UsingDataSet(locations = { "/testing/clienteRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByDni(){
		
		try {
			System.out.println(clienteRepository.findAll());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getClass());
			System.out.println(e.toString());
		}
		
		
		ClienteDomain cliente = clienteRepository.findByDni("X5526828C");
		System.out.println(cliente);
		assertEquals("Razvan", cliente.getName());
		assertEquals("Raducu", cliente.getLastname());
		
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/clienteRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByDniNonExistent(){
		
		ClienteDomain cliente = clienteRepository.findByDni("R5526828C");
		
		//Hamcrest notation
		assertThat(cliente, is(nullValue()));
		
		assertNull(cliente);
		
	}
	
	
}
