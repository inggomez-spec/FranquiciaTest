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
import com.co.franquicias.service.ProductosService;

@RestController
@RequestMapping("api/productos")
public class ProductosController {

	@Autowired
    private ProductosService productosService;
	
    @GetMapping("/getAll")
    public List<Productos> getAllProductos() {
        return productosService.findAll();
    }
    
	@PostMapping("/crearProducto")
	public ResponseEntity<Productos> insertProducto(@RequestBody Productos producto) {
		Productos rta = productosService.insertProducto(producto);

		return ResponseEntity.ok(rta);
	}
	
	@PutMapping("/updateStock")
	public ResponseEntity<Productos> updateStock(@RequestBody int productoId, int stock) {

		Productos rta=productosService.updateStock( productoId,  stock);
		return ResponseEntity.ok(rta);
	}
	
	@PutMapping("/cambiarNombreProducto")
	public ResponseEntity<Productos> cambiarNombreProducto(@RequestBody int idProducto, String nuevoNombre) {
		
		Productos rta = productosService.updateName(idProducto, nuevoNombre);
		return ResponseEntity.ok(rta);
	}
}
