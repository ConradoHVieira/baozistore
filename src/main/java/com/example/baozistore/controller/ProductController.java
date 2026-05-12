package com.example.baozistore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.baozistore.model.Product;
import com.example.baozistore.repository.ProductRepository;


@RestController
@RequestMapping({"/product"})
public class ProductController {

	private ProductRepository repository;

	ProductController(ProductRepository productRepository){
		this.repository = productRepository;
	}

	@GetMapping
	public List<Product> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Product create(@RequestBody Product product) {
		return repository.save(product);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Product product) {
		return repository.findById(id).map(record -> {
			record.setName(product.getName());
			record.setPrice(product.getPrice());
			record.setStock(product.getStock());
			Product updated = repository.save(record);
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
