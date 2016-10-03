package com.myapps.analytics.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.myapps.analytics.controller.ProductDescriptorController;
import com.myapps.analytics.mongo.domain.ProductDescriptor;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductDescriptorControllerTest {

	@Value("${local.server.port}")
	private int port;

	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	@Autowired
	private ProductDescriptorController productDescriptorController;

	@Before
	public void setup() {

	}

	@Test
	public void saveProductDescriptor() {
		ProductDescriptor prodDesc = getProductDescriptor();
		productDescriptorController.saveProductDescriptor(prodDesc);
	}

	private ProductDescriptor getProductDescriptor() {
		String corp="1";
	    String company = "1";
	    String division="36";
	    String department="360";
	    String classId="00";
	    String departmentDescription="somedept";
	    String classDescription="defaultClass";
	    String productDescriptor="defaultProductDescriptor";
	    String defaultDescriptorIndicator="Y";
	    
	    return new ProductDescriptor(corp, company, division, department,classId,departmentDescription,classDescription,productDescriptor,defaultDescriptorIndicator );
	}

}
