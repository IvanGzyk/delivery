package com.gzyk.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gzyk.delivery.dto.RestauranteResumoDTO;
import com.gzyk.delivery.entity.Restaurante;
import com.gzyk.delivery.maper.RestauranteResumoOutputMapper;
import com.gzyk.delivery.service.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private RestauranteResumoOutputMapper restauranteResumoOutputMapper;
	
	@GetMapping
	@ResponseBody
	public List<RestauranteResumoDTO> listarTodosOsRestaurantes() {
		List<Restaurante> restaurantes = restauranteService.listarTodosOsRestaurantes();
		List<RestauranteResumoDTO> restauranteResumoDTOs = restauranteResumoOutputMapper.mapearLista(restaurantes);
		return restauranteResumoDTOs;
		
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Restaurante getRestauranteById(@PathVariable Long id) {
		
		return restauranteService.getRestauranteById(id);
		
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	private Restaurante adicionar(@RequestBody Restaurante restaurante) {
		
		return restauranteService.salvar(restaurante);
		
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	private Restaurante Alterar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
		
		
		return restauranteService.alterar(id, restaurante);
		
	}

	/** Desafio 1: criar um patch mapping para ajustes pontuais no restaurante **/
	
	@PatchMapping("/{id}")
	@ResponseBody
	private Restaurante ajustar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
		
		
		return restauranteService.alterar(id, restaurante);
		
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Restaurante> deletar(@PathVariable Long id) {
		if (restauranteService.excluir(id)) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
}
