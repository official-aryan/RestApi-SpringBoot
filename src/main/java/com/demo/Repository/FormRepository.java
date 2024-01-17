package com.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Entity.Form;

public interface FormRepository extends JpaRepository<Form, Integer>

{
	
	
}
