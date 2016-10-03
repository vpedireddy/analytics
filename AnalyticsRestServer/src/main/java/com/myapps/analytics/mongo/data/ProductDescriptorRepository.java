package com.myapps.analytics.mongo.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.myapps.analytics.mongo.domain.ProductDescriptor;

@Repository
public class ProductDescriptorRepository {

    @Autowired
    private MongoOperations mongoOperations;

    public static final String DEPARTMENT_ID = "department";

    private static final String CLASS_ID = "classId";
    
    private static final String DEFAULT_INDICATOR="defaultDescriptorIndicator";

    public List<ProductDescriptor> getProductDescriptors(){
    	
    	return mongoOperations.findAll(ProductDescriptor.class);
        
    }

    public ProductDescriptor getProductDescriptor(String departmentId, String classId) {
        Query query = new Query();
        query.addCriteria(Criteria.where(DEPARTMENT_ID).is(departmentId));
        query.addCriteria(Criteria.where(CLASS_ID).is(classId));
        query.addCriteria(Criteria.where(DEFAULT_INDICATOR).is("Y"));
        return mongoOperations.findOne(query, ProductDescriptor.class);
    }
    
    public ProductDescriptor saveProduct(ProductDescriptor pd){
    	
    	mongoOperations.save(pd);
    	return pd;
    }

}
