package com.co.franquicias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.franquicias.object.Productos;
import com.co.franquicias.repositories.ProductosRepository;

@Service
public class ProductosService {

	@Autowired
	ProductosRepository producotsRepo;
	
	
	 public  List<Productos> findAll(){
	        return producotsRepo.findAll();
	    }
	 public  Productos findbyId(int id){
	        return producotsRepo.findProductoById(id);
	      }
	 
	    public Productos insertProducto(Productos franquicia) {
		      return producotsRepo.insert(franquicia);
		}
	    
	    public Productos updateStock(int productoId, int stock) {
	    	 Productos prod=  producotsRepo.findProductoById(productoId);
	    	 prod.setProductoStock(stock);
		      return producotsRepo.save(prod);
		}
	    
	    public Productos updateName(int productoId, String name) {
	    	 Productos prod=  producotsRepo.findProductoById(productoId);
	    	 prod.setProductoName(name);
		      return producotsRepo.save(prod);
		}
}
