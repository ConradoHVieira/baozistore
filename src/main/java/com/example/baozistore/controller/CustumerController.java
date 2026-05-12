package com.example.baozistore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.baozistore.model.Custumer;
import com.example.baozistore.repository.CustumerRepository;

import java.util.List;



@RestController
@RequestMapping({"/custumer"})
public class CustumerController {
	private CustumerRepository repository;
	
	CustumerController(CustumerRepository custumerRepository){
		this.repository = custumerRepository;
	}

@GetMapping
public List<Custumer> findAll() {
	return repository.findAll();
}

@GetMapping(path = { "/{id}" })
public ResponseEntity<?> findById(@PathVariable long id) {
	return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
			.orElse(ResponseEntity.notFound().build());
}

@PostMapping
public Custumer create(@RequestBody Custumer custumer) {
	return repository.save(custumer);
}

@PutMapping(value = "/{id}")
public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Custumer custumer) {
	return repository.findById(id).map(record -> {
		record.setName(custumer.getName());
		Custumer updated = repository.save(record);
		return ResponseEntity.ok().body(updated);
	}).orElse(ResponseEntity.notFound().build());
}

@DeleteMapping(path = { "/{id}" })
public ResponseEntity<?> delete(@PathVariable long id) {
	return repository.findById(id).map(record -> {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}).orElse(ResponseEntity.notFound().build());
}

}
