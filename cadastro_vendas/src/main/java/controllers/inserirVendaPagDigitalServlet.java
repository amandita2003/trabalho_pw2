package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomeCliente = request.getParameter("nomeCliente");
		String emailCliente = request.getParameter("emailCliente");
		String nomeProduto = request.getParameter("nomeProduto");
		double valorProduto = Float.parseFloat(request.getParameter("valorProduto"));
		String formaPagamento = request.getParameter("formaPagamento");
		String tipoDeEntrega = request.getParameter("tipoDeEntrega");
		
		//double valor = Double.parseDouble(valorTxt);
		
		VendaPagDigital v = new VendaPagDigital();
		v.setCliente(nomeCliente);
		v.setClienteEmail(emailCliente);
		v.setProduto(nomeProduto);
		v.setTipoEntrega(tipoDeEntrega);
		v.setTipoPagamento(formaPagamento);
		v.setValorPago(valorProduto);
		
		VendaPagDigitalDAO vendaDAO = new VendaPagDigitalDAO(); 
		
		int status = vendaDAO.inserir(v);
		
		request.setAttribute("venda", v);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListaDeVendas.jsp");
		PrintWriter htmlSaida = response.getWriter();
		
		if(formaPagamento.equals("cartao")) {
			v.setStatusPagamento("Pagamento Confirmado");
			
		}
		else {
			v.setStatusPagamento("Aguardando Pagamento");
		}
		

	}
}
