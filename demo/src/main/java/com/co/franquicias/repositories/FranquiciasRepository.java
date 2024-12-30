package com.co.franquicias.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.co.franquicias.object.Franquicias;

public interface FranquiciasRepository extends MongoRepository<Franquicias, String>{

	@Query("{franquiciaId:'?0'}")
	Franquicias findFranquiciaById(int id);
}
