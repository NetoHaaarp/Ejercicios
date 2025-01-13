package com.ammfec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;
import com.ammfec.service.EjeciciosService;

@RestController
@RequestMapping("/tarea")
public class EjerciciosController {
	
	@Autowired
	private EjeciciosService service;
	
	@PostMapping(value = "/permutaciones", produces={MediaType.APPLICATION_JSON_VALUE})
	public List<String> permutaciones(@RequestBody String[] data) {
		return service.permutaciones(data);
	}
	
	@PostMapping(value = "/matriz", produces={MediaType.APPLICATION_JSON_VALUE})
	public String[] matriz(@RequestBody String[][] data) {
		return service.matriz(data);
	}

	@PostMapping(value = "/sodocu", produces={MediaType.APPLICATION_JSON_VALUE})
	public String sodocu(@RequestBody Integer[][] data) {
		return service.sodocu(data);
	}

}
