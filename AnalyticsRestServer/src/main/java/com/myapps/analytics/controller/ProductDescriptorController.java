package com.myapps.analytics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapps.analytics.mongo.domain.ProductDescriptor;
import com.myapps.analytics.service.ProductDescriptorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/mongo/product")
public class ProductDescriptorController {

	private final ProductDescriptorService productDescriptorService;

	@Autowired
	public ProductDescriptorController(ProductDescriptorService productDescriptorService) {
		this.productDescriptorService = productDescriptorService;
	}

	@RequestMapping(value = "/productDescriptor", method = RequestMethod.GET)
	public List<ProductDescriptor> fetchProductDescriptors() {

		List<ProductDescriptor> productDescriptors = productDescriptorService.fetchProductDescriptors();
		return productDescriptors;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveProduct/{pid}")
	public ProductDescriptor saveProductDescriptor(@PathVariable("pd") ProductDescriptor prodDesc) {

		return productDescriptorService.saveProductDescriptor(prodDesc);

	}

}
