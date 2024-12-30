package com.co.franquicias.object;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Productos")
public class Productos {
	
	@Id
	private ObjectId _id;
	
	@Indexed(unique = true)
	private int productoId;
	private String productoName;
	private int productoStock;
	

	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public int getProductoId() {
		return productoId;
	}
	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}
	public String getProductoName() {
		return productoName;
	}
	public void setProductoName(String productoName) {
		this.productoName = productoName;
	}
	public int getProductoStock() {
		return productoStock;
	}
	public void setProductoStock(int productoStock) {
		this.productoStock = productoStock;
	}
	
	
	public Productos(int productoId, String productoName, int productoStock) {
		super();
		this.productoId = productoId;
		this.productoName = productoName;
		this.productoStock = productoStock;
	}
}
