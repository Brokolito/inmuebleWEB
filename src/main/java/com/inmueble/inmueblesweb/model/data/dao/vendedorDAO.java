package com.inmueble.inmueblesweb.model.data.dao;

import com.inmueble.inmueblesweb.model.Vendedor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public class vendedorDAO {

	public boolean agregarVendedor(Vendedor vendedor, DSLContext query) {
		String rut=vendedor.getRut();
		String nombre=vendedor.getNombre();
		String estadoCivil=vendedor.getEstadoCivil();
		String direccion=vendedor.getDireccion();
		String tituloProfesional=vendedor.getTituloProfesional();
		int result=0;
		try {
			result=query.insertInto(DSL.table("vendedor"),
					DSL.field("rut"),DSL.field("nombre"),DSL.field("estado_civil"),DSL.field("direccion"),DSL.field("titulo_profesional"))
					.values(rut,nombre,estadoCivil,direccion,tituloProfesional).execute();
		}catch (Exception e){
			e.printStackTrace();
		}
		return result==1;
	}
}