package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

}
