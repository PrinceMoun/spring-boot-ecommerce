package com.prince.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.prince.ecommerce.entity.Product;
import com.prince.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		entityManager = theEntityManager;	
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		HttpMethod[] theUnSupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
		
		// disable HTTP method for Product : PUT, POST and delete
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metadata, httpmethods) -> httpmethods.disable(theUnSupportedActions))
			.withCollectionExposure((metadata, httpmethods)-> httpmethods.disable(theUnSupportedActions));
		
		
		// disable HTTP method for ProductCategory : PUT, POST and delete
				config.getExposureConfiguration()
					.forDomainType(ProductCategory.class)
					.withItemExposure((metadata, httpmethods) -> httpmethods.disable(theUnSupportedActions))
					.withCollectionExposure((metadata, httpmethods)-> httpmethods.disable(theUnSupportedActions));
				
		exposeIds(config);
	 }

	private void exposeIds(RepositoryRestConfiguration config) {
		
		// expose entity ids
		//
		
		// - get a list of all entity classes from the entity manager
		
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		// - create an array of the entity types
		
		List<Class> entityClasses = new ArrayList<>();
		
		// - get the entity types for the entities
		for(EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}
		
		// -expose the entity type ids for the array of entity/domain types
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
		
		
		
		
		
		
	}
	

}
