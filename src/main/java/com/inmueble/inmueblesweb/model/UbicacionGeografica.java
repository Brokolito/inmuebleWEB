package com.inmueble.inmueblesweb.model;

public class UbicacionGeografica {
	private String ciudad;
	private String direccion;

	public UbicacionGeografica(String ciudad, String direccion) {
		this.ciudad=ciudad;
		this.direccion=direccion;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}