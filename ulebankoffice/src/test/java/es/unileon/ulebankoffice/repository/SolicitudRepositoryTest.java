package es.unileon.ulebankoffice.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Matchers.notNull;

import org.junit.After;
import org.junit.Before;
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
import es.unileon.ulebankoffice.domain.SolicitudDomain;

/**
 * @author Razvan Raducu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class SolicitudRepositoryTest {
	
	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	@Autowired
	private SolicitudRepository repo;
	
	@After
	public void afterEachMethod(){
		repo.deleteAll();
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}
	
	
	@Test
	@UsingDataSet(locations = { "/testing/solicitudRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFingByProductId() {
		SolicitudDomain solicitud = repo.findByProductId("id1");
		assertNotNull(solicitud);
		System.out.println(solicitud);
		assertThat(solicitud.getEstado(), is("En trámite"));
		assertThat(solicitud.getFechaResolucion(), is(notNull()));
		solicitud = repo.findByProductId("id2");
		assertThat(solicitud, is(notNullValue()));
		assertThat(solicitud.getEstado(), is("Aceptada"));
		assertThat(solicitud.getFechaResolucion(), is(notNullValue()));
		solicitud = repo.findByProductId("id3");
		assertThat(solicitud, is(notNullValue()));
		assertThat(solicitud.getEstado(), is("Aceptada"));
		assertThat(solicitud.getFechaResolucion(), is(notNullValue()));
		solicitud = repo.findByProductId("id4");
		assertThat(solicitud, is(notNullValue()));
		assertThat(solicitud.getEstado(), is("Cancelada"));
		assertThat(solicitud.getFechaResolucion(), is(notNullValue()));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/solicitudRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFingByProductIdNonExistent() {
		SolicitudDomain solicitud = repo.findByProductId("id5");
		assertThat(solicitud, is(nullValue()));
		assertNull(solicitud);
	}

}
