package com.packt.schooldatabase.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BusRepository extends CrudRepository <Bus, Long> {
	// Fetch cars by brand and sort by year
	List<Car> findByBrandOrderByYearAsc(String brand);
}
