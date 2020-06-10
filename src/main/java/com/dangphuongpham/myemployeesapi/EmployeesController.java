package com.dangphuongpham.myemployeesapi;

import java.util.List;
import java.util.Optional;
import com.dangphuongpham.myemployeesapi.employees;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://127.0.0.1")

public class EmployeesController {
	
	@Autowired EmployeesRepository empRepo;
	
	
	@CrossOrigin(origins = "http://127.0.0.1")
	@GetMapping("/list")  
	public List<employees> emplist() {
		
		return empRepo.findAll();
	}
	
	@CrossOrigin(origins = "http://127.0.0.1")
	@PostMapping(value = "/add")	
	public String addpost(@RequestBody @Valid employees emp)  {
		
		try {
			empRepo.save(emp);
		}
		catch (Exception e) { System.out.println (e); return "Error. No employee added";}
		
		return "New user added";
	}
	
	
	@PutMapping ("/edit/{id}")
	public String editget (@PathVariable("id") String idedit ,@RequestBody employees emp) {
	
		Optional <employees> e = empRepo.findById(idedit);
		if (!e.isPresent()) return "Id not found! Cab't update!";
		emp.setId(idedit);
		empRepo.save(emp);
				  		
	return "Update Successful";	
	}
	
		
	@DeleteMapping("/deleteemp/{id}")
	public String delepost(@PathVariable("id") String iddelete) {
		
		Optional <employees> e = empRepo.findById(iddelete);
		if (!e.isPresent()) return "Id not found! Cab't delete!";
		empRepo.deleteById(iddelete);
	
		return "Deleted";
	}	
	
	@GetMapping ("/list/{id}")
	
	public ResponseEntity<employees> editget (@PathVariable("id") String idedit) {
		
		employees e = new employees();		
		
		try {
			e = empRepo.findById(idedit).get();	
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}		
		catch (Exception err) {			
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e);
		}
		
	}
	
	@GetMapping ("/listid")
	
	public ResponseEntity<employees> editget2 (@RequestParam("idinput") String idedit) {
		
		employees e = new employees();		
		
		try {
			e = empRepo.findById(idedit).get();	
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}		
		catch (Exception err) {			
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e);
		}
		
	}
	
}
