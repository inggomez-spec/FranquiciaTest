package com.co.franquicias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.franquicias.object.Productos;
import com.co.franquicias.object.Sucursales;
import com.co.franquicias.repositories.SucursalesRepository;

@Service
public class SucursalesService {

	@Autowired
	SucursalesRepository sucursalRepo;
	
	 public  List<Sucursales> findAll(){
	        return sucursalRepo.findAll();
	      }
	 
	 public  Sucursales findbyId(int id){
	        return sucursalRepo.findSucursalById(id);
	      }
	    public Sucursales insertSucursal(Sucursales franquicia) {
		      return sucursalRepo.insert(franquicia);
		}
	    
	    public Sucursales agregarProducto(Productos producto, Sucursales sucursal) {
			 //revisa si ya esta agregado el producto 
		     boolean existe=false;
		    
		     if(sucursal.getProductos().contains(producto)) {
					existe=true;
				}
		  
			 if(!existe) {
				 sucursal.getProductos().add(producto);			 
				 Sucursales itemsUpdated = sucursalRepo.save(sucursal);
				 if(itemsUpdated != null)
					 return itemsUpdated;
			 }else {return null;}
			 	return null;	 
			 	 
		 }
	    
	    public Sucursales eliminarProducto(Productos producto, Sucursales sucursal) {
			 //revisa si ya esta agregado el producto 
		     boolean existe=false;
		    
		     if(sucursal.getProductos().contains(producto)) {
					existe=true;
				}
		  
			 if(existe) {
				 sucursal.getProductos().remove(producto);			 
				 Sucursales itemsUpdated = sucursalRepo.save(sucursal);
				 if(itemsUpdated != null)
					 return itemsUpdated;
			 }else {return null;}
			 	return null;	 
			 	 
		 }
	    
	    public Sucursales updateName(int id, String nombre) {
	    	Sucursales suc = sucursalRepo.findSucursalById(id);
    	//Se revisa primero si existe la franquicia
    	if(suc!=null) {
    		suc.setSucursalName(nombre);
    		Sucursales nameUpdate = sucursalRepo.save(suc);
    		return nameUpdate;
    	}else {
    		return null;
    	}
    }
}
