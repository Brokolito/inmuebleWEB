package com.inmueble.inmueblesweb.model;

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
		throw new UnsupportedOperationException();
	}

	public UbicacionGeografica getUbicacionGeografica() {
		return ubicacionGeografica;
	}

	public ArrayList<Inmueble> buscarInmueble() {
		throw new UnsupportedOperationException();
	}
}