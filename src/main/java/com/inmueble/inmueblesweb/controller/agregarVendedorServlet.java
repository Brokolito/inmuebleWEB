package com.inmueble.inmueblesweb.controller;

import com.inmueble.inmueblesweb.model.Vendedor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "agregarVendedorServlet",value = "/agregarVendedor")
public class agregarVendedorServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("a");
		String rut=(
				(!request.getParameter("rut").toString().isEmpty() &&
						request.getParameter("rut").toString().length()<=12)
						?request.getParameter("rut").toString():"0");
		String nombre=request.getParameter("nombre").toString();
		String estadoCivil=request.getParameter("estadoCivil").toString();
		String direccion=request.getParameter("direccion").toString();
		String tituloProfesional= request.getParameter("tituloProfesional").toString();
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/agregarInmueble.jsp");
		if(!rut.isEmpty() && !nombre.isEmpty() && !estadoCivil.isEmpty() && !direccion.isEmpty() && !tituloProfesional.isEmpty()){
			Vendedor vendedor=new Vendedor(rut,nombre,estadoCivil,direccion,tituloProfesional);
			if(vendedor.agregarVendedor()){
				request.setAttribute("status","Se ha registrado correctamente");
			}else{
				request.setAttribute("status","Rut ya registrado!");
			}

		}else{
			request.setAttribute("status","Rellene los campos, no sea pillo!");
		}

	}
}