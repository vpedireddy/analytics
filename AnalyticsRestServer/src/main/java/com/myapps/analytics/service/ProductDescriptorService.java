package com.myapps.analytics.service;

import java.util.List;

import com.myapps.analytics.mongo.domain.ProductDescriptor;

public interface ProductDescriptorService {

	public List<ProductDescriptor> fetchProductDescriptors();

	public ProductDescriptor fetchProductDescriptor(String departmentId, String classId);

	public ProductDescriptor saveProductDescriptor(ProductDescriptor pd);
}
