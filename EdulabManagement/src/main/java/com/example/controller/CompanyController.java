package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Company;
import com.example.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/company", method = RequestMethod.POST)
	public ResponseEntity<Company> addCompany(@RequestBody Company company) {
		Company c = null;
		try {
			c = this.companyService.addCompany(company);
			System.out.println(company);
			return ResponseEntity.of(Optional.of(c));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/getcompany", method = RequestMethod.GET)
	public ResponseEntity<List<Company>> getCompany() {

		List<Company> list = companyService.getAllCompany();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@RequestMapping(value = "/company/{companyId}", method = RequestMethod.PUT)
	public ResponseEntity<Company> updateCompany(@RequestBody Company company,
			@PathVariable("companyId") int companyId) {
		try {
			this.companyService.updateCompany(company, companyId);
			return ResponseEntity.ok().body(company);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/company/{companyId}", method = RequestMethod.DELETE)
	public ResponseEntity<Company> deleteCompany(@PathVariable("companyId") int companyId) {
		try {
			this.companyService.deleteCompany(companyId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}