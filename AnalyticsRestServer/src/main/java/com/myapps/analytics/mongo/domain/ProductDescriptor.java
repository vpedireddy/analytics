package com.myapps.analytics.mongo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*@Setter
@Getter*/
//@AllArgsConstructor
@Document(collection = "productdescriptor")
public class ProductDescriptor {

	private String corp;
	private String company;
	private String division;
	private String department;
	private String classId;
	private String departmentDescription;
	private String classDescription;
	private String productDescriptor;
	private String defaultDescriptorIndicator;

	
	public ProductDescriptor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDescriptor(String corp, String company, String division, String department, String classId,
			String departmentDescription, String classDescription, String productDescriptor,
			String defaultDescriptorIndicator) {
		super();
		this.corp = corp;
		this.company = company;
		this.division = division;
		this.department = department;
		this.classId = classId;
		this.departmentDescription = departmentDescription;
		this.classDescription = classDescription;
		this.productDescriptor = productDescriptor;
		this.defaultDescriptorIndicator = defaultDescriptorIndicator;
	}
	/**
	 * @return the corp
	 */
	public String getCorp() {
		return corp;
	}
	/**
	 * @param corp the corp to set
	 */
	public void setCorp(String corp) {
		this.corp = corp;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}
	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the classId
	 */
	public String getClassId() {
		return classId;
	}
	/**
	 * @param classId the classId to set
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}
	/**
	 * @return the departmentDescription
	 */
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	/**
	 * @param departmentDescription the departmentDescription to set
	 */
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	/**
	 * @return the classDescription
	 */
	public String getClassDescription() {
		return classDescription;
	}
	/**
	 * @param classDescription the classDescription to set
	 */
	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}
	/**
	 * @return the productDescriptor
	 */
	public String getProductDescriptor() {
		return productDescriptor;
	}
	/**
	 * @param productDescriptor the productDescriptor to set
	 */
	public void setProductDescriptor(String productDescriptor) {
		this.productDescriptor = productDescriptor;
	}
	/**
	 * @return the defaultDescriptorIndicator
	 */
	public String getDefaultDescriptorIndicator() {
		return defaultDescriptorIndicator;
	}
	/**
	 * @param defaultDescriptorIndicator the defaultDescriptorIndicator to set
	 */
	public void setDefaultDescriptorIndicator(String defaultDescriptorIndicator) {
		this.defaultDescriptorIndicator = defaultDescriptorIndicator;
	}
	
}