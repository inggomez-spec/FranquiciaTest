package com.co.franquicias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.franquicias.object.Franquicias;
import com.co.franquicias.object.Sucursales;
import com.co.franquicias.repositories.FranquiciasRepository;

@Service
public class FranquiciasService {

	@Autowired
	FranquiciasRepository franquiciaRepo;
	
	 public  List<Franquicias> findAll(){
	        return franquiciaRepo.findAll();
	        		
	 }
	 
	 public  Franquicias findbyId(int id){
	        return franquiciaRepo.findFranquiciaById(id);
	        		
	 }
    public Franquicias insertFranquicia(Franquicias franquicia) {
	      return franquiciaRepo.insert(franquicia);
	}
    
    public Franquicias updateSucursales(Franquicias franquisia, Sucursales sucursal) {
		 //revisa si ya esta agregada primero
	     boolean existe=false;
	    
	     if(franquisia.getSucursales().contains(sucursal)) {
				existe=true;
			}
	  
		 if(!existe) {
			 franquisia.getSucursales().add(sucursal);			 
			 Franquicias itemsUpdated = franquiciaRepo.save(franquisia);
			 if(itemsUpdated != null)
				 return itemsUpdated;
		 }else {return null;}
		 	return null;	 
		 	 
	 }
    
    public Franquicias updateName(int id, String nombre) {
    	Franquicias franq = franquiciaRepo.findFranquiciaById(id);
    	//Se revisa primero si existe la franquicia
    	if(franq!=null) {
    		franq.setFranquiciaName(nombre);
    		Franquicias nameUpdate = franquiciaRepo.save(franq);
    		return nameUpdate;
    	}else {
    		return null;
    	}
    }
}
