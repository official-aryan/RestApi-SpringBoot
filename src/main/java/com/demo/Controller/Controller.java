package com.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.Form;
import com.demo.Entity.FormDTO;
import com.demo.ExceptionHandling.EmptyResultDataAccessException;
import com.demo.Repository.FormRepository;
import com.demo.SaveFormDto.PostFormdto;
import com.demo.SaveFormDto.SaveFormDto;
import com.demo.SaveFormDto.UpdateFormDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/getData")
public class Controller 

{
	@Autowired
	FormRepository fr;
	
	@GetMapping
	public ResponseEntity<?> getData()
	{
		List<Form> getResult = fr.findAll();
		SaveFormDto dto = new SaveFormDto();
		dto.setGetResult(getResult);
		dto.setMessage("The record is viewed!!");
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
		//  http://localhost:8080/api/getData
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteData(@PathVariable int id)
	{
		Optional<Form> form = fr.findById(id);
		
		if(form.isPresent()) {
			fr.deleteById(id);
			
		}
		else {
			
			throw new EmptyResultDataAccessException("The record is not present in this id "+id);
		}
		
		return new ResponseEntity<>("data is deleted",HttpStatus.OK);
		
	//  http://localhost:8080/api/getData/2
		
	}
	@PostMapping
	public ResponseEntity<?> postData(@RequestBody Form f )
	{
		
		Form res = fr.save(f);
		PostFormdto dto =new PostFormdto();
		dto.setRes(res);
		dto.setMessage("data is posted");
		
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<?> putData(@RequestParam("id") int id , @RequestBody FormDTO dto)
	{
		Form upateform=fr.findById(id).get();
		upateform.setId(dto.getId());
		upateform.setUsername(dto.getUsername());
		upateform.setPaswword(dto.getPaswword());
		
		Form save = fr.save(upateform);
		UpdateFormDto dto_update = new  UpdateFormDto();
		dto_update.setSave(save);
		dto_update.setMessage("data is updated");
		return new ResponseEntity<>(dto_update,HttpStatus.OK);
		// http://localhost:8080/api/getData?id=2
	}
}
