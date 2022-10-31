package com.example.service;

import java.util.List;

import com.example.entity.Company;

public interface CompanyService {

	Company addCompany(Company company);

	List<Company> getAllCompany();

	void updateCompany(Company company, int companyId);

	void deleteCompany(int companyId);

}
