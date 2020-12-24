package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

/**** Controlador REST *****/

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired // Injecao de dependencia
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		// Category u = new Category(1L, "Maria", "maria@gmail.com", "999999", "12345");

		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}