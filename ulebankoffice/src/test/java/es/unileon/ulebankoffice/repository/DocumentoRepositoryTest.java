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
	public void testFindById() {
		DocumentoAdjuntoDomain documento = repo.findById("documentId1");
		assertThat(documento.getId(), is("documentId1"));
		assertThat(documento.getRuta(), is("c/ruta/de/ejemplo"));
		
		documento = repo.findById("documentId2");
		assertThat(documento.getId(), is("documentId2"));
		assertThat(documento.getRuta(), is("etc/var/lib"));
		
		documento = repo.findById("documentId3");
		assertThat(documento.getId(), is("documentId3"));
		assertThat(documento.getRuta(), is("etc/var/lib"));
		
		documento = repo.findById("documentId4");
		assertThat(documento.getId(), is("documentId4"));
		assertThat(documento.getRuta(), is("etc/var/lib"));
		
		documento = repo.findById("documentId5");
		assertThat(documento.getId(), is("documentId5"));
		assertThat(documento.getRuta(), is("etc/var/lib"));
		
		documento = repo.findById("documentId6");
		assertThat(documento.getId(), is("documentId6"));
		assertThat(documento.getRuta(), is("c/ruta/de/ejemplo2"));
		
		assertThat(repo.findAll().size(), is(6));
		
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDeleteById() {
		assertThat(repo.findAll().size(), is(6));
		
		repo.delete("documentId6");
		
		assertThat(repo.findAll().size(), is(5));
		
		assertNull( repo.findById("documentId6"));
		
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testSave() {
		assertThat(repo.findAll().size(), is(6));
		
		DocumentoAdjuntoDomain documento = repo.findById("documentId6");
		
		documento.setRuta("path/ex/ample");
		
		repo.save(documento);
		
		assertThat(repo.findAll().size(), is(6));
		
		documento = repo.findById("documentId6");
		
		assertThat(documento.getRuta(), is("path/ex/ample"));
			
	}

	
	
	
}
