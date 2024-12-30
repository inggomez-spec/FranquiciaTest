package com.co.franquicias.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.co.franquicias.object.Productos;


public interface ProductosRepository  extends MongoRepository<Productos, String> {

	@Query("{productoId:'?0'}")
	Productos findProductoById(int id);
	
}
