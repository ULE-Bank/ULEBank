/**
 * 
 */
package es.unileon.ulebankoffice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

/**
 * @author Razvan Raducu
 *
 */

@Configuration
@EnableMongoRepositories(basePackages = "es.unileon.ulebankoffice.repository")
public class MongoTestConfig extends AbstractMongoConfiguration{

	private final String DB_NAME = "ulebankofficetestdb";
	
	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return DB_NAME;
	}

	@Override
	@Bean
	public Mongo mongo() {
		// TODO Auto-generated method stub
		return new Fongo(getDatabaseName()).getMongo();
	}
	
	@Override
	protected String getMappingBasePackage() {
		return "es.unileon.ulebankoffice.domain";
	}

}
