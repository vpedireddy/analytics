package com.myapps.analytics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapps.analytics.mongo.data.ProductDescriptorRepository;
import com.myapps.analytics.mongo.domain.ProductDescriptor;
import com.myapps.analytics.service.ProductDescriptorService;

@Service
public class ProductDescriptorServiceImpl implements ProductDescriptorService {

	private ProductDescriptorRepository productDescriptorRepository;

	@Autowired
	public void ProductDescriptorService(ProductDescriptorRepository productDescriptorRepository) {
		this.productDescriptorRepository = productDescriptorRepository;
	}

	@Override
	public List<ProductDescriptor> fetchProductDescriptors() {
		return productDescriptorRepository.getProductDescriptors();
	}

	@Override
	public ProductDescriptor fetchProductDescriptor(String departmentId, String classId) {
		return productDescriptorRepository.getProductDescriptor(departmentId, classId);
	}

	@Override
	public ProductDescriptor saveProductDescriptor(ProductDescriptor pd) {
		return productDescriptorRepository.saveProduct(pd);
	}
}
