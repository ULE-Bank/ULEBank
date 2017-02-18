package es.unileon.ulebankoffice.domain;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

public class Datastore {
	
	private DatastoreService datastoreService;
	private static Datastore datastore;
	
	public static Datastore getDatastore() {
		if(datastore == null)
			datastore = new Datastore();
		
		return datastore;
	}
	
	private Datastore() {
		datastoreService  = DatastoreServiceFactory.getDatastoreService();
	}
	
	public void insertEntity(String kind, String[] properties, String[] propertiesValues) {
		Entity newEntity = new Entity(kind);
		
		for(int i=0; i<properties.length; i++)
			newEntity.setProperty(properties[i], propertiesValues[i]);
		
		datastoreService.put(newEntity);
	}
	
	public boolean queryForExists(String kind, String property, String propertyValue) {
		Filter propertyFilter =
		        new FilterPredicate(property, FilterOperator.EQUAL, propertyValue);
		
		Query q = new Query(kind).setFilter(propertyFilter);
		
		PreparedQuery pq = datastoreService.prepare(q);
		
		return pq.countEntities(FetchOptions.Builder.withDefaults()) != 0;
	}
	
	public List<Entity> query(String kind) {
		Query q = new Query(kind);
		
		return datastoreService.prepare(q).asList(FetchOptions.Builder.withDefaults());
	}
	
	public Entity query(String kind, String filterID) {
		Key filterKey = KeyFactory.createKey(kind, Long.valueOf(filterID));
		
		Filter filter =
		        new FilterPredicate(Entity.KEY_RESERVED_PROPERTY, FilterOperator.EQUAL, filterKey);
		
		Query q = new Query(kind).setFilter(filter);
		
		return datastoreService.prepare(q).asSingleEntity();
	}
	
	public List<Entity> query(String kind, String filterProperty, String filterPropertyValue) {
		Filter propertyFilter =
		        new FilterPredicate(filterProperty, FilterOperator.EQUAL, filterPropertyValue);
		
		Query q = new Query(kind).setFilter(propertyFilter);
		
		return datastoreService.prepare(q).asList(FetchOptions.Builder.withDefaults());
	}
	
	public void updateEntity(String kind, String id, String[] propertiesToUpdate, String[] values) 
			throws NumberFormatException, EntityNotFoundException {
		
		Entity entityToUpdate = datastoreService.get(KeyFactory.createKey(kind, Long.valueOf(id)));
		
		for(int i=0; i<propertiesToUpdate.length; i++)
			entityToUpdate.setProperty(propertiesToUpdate[i], values[i]);
		
		datastoreService.put(entityToUpdate);
	}

}
