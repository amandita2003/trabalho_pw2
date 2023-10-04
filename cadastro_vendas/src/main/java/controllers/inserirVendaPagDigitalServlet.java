package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.VendaPagDigitalDAO;
import modelo.VendaPagDigital;


@WebServlet("/inserirVendaPagDigitalServlet")
public class inserirVendaPagDigitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String item = request.getParameter("item");
		String valorTxt = request.getParameter("valor");
		
		VendaPagDigital v = new VendaPagDigital();
		v.setProduto(item);
		v.setValorPago(serialVersionUID);
		
		
		PrintWriter htmlSaida = response.getWriter();
		
		
		htmlSaida.print("<p style='color: red'>Venda inserida com sucesso!</p>"); 
		htmlSaida.print("<p>Nome:</p>"+v.getCliente()); 
		
	}

}
