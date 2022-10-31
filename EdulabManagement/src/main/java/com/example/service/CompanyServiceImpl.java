package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.CustomException;
import com.example.entity.Company;
import com.example.repository.CompanyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public Company addCompany(Company company) {
		try {

			log.info("company {}", company);

			return company;

		} catch (Exception e) {

			log.error(e.getMessage());
			throw new CustomException(500, e.getMessage());
		}
	}

	@Override
	public List<Company> getAllCompany() {
		try {
			return (List<Company>) companyRepository.findAll();

		} catch (Exception e) {

			log.error(e.getMessage());
			throw new CustomException(500, e.getMessage());

		}
	}

	@Override
	public void updateCompany(Company company, int companyId) {
		try {

		} catch (Exception e) {

			log.error(e.getMessage());
			throw new CustomException(500, e.getMessage());

		}

	}

	@Override
	public void deleteCompany(int companyId) {
		try {

		} catch (Exception e) {

			log.error(e.getMessage());
			throw new CustomException(500, e.getMessage());

		}

	}

}
