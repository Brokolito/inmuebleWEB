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
import java.util.ArrayList;

@WebServlet(name = "buscarInmuebleServlet",value ="/buscarInmueble")
public class buscarInmuebleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ciudad=request.getParameter("ciudad").toString();
		String direccion=request.getParameter("direccion").toString();
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/buscarInmueble.jsp");
		if(!ciudad.isEmpty() && !direccion.isEmpty()){
			Inmueble inmueble=new Inmueble("",0,new UbicacionGeografica(
					ciudad,direccion
			));
			ArrayList<Inmueble> inmuebles=inmueble.buscarInmueble();
			if(inmuebles.size()!=0){
				request.setAttribute("inmuebles",inmuebles);
			}
		}
		requestDispatcher.forward(request,response);
	}
}