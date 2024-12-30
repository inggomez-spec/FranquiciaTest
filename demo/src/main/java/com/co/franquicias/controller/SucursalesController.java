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

import com.co.franquicias.object.Productos;
import com.co.franquicias.object.Sucursales;
import com.co.franquicias.service.ProductosService;
import com.co.franquicias.service.SucursalesService;

@RestController
@RequestMapping("api/sucursales")
public class SucursalesController {

	@Autowired
    private SucursalesService sucursalesService;
	@Autowired
    private ProductosService productosService;
	
	  @GetMapping("/getAll")
	    public List<Sucursales> getAllSucursales() {
	        return sucursalesService.findAll();
	        }
	  
		@PostMapping("/crearSucursal")
		public ResponseEntity<Sucursales> insertSucursal(@RequestBody Sucursales sucursal) {
			Sucursales rta = sucursalesService.insertSucursal(sucursal);

			return ResponseEntity.ok(rta);
		}
		
		@PostMapping("/agregarProducto")
		public ResponseEntity<Sucursales> agregarProducto(@RequestBody int idSucursal, int idProducto){
			Sucursales sucursal = sucursalesService.findbyId(idSucursal);
			Productos producto = productosService.findbyId(idProducto);
			if(producto!=null && sucursal!=null) {
				Sucursales rta= sucursalesService.agregarProducto(producto, sucursal);
				return ResponseEntity.ok(rta);
			}else {
				return null;
			}
		}
		
		@PostMapping("/eliminarProducto")
		public ResponseEntity<Sucursales> eliminarProducto(@RequestBody int idSucursal, int idProducto){
			Sucursales sucursal = sucursalesService.findbyId(idSucursal);
			Productos producto = productosService.findbyId(idProducto);
			if(producto!=null && sucursal!=null) {
				Sucursales rta= sucursalesService.agregarProducto(producto, sucursal);
				return ResponseEntity.ok(rta);
			}else {
				return null;
			}
		}
		
		@PutMapping("/cambiarNombreFranquicia")
		public ResponseEntity<Sucursales> cambiarNombreSucursal(@RequestBody int idSucursal, String nuevoNombre) {
			
			Sucursales rta = sucursalesService.updateName(idSucursal, nuevoNombre);
			return ResponseEntity.ok(rta);
		}
}
