package com.inmueble.inmueblesweb.model;

import com.inmueble.inmueblesweb.model.data.DBConnector;
import com.inmueble.inmueblesweb.model.data.dao.inmuebleDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;

public class Inmueble {
	private String construccion;
	private int precio;
	private UbicacionGeografica ubicacionGeografica;

	public Inmueble(String construccion, int precio, UbicacionGeografica ubicacionGeografica) {
		throw new UnsupportedOperationException();
	}

	public String getConstruccion() {
		return this.construccion;
	}

	public void setConstruccion(String construccion) {
		this.construccion = construccion;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean agregarInmueble() {
		Connection connection= DBConnector.connection("inmueble","root","");
		DSLContext query= DSL.using(connection);
		return new inmuebleDAO().agregarInmueble(this,query);
	}

	public UbicacionGeografica getUbicacionGeografica() {
		return ubicacionGeografica;
	}

	public ArrayList<Inmueble> buscarInmueble() {
		Connection connection= DBConnector.connection("inmueble","root","");
		DSLContext query= DSL.using(connection);
		return new inmuebleDAO().buscarInmueble(this,query);
	}
}