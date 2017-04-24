package es.unileon.ulebankoffice.domain;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;

import es.unileon.ulebankoffice.configuration.MongoTestConfig;
import es.unileon.ulebankoffice.repository.DocumentoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class DocumentosTest {
	
	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");
	
	private Documentos documentos;
	
	
	@Autowired
	private DocumentoRepository repo;

	@Before
	public void setUp() throws Exception { 
		documentos = new Documentos();
		ReflectionTestUtils.setField(documentos, "repo", repo);

	}
	
	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)

	public void testAddDocumento() {
		assertThat(repo.findAll().size(), is(6));
		documentos.addDocumento(new DocumentoAdjuntoDomain("rutaEjemplo", "NombreEjemplo"));
		assertThat(repo.findAll().size(), is(7));
	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testGetDocumentos() {
		List<String> idDocumentos = new ArrayList<>();
		idDocumentos.add("documentId1");
		assertThat(documentos.getDocumentos(idDocumentos).size(), is(1));
		idDocumentos.add("documentId2");
		idDocumentos.add("documentId3");
		assertThat(documentos.getDocumentos(idDocumentos).size(), is(3));
		idDocumentos.add("documentId4");
		idDocumentos.add("documentId5");
		idDocumentos.add("documentId6");
		assertThat(documentos.getDocumentos(idDocumentos).size(), is(6));
	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testGetDocumentosByDateAsc() {
		List<String> idDocumentos = new ArrayList<>();
		idDocumentos.add("documentId1");
		idDocumentos.add("documentId2");
		idDocumentos.add("documentId3");
		idDocumentos.add("documentId4");
		idDocumentos.add("documentId5");
		idDocumentos.add("documentId6");
		List<DocumentoAdjuntoDomain> listaDocumentos = documentos.getDocumentosByDateAsc(idDocumentos);
		assertThat(listaDocumentos.get(0).getName(), is("documento3"));
		assertThat(listaDocumentos.get(1).getName(), is("documento5"));
		assertThat(listaDocumentos.get(2).getName(), is("documento6"));
		assertThat(listaDocumentos.get(3).getName(), is("documento4"));
		assertThat(listaDocumentos.get(4).getName(), is("documento2"));
		assertThat(listaDocumentos.get(5).getName(), is("documento1"));
	}

}
