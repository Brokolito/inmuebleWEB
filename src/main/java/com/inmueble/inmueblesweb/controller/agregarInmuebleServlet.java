package com.inmueble.inmueblesweb.controller;

import com.inmueble.inmueblesweb.model.Inmueble;
import com.inmueble.inmueblesweb.model.UbicacionGeografica;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "agregarInmuebleServlet",value = "/agregarInmueble")
public class agregarInmuebleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException();
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String construccion=request.getAttribute("tipoConstruccion").toString();
		int precio=Integer.parseInt(
				(!request.getParameter("precio").toString().isEmpty()
						&& !request.getParameter("precio").toString().matches("[0-9]+"))
						?"0":request.getParameter("precio").toString()
		);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/agregarInmueble.jsp");
		String direccion=request.getParameter("direccion").toString();
		String ciudad=request.getParameter("ciudad").toString();
		if(!construccion.isEmpty() && precio!=0 && !ciudad.isEmpty() && !direccion.isEmpty()){
			Inmueble inmueble=new Inmueble(construccion,precio,new UbicacionGeografica(ciudad,direccion));
			if(inmueble.agregarInmueble()){
				request.setAttribute("status","Se ha agregado correctamente!");
			}else{
				request.setAttribute("status","Ha ocudrrido un error!");

			}
		}else{
			request.setAttribute("status","Rellene los campos, no sea pillo!");
		}
		requestDispatcher.forward(request,response);
	}
}