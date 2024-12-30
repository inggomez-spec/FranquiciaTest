package com.co.franquicias.object;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Franquicias")
public class Franquicias {

	@Id
	private ObjectId  _id;
	
	private String franquiciaName;
	
	@Indexed(unique = true)
	private int franquiciaId;
	
    @DBRef
    private Collection<Sucursales> sucursales;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getFranquiciaName() {
		return franquiciaName;
	}

	public void setFranquiciaName(String franquiciaName) {
		this.franquiciaName = franquiciaName;
	}

	public Collection<Sucursales> getSucursales() {
		return sucursales;
	}

	public void setSucursales(Collection<Sucursales> sucursales) {
		this.sucursales = sucursales;
	}

	public int getFranquiciaId() {
		return franquiciaId;
	}

	public void setFranquiciaId(int franquiciaId) {
		this.franquiciaId = franquiciaId;
	}

	public Franquicias(String franquiciaName, int franquiciaId, Collection<Sucursales> sucursales) {
		super();
		this.franquiciaName = franquiciaName;
		this.franquiciaId = franquiciaId;
		this.sucursales = sucursales;
	}


	
}
