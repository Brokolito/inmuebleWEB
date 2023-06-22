package com.inmueble.inmueblesweb.model;

import com.inmueble.inmueblesweb.model.data.DBConnector;
import com.inmueble.inmueblesweb.model.data.dao.vendedorDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;

public class Vendedor {
	private String rut;
	private String estadoCivil;
	private String nombre;
	private String direccion;
	private String tituloProfesional;

	public Vendedor(String rut, String estadoCivil, String direccion, String tituloProfesional) {
		throw new UnsupportedOperationException();
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTituloProfesional() {
		return this.tituloProfesional;
	}

	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}

	public boolean agregarVendedor() {
		Connection connection= DBConnector.connection("inmueble","root","");
		DSLContext query= DSL.using(connection);
		return new vendedorDAO().agregarVendedor(this,query);
	}
}