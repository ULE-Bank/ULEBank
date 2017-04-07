package es.unileon.ulebankoffice.repository;
/**
 * @author Razvan Raducu
 *
 */

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

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
import es.unileon.ulebankoffice.domain.DocumentoAdjuntoDomain;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class DocumentoRepositoryTest {
	
	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	@Autowired
	private DocumentoRepository repo;
	
	
	@After
	public void afterEachMethod() throws Exception {
		repo.deleteAll();
	}
	
	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByDniId() {
		List<DocumentoAdjuntoDomain> documento = repo.findByDni("X5526828C");
		assertThat(documento.size(), is(2));
		documento = repo.findByDni("06152676S");
		assertThat(documento.size(), is(1));
		documento = repo.findByDni("X1788553G");
		assertThat(documento.size(), is(1));
	
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByDniIdNonExistent() {
	List<DocumentoAdjuntoDomain> documento = repo.findByDni("Y6139454X");
	assertThat(documento.size(), is(0));
	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByProductId() {
		List<DocumentoAdjuntoDomain> documento = repo.findByProductId("id1");
		System.out.println(documento.size());
		assertThat(documento.size(), is(4));
		documento = repo.findByProductId("id2");
		assertThat(documento.size(), is(2));
		documento = repo.findByProductId("id3");
		assertThat(documento.size(), is(1));
	
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByProductIdNonExistent() {
		List<DocumentoAdjuntoDomain> documento = repo.findByProductId("id4");
		assertThat(documento.size(), is(0));
	}

}
