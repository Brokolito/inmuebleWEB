package com.inmueble.inmueblesweb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "agregarVendedorServlet",value = "/agregarVendedor")
public class agregarVendedorServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String rut=(
				(!request.getParameter("rut").toString().isEmpty() &&
						request.getParameter("rut").toString().length()<=12)
						?request.getParameter("rut").toString():"0");
		String nombre=request.getParameter("nombre").toString();
		String estadoCivil=request.getParameter("estadoCivil").toString();
		String direccion=request.getParameter("direccion").toString();
		String tituloProfesional= request.getParameter("tituloProfesional").toString();
	}
}