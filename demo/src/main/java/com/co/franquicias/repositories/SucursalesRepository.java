package com.co.franquicias.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.co.franquicias.object.Sucursales;

public interface SucursalesRepository extends MongoRepository<Sucursales, String>{

	@Query("{sucursalId:'?0'}")
	Sucursales findSucursalById(int id);
}
