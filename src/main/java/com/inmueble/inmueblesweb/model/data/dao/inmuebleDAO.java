package com.inmueble.inmueblesweb.model.data.dao;

import com.inmueble.inmueblesweb.model.UbicacionGeografica;
import com.inmueble.inmueblesweb.model.Inmueble;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.ArrayList;

public class inmuebleDAO {

	public boolean agregarInmueble(Inmueble inmueble, DSLContext query) {
		String construccion=inmueble.getConstruccion();
		String ubicacionGeografica=inmueble.getUbicacionGeografica().getDireccion()+"-"+inmueble.getUbicacionGeografica().getCiudad();
		int precio=inmueble.getPrecio();
		int result=query.insertInto(DSL.table("inmueble"),
				DSL.field("construccion"),DSL.field("precio"),DSL.field("direccion")).
				values(construccion,precio,ubicacionGeografica).execute();
		return result==1;
	}

	public ArrayList<Inmueble> buscarInmueble(Inmueble inmueble, DSLContext query) {
		String ubicacionGeografica=inmueble.getUbicacionGeografica().getDireccion()+"-"+inmueble.getUbicacionGeografica().getCiudad();
		Result <Record> result=query.select().from(DSL.table("inmueble")).where(
				DSL.field("direccion").eq(ubicacionGeografica)).fetch();
		ArrayList <Inmueble> inmuebles=new ArrayList<>();
		for (int i = 0; i < result.size(); i++) {
			String [] data= result.getValue(i,"direccion").toString().split("-");

			UbicacionGeografica ubicacionGeografica1=new UbicacionGeografica(data[0],data[1]);
			inmuebles.add(new Inmueble(
					result.getValue(i,"construccion").toString(),
					Integer.parseInt(result.getValue(i,"precio").toString()),
					ubicacionGeografica1
			));
		}
		return inmuebles;
	}

}