package com.gzyk.delivery.maper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gzyk.delivery.dto.RestauranteResumoDTO;
import com.gzyk.delivery.entity.Restaurante;

@Component
public class RestauranteResumoOutputMapper {
	public RestauranteResumoDTO mapearDTO(Restaurante restaurante) {
		RestauranteResumoDTO restauranteResumoDTO = new RestauranteResumoDTO();
		restauranteResumoDTO.setId(restaurante.getId());
		restauranteResumoDTO.setNome(restaurante.getNome());
		return restauranteResumoDTO;
	}
	
	public List<RestauranteResumoDTO> mapearLista(List<Restaurante> restaurantes){
		return restaurantes.stream()
				.map(restaurante -> mapearDTO(restaurante))
				.collect(Collectors.toList());
	}
}
