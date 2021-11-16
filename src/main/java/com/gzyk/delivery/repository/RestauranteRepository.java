package com.gzyk.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gzyk.delivery.entity.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
	
}
