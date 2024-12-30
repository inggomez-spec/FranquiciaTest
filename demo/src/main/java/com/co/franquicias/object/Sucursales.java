package com.co.franquicias.object;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Sucursales")
public class Sucursales {

	@Id
	private ObjectId  _id;
	
	private String sucursalName;
	
    @DBRef
    private Collection<Productos> productos;
	@Indexed(unique = true)
	private int sucursalId;
    
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getSucursalName() {
		return sucursalName;
	}

	public void setSucursalName(String sucursalName) {
		this.sucursalName = sucursalName;
	}

	public Collection<Productos> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Productos> productos) {
		this.productos = productos;
	}

	public int getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(int sucursalId) {
		this.sucursalId = sucursalId;
	}

	public Sucursales(String sucursalName, Collection<Productos> productos, int sucursalId) {
		super();
		this.sucursalName = sucursalName;
		this.productos = productos;
		this.sucursalId = sucursalId;
	}


    
    
}
