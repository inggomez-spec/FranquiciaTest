package com.co.franquicias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.franquicias.object.Franquicias;
import com.co.franquicias.object.Sucursales;
import com.co.franquicias.service.FranquiciasService;
import com.co.franquicias.service.SucursalesService;

@RestController
@RequestMapping("/franquicias")
public class FranquiciasController {

	@Autowired
	private FranquiciasService franquiciasService;
	@Autowired
    private SucursalesService sucursalesService;

	@GetMapping("/getAll")
	public List<Franquicias> getAllFranquicias() {
		return franquiciasService.findAll();

	}

	@PostMapping("/crearFranquicia")
	public ResponseEntity<Franquicias> insertFranquicia(@RequestBody Franquicias franquicia) {
		Franquicias rta = franquiciasService.insertFranquicia(franquicia);

		return ResponseEntity.ok(rta);
	}
	
	@PostMapping("/agregarSucursal")
	public ResponseEntity<Franquicias> agregarSucursalFranquicia(@RequestBody int idSucursal, int idFranquicia) {
		//Revisa si existen la sucursal y la franquicia
		Franquicias franquisia = franquiciasService.findbyId(idFranquicia);
		Sucursales sucursal= sucursalesService.findbyId(idSucursal);
		if(franquisia!=null && sucursal!=null) {
			Franquicias rta= franquiciasService.updateSucursales(franquisia, sucursal);
			return ResponseEntity.ok(rta);
		}else {
			return null;
		}
	}
	
	@PutMapping("/cambiarNombreFranquicia")
	public ResponseEntity<Franquicias> cambiarNombreFranquicia(@RequestBody int idSucursal, String nuevoNombre) {
		
		Franquicias rta = franquiciasService.updateName(idSucursal, nuevoNombre);
		return ResponseEntity.ok(rta);
	}
}
